# Overview #

A _Find Plugin_ is a plugin that extends or overrides the basic POSIT Find table. It can add new fields to the existing Find table or even override the table with a complete new table. In addition to new data tables, Find Plugins feature customized layouts and logos.

This document describes the steps it takes to create a new plugin. **Check out the [POSIT wizard](PositxWizard.md)! It automates many of the steps.**

# Step-by-Step Guide #
## 1. Add the following entry to `raw/plugins_preferences.xml` ##
```
<!--  Entry for DummyPlugin -->
<Plugin type="find" name="DummyPlugin Find" user_can_select="false"
    default_find_plugin="true"
    description="Entry for DummyPlugin"
    package="org.hfoss.posit.android.plugin.dummyplugin"
    find_class="org.hfoss.posit.android.plugin.dummyplugin.DummyPluginFind"
    find_factory="org.hfoss.posit.android.api.FindFactory"
    find_activity_class="org.hfoss.posit.android.plugin.dummyplugin.DummyPluginFindActivity"
    find_fragment_class="org.hfoss.posit.android.plugin.dummyplugin.DummyPluginFindFragment"
    extra_activity_class=""
    extra_activity_class2=""
    list_finds_activity_class="org.hfoss.posit.android.plugin.dummyplugin.DummyPluginListFindsActivity"
    find_data_manager="org.hfoss.posit.android.api.database.DbManager"
    preferences_xml="posit_preferences"
    add_find_layout="dummy_plugin_add_find"
    list_find_layout="dummy_plugin_list_row"
    main_list_button_label="viewFinds"
    main_add_button_label="addFind"
    main_extra_button_label=""
    main_extra_button_label2=""
    main_icon="dummy_plugin_logo" />
```

  * **Find class**: a custom Find class that extends the basic Find class and adds whatever new fields you want for your customized POSIT. For instance, if you were doing bird watching POSIT, you'd write a "BirdSighting" class that would add fields like "type" for the type of bird, etc.
  * **Find factory**: Reserved for future use. For now, just put `org.hfoss.posit.android.api.FindFactory`.
  * **Find activity class**: The activity you use to add new finds. It should delegate its work to the Find fragment class.
  * **Find fragment class**: The fragment supporting the Find activity class. We recommend that you write a subclass of FindFragment to properly support custom fields. See Step 5 for more details.
  * **Extra activity class 1 and 2**: If you put activities here, a new button will be added to the main page that opens these activities. Basically for extra activities that don't fit into the framework.
  * **List Finds activity class**: The activity you use to list your finds. It should delegate its work to the List Finds fragment class. See Step 5 for more details.
  * **Preferences xml**:Name of your preferences xml file for custom settings/preferences. Located in res/xml.
  * **Add Find layout**:Name of the layout for your custom Find fragment, without '.xml' at the end.
  * **List Finds layout**:Name of the layout file for your custom List Finds fragment, without '.xml' at the end.
  * **Main list button label**:Name of the string (from strings.xml) that you want displayed on the "view finds" button.
  * **Main add button label**:Name of the string (from strings.xml) that you want displayed on the "add finds" button.
  * **Main extra button labels 1 and 2**:Name of the string (from stings.xml) that you want displayed on the buttons for your extra activities (specified in extra\_activity\_class and extra\_activity\_class2.
  * **Main icon**:Name of the drawable for the icon on the main screen.
**Important**
  * Set **default\_find\_plugin = "false"** for all the other Find plugins.
  * Note the naming convention of classes and layouts.
## 2. Create a new package ##
Add all the classes to this package. Layouts do not go into this package; they go into `res/layout` instead.

If your plugin is DummyPlugin, the package name would be
```
org.hfoss.posit.android.plugin.dummyplugin
```
Do not use spaces, underscores, or numbers; use only lower-case alphabets.
## 3. Implement your Find model class ##
Your Find class represents the data carried by each Find. Indicate the custom fields in the beginning of the class.

Notice that each field requires both a string tag and class field variable. The string tag is used by DBManager to identify the corresponding column in the database table. The class field variable stores the data field while its Find is resident in the main memory.
```
@DatabaseTable(tableName = DbManager.FIND_TABLE_NAME)
public class DummyPluginFind extends Find {
    public static final String TAG = "DummyPluginFind";
    /* tags for custom fields */
    public static final String CUSTOMFIELD = "customfield";

    /* custom fields, with DB annotation */
    @DatabaseField(columnName = CUSTOMFIELD)
    protected String customfield;
...
}
```
In `toString()` method, append the content of each custom field to the JSON string:
```
    @Override
    public String toString()
    {
       StringBuilder sb = new StringBuilder();
       sb.append(ORM_ID).append("=").append(id).append(",");
       sb.append(GUID).append("=").append(guid).append(",");
       sb.append(NAME).append("=").append(name).append(",");
       sb.append(DESCRIPTION).append("=").append(description).append(",");
       
       ... some more default fields ...

       /* adding custom fields */
       sb.append(CUSTOMFIELD).append("=").append(customfield).append(",");

       return sb.toString();
   }
```
Full code:
```
package org.hfoss.posit.android.plugin.dummyplugin;

... imports ...

@DatabaseTable(tableName = DbManager.FIND_TABLE_NAME)
public class DummyPluginFind extends Find {
    public static final String TAG = "DummyPluginFind";
    /* tags for custom fields */
    public static final String CUSTOMFIELD = "customfield";

    /* custom fields, with DB annotation */
    @DatabaseField(columnName = CUSTOMFIELD)
    protected String customfield;

    
    public DummyPluginFind()
    {
        // Necessary by ormlite
    }

   /**
    * Creates the table for this class.
    * 
    * @param connectionSource
    */
    public static void createTable(ConnectionSource connectionSource) {
       Log.i(TAG, "Creating DummyPluginFind table");
       try {
           TableUtils.createTable(connectionSource, DummyPluginFind.class);
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }

    public String getCustomfield()
    {
        return customfield;
    }

    public void setCustomfield(String customfield)
    {
        this.customfield = customfield;
    }


    @Override
    public String toString()
    {
       StringBuilder sb = new StringBuilder();
       sb.append(ORM_ID).append("=").append(id).append(",");
       sb.append(GUID).append("=").append(guid).append(",");
       sb.append(NAME).append("=").append(name).append(",");
       sb.append(DESCRIPTION).append("=").append(description).append(",");
       sb.append(PROJECT_ID).append("=").append(project_id).append(",");
       sb.append(LATITUDE).append("=").append(latitude).append(",");
       sb.append(LONGITUDE).append("=").append(longitude).append(",");
       if (time != null)
           sb.append(TIME).append("=").append(time.toString()).append(",");
       else
           sb.append(TIME).append("=").append("").append(",");
       if (modify_time != null)
           sb.append(MODIFY_TIME).append("=").append(modify_time.toString())
                   .append(",");
       else
           sb.append(MODIFY_TIME).append("=").append("").append(",");
       //sb.append(REVISION).append("=").append(revision).append(",");
       sb.append(IS_ADHOC).append("=").append(is_adhoc).append(",");
       //sb.append(ACTION).append("=").append(action).append(",");
       sb.append(DELETED).append("=").append(deleted).append(",");

       /* adding custom fields */
       sb.append(CUSTOMFIELD).append("=").append(customfield).append(",");

       return sb.toString();
   }
}
```

## 4. Implement layouts ##
### 4.1. Add Find layout ###
This layout defines how your custom Find will appear to the screen. You can write it in any way you want.

Decide whether your Find would include a picture. If so, the layout must include an ImageView with name `photo`:
```
    <ImageView 
       android:id="@+id/photo"
       android:layout_width="fill_parent"
       android:layout_height="wrap_content" />
```

**Important**: To ensure a normal operation for the list manager, your Find layout **must** include a hidden form under name `guidRealValueTextView`. Without this form, POSIT cannot remember the global identifier (GUID) of each Find, and any changes made could be lost.
```
    <TextView
        android:id="@+id/guidRealValueTextView"
        android:visibility="gone"
        android:layout_height="wrap_content"
        android:layout_width="match_parent" />
```

The following is a template for a basic, no-frills layout:
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical" >

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="4dp"
        android:layout_marginBottom="4dp">
        <TextView
            android:id="@+id/nameTextView"
            android:layout_width="75dp"
            android:layout_height="wrap_content"
            android:layout_marginLeft="4dp"
            android:text="@string/name" />
        <EditText
            android:inputType="text"
            android:id="@+id/nameEditText"
            android:singleLine="true"
            android:scrollHorizontally="true"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:layout_marginLeft="4dp"
            android:layout_marginRight="4dp">
            <requestFocus/>
        </EditText>
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="4dp">
        <TextView
            android:id="@+id/descriptionTextView"
            android:layout_width="75dp"
            android:layout_height="wrap_content"
            android:layout_marginLeft="4dp"
            android:text="@string/description" />
        <EditText
            android:inputType="text"
            android:id="@+id/descriptionEditText"
            android:singleLine="true"
            android:scrollHorizontally="true"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:layout_marginLeft="4dp"
            android:layout_marginRight="4dp" />
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="4dp">
        <TextView
            android:id="@+id/customfieldTextView"
            android:layout_width="75dp"
            android:layout_height="wrap_content"
            android:layout_marginLeft="4dp"
            android:text="@string/customfield" />
        <EditText
            android:inputType="text"
            android:id="@+id/customfieldEditText"
            android:singleLine="true"
            android:scrollHorizontally="true"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:layout_marginLeft="4dp"
            android:layout_marginRight="4dp" />
    </LinearLayout>

   <ImageView 
       android:id="@+id/photo"
       android:layout_width="fill_parent"
       android:layout_height="wrap_content" />
    <TextView
        android:id="@+id/guidRealValueTextView"
        android:visibility="gone"
        android:layout_height="wrap_content"
        android:layout_width="match_parent" />
</LinearLayout>
```
### 4.2. List Finds layout ###
This layout defines how the list of Finds would appear in the screen. Keep in mind that the layout really defines the looks of _each entry_ in the list.

The following is a standard layout where custom fields do not appear in the list. Modify the layout if your Finds does not include a picture or if you want custom fields displayed.
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/list_row_rl" android:layout_width="fill_parent"
    android:layout_height="wrap_content" android:orientation="horizontal">

    <ImageView android:id="@+id/find_image" android:src="@drawable/ic_action_camera"
        android:adjustViewBounds="true" android:layout_width="50dp"
        android:layout_height="50dp" android:layout_alignParentTop="true" />
        
    <TextView android:id="@+id/name" android:layout_width="fill_parent"
        android:layout_height="wrap_content" android:singleLine="true"
        android:textSize="15sp" android:layout_marginLeft="3dp"
        android:layout_marginRight="70dp" android:layout_toRightOf="@id/find_image"
        android:layout_alignParentTop="true" />

    <TextView android:id="@+id/synced" android:layout_width="wrap_content"
        android:layout_height="wrap_content" android:textSize="10sp"
        android:layout_alignTop="@id/name"
        android:layout_alignParentRight="true" />

    <TextView android:id="@+id/description_id"
        android:layout_width="fill_parent" android:layout_height="wrap_content"
        android:layout_below="@id/name" android:singleLine="true"
        android:textSize="12sp" android:layout_marginLeft="3dp"
        android:layout_marginRight="50dp" android:layout_toRightOf="@id/find_image" />

    <TextView android:id="@+id/num_photos" android:layout_width="wrap_content"
        android:layout_height="wrap_content" android:textSize="10sp"
        android:layout_below="@id/synced" android:layout_alignTop="@id/description_id"
        android:layout_alignParentRight="true" android:visibility="gone" />

    <!-- android:layout_toRightOf="@id/find_image"/> -->
    <TextView android:id="@+id/latitude"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:layout_marginLeft="3dp" android:layout_marginTop="1dp"
        android:layout_below="@+id/description_id" android:textSize="8sp"
        android:layout_toRightOf="@id/find_image" />

    <TextView android:id="@+id/longitude"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:layout_below="@+id/description_id" android:layout_toRightOf="@id/latitude"
        android:layout_marginTop="1dp" android:layout_marginLeft="3dp"
        android:textSize="8sp" />
        
    <TextView android:id="@+id/time"
        android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:layout_below="@+id/description_id" android:layout_marginTop="1dp"
        android:layout_toRightOf="@+id/longitude" android:layout_marginLeft="3dp"
        android:textSize="8sp" />

    <TextView android:id="@+id/id" android:layout_width="wrap_content"
        android:layout_height="wrap_content" android:layout_alignTop="@+id/latitude"
        android:layout_alignParentRight="true" android:layout_marginRight="2dp"
        android:textSize="8sp" />
</RelativeLayout>
```

## 5. Implement activities and fragments ##
The latest versions of POSIT off-load all work to fragments. The reason is that, at some point in the future, we'd like to implement a multi-pane UI for tablets.

### 5.1. Find fragment class ###
The `retrieveContentFromView()` method fetches the content from the textboxes and creates a new Find. Modify this method to support custom data fields. This method will be a lot different if your Find layout is heavily customized.
```
    @Override
    protected Find retrieveContentFromView()
    {
        DummyPluginFind find =
                (DummyPluginFind)super.retrieveContentFromView();
        
        String value; //used to get the string from the textbox
        
        EditText eText = (EditText)getView().findViewById(R.id.nameEditText);
        value = eText.getText().toString();
        find.setName(value);
        eText = (EditText)getView().findViewById(R.id.descriptionEditText);
        value = eText.getText().toString();
        find.setDescription(value);

        /* custom fields */
        eText = (EditText)getView().findViewById(R.id.customfieldEditText);
        value = eText.getText().toString();
        find.setCustomfield(value);

        
        return find;
    }
```

The `displayContentInView()` method displays the content stored in a Find and displays it on the screen. Modify this method to support custom data fields. This method will be a lot different if your Find layout is heavily customized.

The huge `for` loop at the end of the method is there to load the function plugins, including the Camera plugin. Remove this loop if your plugin does not support function plugins.
```
    @Override
    protected void displayContentInView(Find find)
    {
        Log.i(TAG, "displayContentInView()");
        DummyPluginFind oiFind = (DummyPluginFind)find;
        
        EditText et;
        et = (EditText)getView().findViewById(R.id.nameEditText);
        et.setText(oiFind.getName());
        
        et = (EditText)getView().findViewById(R.id.descriptionEditText);
        et.setText(oiFind.getDescription());

        et = (EditText)getView().findViewById(R.id.customfieldEditText);
        et.setText(oiFind.getCustomfield());

        
        TextView tv = (TextView)getView().findViewById(R.id.guidRealValueTextView);
        tv.setText(oiFind.getGuid());
        
        /**
         * For each plugin, call its displayFindInViewCallback.
         */
        for (FunctionPlugin plugin : mAddFindMenuPlugins) {
            ... a huge for loop ...
        }
    }
```

Full code:
```
package org.hfoss.posit.android.plugin.dummyplugin;

... imports ...

public class DummyPluginFindFragment extends FindFragment {
    
    private static final String TAG = "DummyPluginFindFragment";
    private static final String KEY_INDEX = "DummyPluginFindFragment";
    
    private ArrayList<FunctionPlugin> mAddFindMenuPlugins = null;

    /* Remove if you don't want to load function plugins */
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        Log.i(TAG, "onActivityCreated()");
        mAddFindMenuPlugins = FindPluginManager
                .getFunctionPlugins(FindPluginManager.ADD_FIND_MENU_EXTENSION);
        
        super.onActivityCreated(savedInstanceState);
    }
    
    /**
     * Retrieves values from the DummyPluginFind fields and stores them in a
     * Find instance. 
     * This method is invoked from the Save menu item. It also marks the find
     * 'unsynced' so it will be updated to the server.
     * 
     * @return a new Find object with data from the view.
     */
    @Override
    protected Find retrieveContentFromView()
    {
        DummyPluginFind find =
                (DummyPluginFind)super.retrieveContentFromView();
        
        String value; //used to get the string from the textbox
        
        EditText eText = (EditText)getView().findViewById(R.id.nameEditText);
        value = eText.getText().toString();
        find.setName(value);
        eText = (EditText)getView().findViewById(R.id.descriptionEditText);
        value = eText.getText().toString();
        find.setDescription(value);

        eText = (EditText)getView().findViewById(R.id.customfieldEditText);
        value = eText.getText().toString();
        find.setCustomfield(value);

        
        return find;
    }
    
    @Override
    protected void displayContentInView(Find find)
    {
        Log.i(TAG, "displayContentInView()");
        DummyPluginFind oiFind = (DummyPluginFind)find;
        
        EditText et;
        et = (EditText)getView().findViewById(R.id.nameEditText);
        et.setText(oiFind.getName());
        
        et = (EditText)getView().findViewById(R.id.descriptionEditText);
        et.setText(oiFind.getDescription());

        et = (EditText)getView().findViewById(R.id.customfieldEditText);
        et.setText(oiFind.getCustomfield());

        
        TextView tv = (TextView)getView().findViewById(R.id.guidRealValueTextView);
        tv.setText(oiFind.getGuid());
        
        /**
         * For each plugin, call its displayFindInViewCallback.
         */
        for (FunctionPlugin plugin : mAddFindMenuPlugins) {
            Log.i(TAG, "plugin=" + plugin);
            Class<AddFindPluginCallback> callbackClass = null;
            Object o;
            try {
                View view = getView();
                String className = plugin.getAddFindCallbackClass();
                if (className != null) {
                    callbackClass =
                        (Class<AddFindPluginCallback>) Class.forName(className);
                    o = (AddFindPluginCallback) callbackClass.newInstance();
                    ((AddFindPluginCallback) o).displayFindInViewCallback(
                            getActivity().getApplication(),
                            find,
                            view);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    protected void prepareForSave(Find find)
    {
        if (this.mCurrentLocation != null) {
            find.setLatitude(mCurrentLocation.getLatitude());
            find.setLongitude(mCurrentLocation.getLongitude());
        }
        super.prepareForSave(find);
    }
}
```
### 5.2. List Finds fragment class ###
Inside the List Finds fragment, first implement a list adapter as a inner class:
```
public class DummyPluginListFindsFragment extends ListFindsFragment {
...
    private class DummyPluginFindsListAdapter extends FindsListAdapter {
        private Context context;

        public DummyPluginFindsListAdapter(Context context,
               int textViewResourceId, List list)
        {
            super(context, textViewResourceId, list);
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ...
           
           return v;
        }
   }
}
```

The bulk of work is done in `getView()` method, which inflates the List finds layout and fills it with content. Modify this method if you want to display custom field(s) in the list of Finds.
```
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)getActivity()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.dummy_plugin_list_row, null);
            }
            DummyPluginFind find = (DummyPluginFind)items.get(position);
            if (find != null) {
                TextView tv = (TextView) v.findViewById(R.id.latitude);
                tv.setText(String.valueOf(find.getLatitude()));
                tv = (TextView) v.findViewById(R.id.longitude);
                tv.setText(String.valueOf(find.getLongitude()));
                tv = (TextView) v.findViewById(R.id.name);
                tv.setText(String.valueOf(find.getName()));
                tv = (TextView) v.findViewById(R.id.description_id);
                tv.setText(String.valueOf(find.getDescription()));
                tv = (TextView) v.findViewById(R.id.id);
                tv.setText(Integer.toString(find.getId()));
                tv = (TextView) v.findViewById(R.id.synced);
                tv.setText(find.getStatusAsString());
                tv = (TextView) v.findViewById(R.id.time);
                tv.setText(find.getTime().toLocaleString());
            }

            ArrayList<FunctionPlugin> plugins = FindPluginManager.getFunctionPlugins();
            
            // Call each plugin's callback method to update view
            for (FunctionPlugin plugin: plugins) {
                ... a huge for loop ...
            }
           
           return v;
       }
```
The `getView()` needs to include a `for` loop to include the Camera function plugin. If you don't plan to use photos, take out this loop.
```
        ...
            // Call each plugin's callback method to update view
            for (FunctionPlugin plugin: plugins) {
//                 Log.i(TAG, "Call back for plugin=" + plugin);
                Class<ListFindPluginCallback> callbackClass = null;
                Object o;
                try {
                    String className = plugin.getListFindCallbackClass();
                    if (className != null) {
                        callbackClass = (Class<ListFindPluginCallback>) Class.forName(className);
                        o = (ListFindPluginCallback) callbackClass.newInstance();
                        ((ListFindPluginCallback) o).listFindCallback(context,find,v);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (java.lang.InstantiationException e) {
                    e.printStackTrace();
                }
            }
        ...
```

Full code:
```
package org.hfoss.posit.android.plugin.dummyplugin;

... imports ...

public class DummyPluginListFindsFragment extends ListFindsFragment {
    
   @Override
    protected void displayFind(int index, String action, Bundle extras,
            FindFragment findFragment)
    {
        super.displayFind(index, action, extras, new DummyPluginFindFragment());
    }

    /**
    * Sets up a custom list adapter specific to DummyPlugin finds.
    */
   @Override
   protected ListAdapter setUpAdapter()
   {

       List<? extends Find> list = this.getHelper().getAllFinds();

       int resId = getResources().getIdentifier(
               FindPluginManager.mFindPlugin.mListFindLayout,
               "layout", getActivity().getPackageName());
       
       DummyPluginFindsListAdapter adapter =
               new DummyPluginFindsListAdapter(getActivity(), resId, list);

       return adapter;
   }

   /**
    * Adapter for displaying finds, extends FindsListAdapter to 
    * take care of displaying the extra fields in DummyPluginFind.
    * 
    */
    private class DummyPluginFindsListAdapter extends FindsListAdapter {
        private Context context;

        public DummyPluginFindsListAdapter(Context context,
               int textViewResourceId, List list)
        {
            super(context, textViewResourceId, list);
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)getActivity()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.dummy_plugin_list_row, null);
            }
            DummyPluginFind find = (DummyPluginFind)items.get(position);
            if (find != null) {
                TextView tv = (TextView) v.findViewById(R.id.latitude);
                tv.setText(String.valueOf(find.getLatitude()));
                tv = (TextView) v.findViewById(R.id.longitude);
                tv.setText(String.valueOf(find.getLongitude()));
                tv = (TextView) v.findViewById(R.id.name);
                tv.setText(String.valueOf(find.getName()));
                tv = (TextView) v.findViewById(R.id.description_id);
                tv.setText(String.valueOf(find.getDescription()));
                tv = (TextView) v.findViewById(R.id.id);
                tv.setText(Integer.toString(find.getId()));
                tv = (TextView) v.findViewById(R.id.synced);
                tv.setText(find.getStatusAsString());
                tv = (TextView) v.findViewById(R.id.time);
                tv.setText(find.getTime().toLocaleString());
            }

            ArrayList<FunctionPlugin> plugins = FindPluginManager.getFunctionPlugins();
            
            // Call each plugin's callback method to update view
            for (FunctionPlugin plugin: plugins) {
//                 Log.i(TAG, "Call back for plugin=" + plugin);
                Class<ListFindPluginCallback> callbackClass = null;
                Object o;
                try {
                    String className = plugin.getListFindCallbackClass();
                    if (className != null) {
                        callbackClass = (Class<ListFindPluginCallback>) Class.forName(className);
                        o = (ListFindPluginCallback) callbackClass.newInstance();
                        ((ListFindPluginCallback) o).listFindCallback(context,find,v);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (java.lang.InstantiationException e) {
                    e.printStackTrace();
                }
            }
           
           return v;
       }
   }
}
```
### 5.3. Wrapper activities ###
The activities should just load the corresponding fragments.

Find activity class:
```
package org.hfoss.posit.android.plugin.dummyplugin;

... imports ...

/**
 * FindActivity subclass for DummyPlugin plugin.
 *
 */
public class DummyPluginFindActivity extends FindActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        find = new DummyPluginFindFragment();
        super.onCreate(savedInstanceState);
    }
}
```

List Finds activity class:
```
package org.hfoss.posit.android.plugin.dummyplugin;

... imports ...

public class DummyPluginListFindsActivity extends ListFindsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        finds = new DummyPluginListFindsFragment();
        super.onCreate(savedInstanceState);
    }
}
```

## 6. Add the logo ##
Put it under the `drawable/` folder.
## 7. Add the activities to `AndroidManifest.xml` ##
The activities must use the Sherlock theme. Otherwise, ActionbarSherlock may not properly function.
```
<!-- Activities for DummyPlugin plugin -->
<activity
    android:name="org.hfoss.posit.android.plugin.dummyplugin.DummyPluginFindActivity"
    android:launchMode="singleTop"
    android:screenOrientation="portrait"
    android:configChanges="orientation|keyboardHidden"
    android:windowSoftInputMode="adjustResize"
    android:theme="@style/Theme.Sherlock" />
<activity
    android:name="org.hfoss.posit.android.plugin.dummyplugin.DummyPluginListFindsActivity"
    android:launchMode="singleTop"
    android:configChanges="orientation|keyboardHidden"
    android:theme="@style/Theme.Sherlock" />
```