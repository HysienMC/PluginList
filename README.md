# **PluginLists**  
> **A powerful, user-friendly plugin to manage and explore your Minecraft server’s plugins with ease!**  

---

### **🚀 New Features & Enhancements**  

#### **🛠️ Bug Fixes**  
- Fixed several null pointer exceptions to improve stability.  
- Addressed update check issues causing 403 errors.  
- Enhanced performance during plugin diagnostics for faster load times.

#### **🌟 New Features**  
- **Pagination Support**: Easily navigate through your plugins using `/pluginlist <page>` to view plugins over multiple pages.  
- **Details Command**: Use `/pluginlist details <plugin>` to get detailed info about any installed plugin.  
- **Export to JSON**: Save your plugin list to a `plugins.json` file for backups or sharing with `/pluginlist export`.  
- **Auto-Update Checking**: The plugin now checks for updates automatically at configurable intervals.  
- **Multi-Language Support**: The plugin now supports multiple languages. You can switch between languages via the `/pluginlist lang <language>` command. Available languages include English, Spanish, French, and German.

#### **⚙️ Configuration Improvements**  
The `config.yml` file now includes more customization options for a tailored experience:  
- `pagination.plugins_per_page`: Configure how many plugins to display per page.  
- `autoupdate.enabled`: Toggle automatic update checks on or off.  
- `autoupdate.interval_minutes`: Adjust the interval for checking updates.

#### **🔄 Other Changes**  
- Added notifications for admins when the plugin starts or updates.  
- Enhanced command tab-completion for quick plugin name selection.  
- Refined code structure for improved readability and easier maintenance.

#### **❌ Removed Features**  
- Deprecated methods that relied on removed dependencies.  
- Removed unused or unnecessary features to streamline the plugin.

---

### **📋 Fixed Issues**  
- Fixed bugs with YAML handling to improve configuration parsing.  
- Resolved rare crashes that occurred when querying specific plugins.  
- Improved compatibility with Spigot 1.13+ API to ensure smooth operation on newer versions.

---

### **📖 Commands & Syntax**  

| **Command**                      | **Description**                                                                 |
|----------------------------------|---------------------------------------------------------------------------------|
| `/pluginlist <page>`             | View your installed plugins with pagination (e.g., `/pluginlist 1`).            |
| `/pluginlist export`             | Export the complete plugin list to a JSON file (`plugins.json`).               |
| `/pluginlist details <plugin>`   | View detailed information about a specific plugin.                             |
| `/pluginlist reload`             | Reload the plugin’s configuration without restarting the server.              |
| `/pluginlist checkupdates`       | Manually trigger a plugin update check.                                        |

---

### **📌 Important Notes**  
- **Tested with Spigot 1.13+** and requires **Java 11 or higher** to run.  
- **bStats** integration is enabled to collect anonymous usage statistics for improving future updates.  
- For more details, visit the [PluginLists SpigotMC page](https://www.spigotmc.org/resources/pluginlists-view-and-manage-your-servers-installed-plugins-with-ease.122125/).

---

### **💰 Support PluginLists**  

If you find **PluginLists** useful and would like to support its development, consider making a donation! Every contribution helps to improve and maintain the plugin.

💳 **Donate via PayPal**: [paypal.me/ArdieBanadera](https://paypal.me/ArdieBanadera)

Your support is greatly appreciated and helps keep **PluginLists** updated with new features and fixes. Thank you for your generosity! 🙏

---
