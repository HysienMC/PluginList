# **PluginLists**  
> **A powerful and user-friendly plugin for managing and exploring your server's plugins!**  

---

### **🚀 Changes in This Release**  

#### **🛠️ Bug Fixes:**  
- Fixed multiple null pointer exceptions.  
- Resolved update check issues returning 403 errors.  
- Enhanced performance during plugin diagnostics.  

#### **🌟 New Features:**  
- **Pagination Support**: Use `/pluginlist <page>` to browse plugins easily across multiple pages.  
- **Details Command**: `/pluginlist details <plugin>` now displays in-depth information about specific plugins.  
- **Export to JSON**: Save plugin lists to a JSON file using `/pluginlist export`.  
- **Automatic Updates**: Configurable auto-update checks at user-defined intervals.  

#### **⚙️ Improved Configuration:**  
The `config.yml` has been updated to include more customizable options:  
- `pagination.plugins_per_page`: Set the number of plugins displayed per page.  
- `autoupdate.enabled`: Enable or disable automatic update checks.  
- `autoupdate.interval_minutes`: Set the interval for update checks.  

#### **🔄 Other Additions and Changes:**  
- Notifications for admins on plugin startup or updates.  
- Command tab-completion, including plugin names for easier usage.  
- Refactored code for better readability and maintainability.  

#### **❌ Removed Features:**  
- Deprecated methods that relied on removed dependencies.  
- Removed unused and unnecessary methods to streamline the plugin.  

---

### **📋 Fixed Issues**  
- Resolved YAML handling bugs.  
- Fixed rare crashes caused by specific plugin queries.  
- Addressed compatibility issues with Spigot 1.13+ API.  

---

### **📖 Commands & Syntax**  

| **Command**                      | **Description**                                                                 |
|----------------------------------|---------------------------------------------------------------------------------|
| `/pluginlist <page>`             | View installed plugins with pagination.                                         |
| `/pluginlist export`             | Export all installed plugins to `plugins.json`.                                |
| `/pluginlist details <plugin>`   | Get detailed information about a specific plugin.                              |
| `/pluginlist reload`             | Reload the plugin’s configuration.                                             |
| `/pluginlist checkupdates`       | Manually check for updates.                                                    |

---

### **📌 Notes**  
- This version is **tested with Spigot 1.13+** and requires **Java 11 or higher**.  
- Anonymous usage statistics are collected via **bStats** to improve future updates.  

For more information, visit our **[SpigotMC page]([https://www.spigotmc.org/](https://www.spigotmc.org/resources/pluginlists-view-and-manage-your-servers-installed-plugins-with-ease.122125/))**!  
