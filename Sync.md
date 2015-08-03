# Introduction #

In order to add a new synchronization method, simply inherit from the SyncMedium or any of its children.

The existing sync classes can be overridden in any way the developer sees fit. The existing sync classes can be used as a basis for development of new sync types.


# Details #

The SyncMedium class provides several functions to assist with the creation of new sync methods:
  * Convert Finds to Strings
  * Convert Strings to Finds
  * Saving a Find to device
  * Getting a list of changed Finds from device
  * Sending/Receiving all unsynced Finds at once

Note that any existing functionality can be overridden as needed in the child class.

# Example #

This is how you would implement the new sync class:
```
public class SyncServer extends SyncMedium{
   public SyncNewType( Context context ){
      m_context = context;
   }

   public List<String> getFindsNeedingSync(){
      //Get a list of finds that are unsynced with target device
   }

   public String retrieveRawFind( String guid ){
      //Get a specific Find based on guid
   }

   public boolean sendFind( Find find ){
      //Send a Find to target device
   }

   public boolean postSendTasks(){
      //Optional, any clean up after sending Finds
   }
}
```

This is how you would use the new sync class:
```
public void onPerformSync( Context context, String authToken ){
   SyncNewType syncNewType = new SyncNewType( context );
   syncNewType.sync( authToken );
}
```

# Using Existing Sync Process #

There is an existing sync process that can be overridden if needed. If using this existing process there are a few requirements:
  * A Context is provided
  * An AuthToken is provided
  * The following methods are implemented based on what you're syncing with:

```
	/**
	 * Returns a list of find guids that are not synced to the current device
	 * @return list of guids
	 */
	public abstract List<String> getFindsNeedingSync();
	
	/**
	 * Retrieves raw find data in string from based on the passed guid
	 * @param guid of the find to be retrieved
	 * @return raw form of find data
	 */
	public abstract String retrieveRawFind( String guid );
	
	/**
	 * Sends a find to another device
	 * @param find to be sent
	 * @return whether or not sending was successful
	 */
	public abstract boolean sendFind( Find find );
	
	/**
	 * Any tasks that need to be performed after sending finds
	 * @return whether or not tasks were successful
	 */
	public abstract boolean postSendTasks();
```