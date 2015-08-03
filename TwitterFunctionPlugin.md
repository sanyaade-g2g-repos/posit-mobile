# Introduction #

Twitter is an online social networking service that allows users to share short (140 character) messages. This network has a proven to be a proven way of sharing information in a scalable fashion which would be an useful feature in situations where we would want to publicly share finds. Twitter would provide us ways to group Finds using Hashtags which could be a cheap mechanism in dynamically gathering Finds from many people (given that they have Twitter accounts).


# Walkthrough #
  1. The function can be triggered in the add find activity when the user selects the menu button.
  1. ![http://img.photobucket.com/albums/v200/smanx3000/smalladdfindmenu.png](http://img.photobucket.com/albums/v200/smanx3000/smalladdfindmenu.png)
  1. If the user is not logged into Twitter. A toast will appear.
  1. ![http://img.photobucket.com/albums/v200/smanx3000/addfindmenunotloggedin-1.png](http://img.photobucket.com/albums/v200/smanx3000/addfindmenunotloggedin-1.png)
  1. The user must log in from the Main Settings > Preferences from the main activity screen.
  1. ![http://img.photobucket.com/albums/v200/smanx3000/smallsettingspreferences.png](http://img.photobucket.com/albums/v200/smanx3000/smallsettingspreferences.png)
  1. The user will log in through the Twitter website. This step allows Twitter to give authorization. And enables us to not worry about securely storing the external username and passwords.
  1. ![http://img.photobucket.com/albums/v200/smanx3000/smalllogin.png](http://img.photobucket.com/albums/v200/smanx3000/smalllogin.png)
  1. Now when we try to twit a find, it should report a success.
  1. ![http://img.photobucket.com/albums/v200/smanx3000/smallsuccess.png](http://img.photobucket.com/albums/v200/smanx3000/smallsuccess.png)
  1. ![http://img.photobucket.com/albums/v200/smanx3000/tweet.png](http://img.photobucket.com/albums/v200/smanx3000/tweet.png)

# Integration #
As the walkthrough shows, the default behaviour of the function is not very readable or interesting. To create a more meaningful message, the programmer of the find plugin would have to do some work to format the find to remove unneccessary information.

The functional plugin will look for a field called tweetFindString in the Find activity. The presence of this specific field will override the default behaviour of displaying all the fields.
  * ![http://img.photobucket.com/albums/v200/smanx3000/findplugin.png](http://img.photobucket.com/albums/v200/smanx3000/findplugin.png)
In the above sample code, the twitter message would display "OutsideIn01". The developer of the find plugin can further manipulate the string to contain dynamic information.

# Issues #
  * [Issue 298](https://code.google.com/p/posit-mobile/issues/detail?id=298) - Explanation of a situation which could occur.
  * [Issue 299](https://code.google.com/p/posit-mobile/issues/detail?id=299) - Incorporate Images.