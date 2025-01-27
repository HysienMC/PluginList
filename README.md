PluginLists
Changes:
Bug Fixes:

Fixed multiple null pointer exceptions.
Resolved issues with update checks returning 403 errors.
Improved performance during plugin diagnostics.
New Features:

Added pagination support to /pluginlist for easier navigation of plugins.
Introduced a details command: /pluginlist details <plugin> to display detailed information about specific plugins.
Added the ability to export plugin lists in JSON format using /pluginlist export.
Enabled automatic update checking with configurable intervals.
Improved Configuration:

Added new options to config.yml for better customization:
pagination.plugins_per_page: Set how many plugins to display per page.
autoupdate.enabled: Toggle automatic update checks.
autoupdate.interval_minutes: Configure the update interval.
Other Additions and Changes:

Notifications for admins when the plugin starts or updates.
Added tab-completion for commands, including plugin names for quick selection.
Refactored code to improve readability and maintainability.
Removed Features:

Deprecated outdated methods that relied on removed dependencies.
Removed unused or unnecessary methods to streamline functionality.
Fixed Issues:

Resolved YAML handling bugs.
Fixed rare crashes when handling specific plugin queries.
Fixed compatibility issues with Spigot 1.13+ API.
New Syntax and Commands:
/pluginlist <page>: View all installed plugins with pagination.
/pluginlist export: Save a list of all plugins to plugins.json.
/pluginlist details <plugin>: Get detailed information about a specific plugin.
/pluginlist reload: Reload the plugin’s configuration.
/pluginlist checkupdates: Manually check for updates.
Notes:
This version is tested with Spigot 1.13 and higher.
Requires Java 11+ to run.
Added bStats integration to track plugin usage anonymously.
For more information, visit: SpigotMC Page
