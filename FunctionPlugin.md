## How to Create A Function Plugin ##

A _function plugin_ is a module that can be added to _extension\_points_ that are sprinkled throughout POSIT.  POSIT can have multiple function plugins.  They typically define a function that might be useful to a wide range of POSIT applications.

## Step By Step Guide ##

### Create a Plugin Specification in In Plugin Preferences File ###
This example creates of plugin that saves Finds to a log file.  Here is the description of the plugin in _plugin\preferences.xml_:

```
<Plugin active="true" 
   type="function" 
   extensionPoint="listMenu"
   menuIcon="ic_menu_savetolog" 
   name="log" 
   menuTitle="Log Finds"
   menuActivity="org.hfoss.posit.android.experimental.functionplugins.LogFindsActivity" 
/>
```

This specifies a _function plugin_ that will be attached to a _listMenu_ extension point.  That is, this plugin is attached to a menu. When its menu item is selected, the specified _activity_ will be launched.

### Plugin Manager Parses the Plugin Spec ###

The plugin specification will be parsed by PluginManager.  For now, it just creates a set of static variables that can be polled to manage the plugin:

```
else if (plugin_nodes.item(ii).getAttributes().getNamedItem("type").getTextContent().equals("function") 
   && plugin_nodes.item(ii).getAttributes().getNamedItem("extensionPoint").getTextContent().equals("listMenu")) {
					
   mListFindsMenuExtensionPoint = plugin_nodes.item(ii).getAttributes().getNamedItem("extensionPoint")
								.getTextContent();
   mListFindsMenuActivity = (Class<Activity>) Class.forName(plugin_nodes.item(ii).getAttributes()
								.getNamedItem("menuActivity").getTextContent());
   mListFindsMenuIcon = plugin_nodes.item(ii).getAttributes().getNamedItem("menuIcon").getTextContent();
   mListFindsMenuTitle = plugin_nodes.item(ii).getAttributes().getNamedItem("menuTitle").getTextContent();
}
```

### Insert Code At the Extension Point ###

Here's the code that is inserted in _ListFindsActivity_.  Note that because this is a _Menu_ extension point, we include code in the Options Menu. We use _PluginManager_ to get data associated with the plugin, such as the menu title.

```
private boolean mListFindsMenuExtensionPoint = false;
...
@Override
protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   ...
   mListFindsMenuExtensionPoint = FindPluginManager.mListFindsMenuExtensionPoint != null;
   ...
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
   MenuInflater inflater = getMenuInflater();
   if (mListFindsMenuExtensionPoint){
      MenuItem item = menu.add(FindPluginManager.mListFindsMenuTitle);
      item.setIcon(android.R.drawable.ic_menu_save);
   }
   inflater.inflate(R.menu.list_finds_menu, menu);
   return true;
}

@Override
public boolean onMenuItemSelected(int featureId, MenuItem item) {
   Log.i(TAG, "onMenuitemSelected()");
   Intent intent;
   switch (item.getItemId()) {
   ...
   default:
      if (mListFindsMenuExtensionPoint){
         startActivity(new Intent(this, FindPluginManager.mListFindsMenuActivity));
      }
      break;
}
```

Note that when the plugin's menu item is selected, we simply start its Activity.  Its Activity can be any Android Activity, including ones that require extras.

### Edit the Android Manifest ###

If your plugin involves an Activity, you must add a line such as this to the Android Manifest.

```
<activity android:name="org.hfoss.posit.android.experimental.functionplugins.LogFindsActivity" />

```

### The Plugin Activity Class ###

For this example, the [Activity class](http://code.google.com/p/posit-mobile/source/browse/src/org/hfoss/posit/android/experimental/functionplugins/LogFindsActivity.java?spec=svn.plugin.9b23e19e52f327b23e518e341545c2c744e5f2fb&repo=plugin&name=test_branch&r=9b23e19e52f327b23e518e341545c2c744e5f2fb) simply writes all Finds to a log file on the SD Card.
