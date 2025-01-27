# **PluginLists**  
> **A powerful, user-friendly plugin to manage and explore your Minecraft server’s plugins with ease!**  

---

## 🚀 **New Features & Enhancements**  

### 🛠️ **Bug Fixes**  
- **Fixed** several null pointer exceptions to enhance stability.  
- **Addressed** update check issues causing 403 errors.  
- **Improved** performance during plugin diagnostics, resulting in faster load times.

### 🌟 **New Features**  
- **Pagination Support**: Easily navigate through your plugins using `/pluginlist <page>` to view plugins over multiple pages.  
- **Details Command**: Get detailed info about any installed plugin with `/pluginlist details <plugin>`.  
- **Export to JSON**: Save your plugin list to a `plugins.json` file for backups or sharing via `/pluginlist export`.  
- **Auto-Update Checking**: The plugin now automatically checks for updates at configurable intervals.  
- **Multi-Language Support**: Switch between supported languages (English, Spanish, French, German) using `/pluginlist lang <language>`. 

---

## ⚙️ **Configuration Improvements**  
The `config.yml` file now offers more customization options for a tailored experience:

- `pagination.plugins_per_page`: Configure how many plugins to display per page.  
- `autoupdate.enabled`: Toggle automatic update checks on or off.  
- `autoupdate.interval_minutes`: Adjust the interval for checking updates.

---

## 🔄 **Other Changes**  
- **Admin Notifications**: Added notifications for admins when the plugin starts or updates.  
- **Enhanced Command Tab-Completion**: Quickly select plugin names with enhanced tab-completion.  
- **Code Refactoring**: Refined the code structure for improved readability and easier maintenance.

---

## ❌ **Removed Features**  
- Deprecated methods that relied on removed dependencies.  
- Removed unused or unnecessary features to streamline the plugin.

---

## 📋 **Fixed Issues**  
- **YAML Handling**: Fixed bugs to improve configuration parsing.  
- **Crash Prevention**: Resolved rare crashes that occurred when querying specific plugins.  
- **Compatibility**: Improved compatibility with Spigot 1.13+ API to ensure smooth operation on newer versions.

---

## 📖 **Commands & Syntax**  

| **Command**                        | **Description**                                                                 |
|------------------------------------|---------------------------------------------------------------------------------|
| `/pluginlist <page>`               | View your installed plugins with pagination (e.g., `/pluginlist 1`).            |
| `/pluginlist export`               | Export the complete plugin list to a JSON file (`plugins.json`).               |
| `/pluginlist details <plugin>`     | View detailed information about a specific plugin.                             |
| `/pluginlist reload`               | Reload the plugin’s configuration without restarting the server.              |
| `/pluginlist checkupdates`         | Manually trigger a plugin update check.                                        |

---

## 📌 **Important Notes**  
- **Tested with Spigot 1.13+** and requires **Java 11 or higher** to run.  
- **bStats** integration is enabled to collect anonymous usage statistics for improving future updates.  
- For more details, visit the [PluginLists SpigotMC page](https://www.spigotmc.org/resources/pluginlists-view-and-manage-your-servers-installed-plugins-with-ease.122125/).

---

## 💰 **Support PluginLists**  

If you find **PluginLists** useful and would like to support its development, consider making a donation! Every contribution helps to improve and maintain the plugin.

### 💳 **Donate via PayPal**:  
[paypal.me/ArdieBanadera](https://paypal.me/ArdieBanadera)

Your support is greatly appreciated and helps keep **PluginLists** updated with new features and fixes. Thank you for your generosity! 🙏

---
