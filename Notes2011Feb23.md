# Stas' update in Ralph's repo #
  * removes compiler warnings

# Shawn's proposal #
  * mention examples in motivation section
  * implementation
    * **post first sketches
  * let HCI people play with the original UI and post their comments**

# Eran #
  * Save server name
    * **Implement the client side server list first
    *** Users must register with the server before it can be used, you can't just join random servers
    * **Possibly add an auto complete to the server entry (based on previously used servers)
    *** Every time the user types in a server it is saved to the list
      *  The list then becomes populated and the user doesn't have to type the server name in again
      *  Only save the server name if it is a valid server
        *  **eliminates erroneous server names
      *** **Save automatically? Save after server typed in? Save after frist connection to the server? Have the user select the option to save the server?
    *** Have server list design for next week
  * Search/Sort finds
    * **How would the user interface look/ what would the user have to do?
    *** Link to examples of other apps that do sorting

# Stas #
  * Plugin support
    * **describe the design
      *** **what would the creator of the plugin have to produce and how can the rest of the app use that data (display the new data, etc)
      *** **IO for the plugin
    *** design a prototype showing how to switch plugins and use the info of the plugins
    * **create the infrastructure so that plugin developers don't need to know about the posit code
    *** design the architecture to present to the group