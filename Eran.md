# Contribution to POSIT Spring 2011 #
  * I added support for orientation changes (portrait vs. landscape) to all activities so that the user interface will not restart the activity when reorienting.
  * I blocked the settings and back options from the logged in user before selecting a project.
  * I re-factored the project selection feature and dialog box so that the user can cancel the project selection in case a previous project is already selected.
  * I introduced a sorting functionality, by description or date, to the finds list view so that the user could have a better usability experience.
  * I fixed the bug that occurred with the projects a user can access when registering a new user to the device.
  * I added a new dialog box that pops up after a new user has been registered. The dialog box present the user with the option of logging in the new created user or keeping the current one logged in.
  * I changed the schema of the database to include a new table that holds all the favorite servers for the current POSIT installation.
  * In order to complement the introduced database table, I included two functions that fetch all servers from the table and add a new server to the table.
  * I added a new button in the settings that allows the user to save the current server to the list of favorite servers.
  * I added a new button in the settings that opens the dynamic list of favorite servers to the user, asking the user to select a new server or cancelling the change.
  * Cloned Greg's search functionality work in order to work on the pending bugs.

Pending work:
  * Fix bug with server change from favorite list that launches onSharedPreferenceChanged multiple time (because of the server preference update).
  * Search functionality still has bugs when selecting a search result.




# Planned Project Proposal #

# Overview #

My project proposal consists of two mutually exclusive features that I would like to introduce to POSIT. The first one is a mechanism to handle fast switching between servers a user is members of. The second one is a list sorting and searching feature for the finds list.

# 1) Quick Server Switch Project #
## Problem ##
Users cannot save or document the list of servers they frequently use. Since users can be connected to one server at a time, users are required to re-enter the names manually over and over again, which is very time consuming and not user friendly.

## Goals ##
  * Allow users to insert new server names quickly.
  * Allow users to switch between servers quickly.

## Solution ##
The proposed solution is to add a new feature on the client side of POSIT. This is because each user is a member of one or more servers and there is no internal hub that can hold main user preferences. The list of servers will be saved only on the Android phone database for the app.
  * Add a Server: When the user is successfully connected to a server, the user will be able to go to settings and add the server to the list by clicking a button.
  * Switch Server: The user will be able to go to settings and click on the button that will launch the servers list. The user will be able to select on of these servers, or cancel the action.
  * Delete Server: When on the servers list view, each entry will have a select box and the user will be able to select few entries in order to delete them if necessary.

# 2) Sort/Search Finds #
## Problem ##
Currently the finds are shown in a list that cannot be sorted or searched through. The amount of finds on a specific project can reach a high amount and it will be cumbersome to search manually for a specific entry.

## Goals ##
  * Allow users to sort the finds according to specific criteria
  * Allow users to search the finds

## Solution ##
### Sort ###
The solution is to first introduce a sorting feature to allow users to sort the finds alphabetically according to their description and by date according to the time when the find was updated.

See below various screenshots of implementation of sort on Android:
[Screenshot1](http://t3.gstatic.com/images?q=tbn:ANd9GcTt6xhtRCWxvefdh5DwpwuyiZn0j039hFSkjrJOvU660E6pgOQY6A)
[Screenshot2](http://t1.gstatic.com/images?q=tbn:ANd9GcS2JPTO3ur8bfC57BS1rtdwE92IARhbbtWSKdu3t87gLA998kLv4A)
[Screenshot3](http://www.blogcdn.com/www.engadget.com/media/2009/02/android-rc33-02-04-09.jpg?dfgdf=dfgdf)



### Search ###
Then the second step will be to introduce a searching mechanism to the finds so that users will be enter to selectively find one of the finds objects. These two changes can be done on the client side only since all finds exist on the mobile device and no requests to the server have to be placed.
  * Some work on the search feature was already done by g2knox-capstone:
    * [Adding Search Feature](http://code.google.com/r/g2knox-capstone/source/detail?r=f8ac72c7fe4439e7f2ec6a68a148ecbd852d2d20)
    * [Updating search feature more; Needs other to test](http://code.google.com/r/g2knox-capstone/source/detail?r=a66cc5e8feed7ae55683a1596863c4cf9d15ad13)