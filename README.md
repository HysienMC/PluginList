PluginLists
A powerful and user-friendly plugin manager for your Minecraft server!


Features
📜 View Installed Plugins:
Quickly view all installed plugins with pagination and optional search filters.

🛠️ Diagnostics:
Generate diagnostic reports for all plugins to troubleshoot issues.

📂 Export Plugin List:
Export all installed plugins into a JSON file for easy sharing and documentation.

🔄 Configuration Reload:
Reload the plugin configuration dynamically without restarting the server.

🔔 Update Notifications:
Automatically checks for new versions and notifies admins about available updates.

🎛️ Highly Configurable:
Fine-tune the plugin’s behavior via config.yml.

Commands
Command	Description	Permission
/pluginlist <page>	View installed plugins (paginated).	pluginlist.use
/pluginlist export	Export plugin list to JSON.	pluginlist.use
/pluginlist diagnostics	Generate a diagnostics report.	pluginlist.use
/pluginlist details <plugin>	View detailed info about a specific plugin.	pluginlist.use
/pluginlist reload	Reload plugin configuration.	pluginlist.admin
/pluginlist checkupdates	Check for updates manually.	pluginlist.admin
Installation
Download the latest release of PluginLists from the SpigotMC page.
Place the .jar file in your server’s plugins folder.
Restart your server.
Optional: Edit the config.yml file to customize the plugin settings.
Configuration (config.yml)
yaml
Copy
Edit
pagination:
  plugins_per_page: 5    # Number of plugins to display per page

autoupdate:
  enabled: true          # Automatically check for updates
  interval_minutes: 60   # Interval for update checks in minutes

notifications:
  on_startup: true       # Notify admins when the plugin is loaded

export:
  filename: plugins.json # Default filename for exported plugin list
  pretty_format: false   # Format JSON in a human-readable way
Examples
View Installed Plugins
Run /pluginlist to view all plugins, or /pluginlist <page> for specific pages.
Example output:

diff
Copy
Edit
--- Plugin List ---
Page 1 of 2
- Essentials (v2.19.4)
- WorldEdit (v7.2.12)
- Vault (v1.7.3)
Use /pluginlist <page> to navigate.
Export Plugins
Run /pluginlist export to save all plugin information to plugins.json.

Check Updates
Run /pluginlist checkupdates to manually check for updates.

Contributing
We welcome contributions! If you'd like to contribute:

Fork this repository.
Create a new branch for your feature or bugfix.
Submit a pull request with a detailed description of your changes.
Issues and Support
If you encounter any issues, please open an issue in this GitHub repository or contact us through the SpigotMC discussion thread.

License
This project is licensed under the MIT License. See the LICENSE file for details.

Acknowledgments
Special thanks to the Minecraft community for their support and inspiration.

