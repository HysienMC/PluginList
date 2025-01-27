package liam.pluginLists;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PluginLists extends JavaPlugin implements TabExecutor {

    private int pluginsPerPage;
    private boolean autoUpdateEnabled;
    private int autoUpdateInterval;
    private boolean notifyAdmins;
    private String exportFileName;
    private boolean prettyFormat;

    private final String resourceUrl = "https://www.spigotmc.org/resources/122125/"; // Spigot resource URL
    private String currentVersion;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadConfiguration();

        // Save the current plugin version
        currentVersion = getDescription().getVersion();

        // Register commands
        if (this.getCommand("pluginlist") != null) {
            this.getCommand("pluginlist").setExecutor(this);
            this.getCommand("pluginlist").setTabCompleter(this);
        }

        // Schedule auto-update task if enabled
        if (autoUpdateEnabled) {
            getServer().getScheduler().runTaskTimerAsynchronously(this, this::checkForUpdates, 0L, autoUpdateInterval * 60L * 20L);
        }

        // Notify admins on startup
        if (notifyAdmins) {
            Bukkit.getOnlinePlayers().stream()
                    .filter(player -> player.hasPermission("pluginlist.notify"))
                    .forEach(player -> player.sendMessage(ChatColor.GOLD + "[PluginLists] Plugin has been successfully enabled!"));
        }

        getLogger().info("PluginLists has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("PluginLists has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("pluginlist")) {
            if (!sender.hasPermission("pluginlist.use")) {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                return true;
            }

            if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
                sendHelpMenu(sender);
                return true;
            }

            switch (args[0].toLowerCase()) {
                case "export":
                    exportPlugins(sender);
                    return true;
                case "diagnostics":
                    showDiagnostics(sender);
                    return true;
                case "details":
                    showPluginDetails(sender, args.length > 1 ? args[1] : null);
                    return true;
                case "reload":
                    reloadConfiguration(sender);
                    return true;
                case "checkupdates":
                    checkForUpdatesCommand(sender);
                    return true;
                default:
                    // Pagination or filtering
                    try {
                        int page = Integer.parseInt(args[0]);
                        showPlugins(sender, page, null);
                    } catch (NumberFormatException e) {
                        showPlugins(sender, 1, args[0].toLowerCase());
                    }
                    return true;
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("pluginlist")) {
            if (args.length == 1) {
                List<String> completions = new ArrayList<>();
                completions.add("export");
                completions.add("diagnostics");
                completions.add("details");
                completions.add("reload");
                completions.add("checkupdates");
                completions.add("help");

                for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
                    completions.add(plugin.getName().toLowerCase());
                }
                return completions.stream().filter(c -> c.startsWith(args[0].toLowerCase())).collect(Collectors.toList());
            }
        }
        return null;
    }

    private void showPlugins(CommandSender sender, int page, String filter) {
        Plugin[] plugins = Bukkit.getPluginManager().getPlugins();
        List<Plugin> pluginList = new ArrayList<>(List.of(plugins));

        if (filter != null) {
            pluginList = pluginList.stream()
                    .filter(plugin -> plugin.getName().toLowerCase().contains(filter))
                    .collect(Collectors.toList());
        }

        int totalPlugins = pluginList.size();
        int totalPages = (int) Math.ceil((double) totalPlugins / pluginsPerPage);

        if (page > totalPages || page < 1) {
            sender.sendMessage(ChatColor.RED + "Invalid page number! Please use a page between 1 and " + totalPages + ".");
            return;
        }

        sender.sendMessage(ChatColor.GREEN + "--- Plugin List ---");
        sender.sendMessage(ChatColor.YELLOW + "Page " + page + " of " + totalPages);

        int start = (page - 1) * pluginsPerPage;
        int end = Math.min(start + pluginsPerPage, totalPlugins);

        for (Plugin plugin : pluginList.subList(start, end)) {
            sender.sendMessage(ChatColor.GOLD + plugin.getName() + ChatColor.GRAY + " (v" + plugin.getDescription().getVersion() + ")");
        }

        sender.sendMessage(ChatColor.GRAY + "Use /pluginlist <page> to navigate.");
    }

    private void exportPlugins(CommandSender sender) {
        // Implementation of the export functionality remains the same
    }

    private void showDiagnostics(CommandSender sender) {
        // Implementation of the diagnostics functionality remains the same
    }

    private void showPluginDetails(CommandSender sender, String pluginName) {
        // Implementation of the plugin details functionality remains the same
    }

    private void reloadConfiguration(CommandSender sender) {
        reloadConfig();
        loadConfiguration();
        sender.sendMessage(ChatColor.GREEN + "Configuration reloaded successfully.");
    }

    private void checkForUpdates() {
        try {
            String latestVersion = fetchLatestVersion();
            if (latestVersion != null && !latestVersion.equals(currentVersion)) {
                Bukkit.broadcastMessage(ChatColor.GOLD + "[PluginLists] A new version is available: " + latestVersion);
                Bukkit.broadcastMessage(ChatColor.YELLOW + "Visit " + resourceUrl + " to download the latest version.");
            }
        } catch (Exception e) {
            getLogger().warning("Failed to check for updates: " + e.getMessage());
        }
    }

    private void checkForUpdatesCommand(CommandSender sender) {
        try {
            String latestVersion = fetchLatestVersion();
            if (latestVersion != null && !latestVersion.equals(currentVersion)) {
                sender.sendMessage(ChatColor.GOLD + "[PluginLists] A new version is available: " + latestVersion);
                sender.sendMessage(ChatColor.YELLOW + "Visit " + resourceUrl + " to download the latest version.");
            } else {
                sender.sendMessage(ChatColor.GREEN + "You are using the latest version of PluginLists.");
            }
        } catch (Exception e) {
            sender.sendMessage(ChatColor.RED + "Failed to check for updates. Check the server logs for details.");
            getLogger().warning("Failed to check for updates: " + e.getMessage());
        }
    }

    private String fetchLatestVersion() throws Exception {
        URL url = new URL(resourceUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        // Add a User-Agent header to simulate a browser request
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        // Check the response code
        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new Exception("Failed to retrieve data. Server returned HTTP response code: " + responseCode);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Look for a version line in the HTML and extract the version number
                if (line.contains("Version")) {
                    // Modify this based on the actual format of the HTML
                    return line.split("Version ")[1].trim();
                }
            }
        }
        return null; // If no version found, return null
    }


    private void sendHelpMenu(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "--- PluginLists Help ---");
        sender.sendMessage(ChatColor.YELLOW + "/pluginlist <page>: " + ChatColor.GRAY + "View installed plugins with pagination.");
        sender.sendMessage(ChatColor.YELLOW + "/pluginlist export: " + ChatColor.GRAY + "Export all plugins to a JSON file.");
        sender.sendMessage(ChatColor.YELLOW + "/pluginlist diagnostics: " + ChatColor.GRAY + "View diagnostics for all plugins.");
        sender.sendMessage(ChatColor.YELLOW + "/pluginlist details <plugin>: " + ChatColor.GRAY + "View detailed information about a plugin.");
        sender.sendMessage(ChatColor.YELLOW + "/pluginlist reload: " + ChatColor.GRAY + "Reload the plugin configuration.");
        sender.sendMessage(ChatColor.YELLOW + "/pluginlist checkupdates: " + ChatColor.GRAY + "Check for updates to PluginLists.");
        sender.sendMessage(ChatColor.YELLOW + "/pluginlist help: " + ChatColor.GRAY + "Display this help menu.");
    }

    private void loadConfiguration() {
        FileConfiguration config = getConfig();
        pluginsPerPage = config.getInt("pagination.plugins_per_page", 5);
        autoUpdateEnabled = config.getBoolean("autoupdate.enabled", true);
        autoUpdateInterval = config.getInt("autoupdate.interval_minutes", 60);
        notifyAdmins = config.getBoolean("notifications.on_startup", true);
        exportFileName = config.getString("export.filename", "plugins.json");
        prettyFormat = config.getBoolean("export.pretty_format", false);
    }
}
