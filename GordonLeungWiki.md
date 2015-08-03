# Introduction #

My name is Gordon Leung and I'm a 4th year SFU computing science student with a software engineering specialization. My technical interests are in databases, networking, and mobile technologies.

# Project Proposal #

[Revised Project Proposal PDF version](https://docs.google.com/viewer?a=v&pid=explorer&chrome=true&srcid=0B-PXyIyZEU0NNmE1NjlkNmYtOTRkYy00NjgyLWFhN2MtMTkxNDIwNTk4MzYw&hl=en)

# Documentation of Project Result #

[Camera plugin with syncing](Camera_plugin_with_syncing.md)

# Weekly Progress #
In reverse chronological order

Dec. 13, 2011 - **SFU wants grades in by this date.**
  * Worked around the emulator error by commenting out code some code.
  * Integrated code to display picture taken in the find itself. The data is saved in the phone's mediastore. [issue 276](https://code.google.com/p/posit-mobile/issues/detail?id=276)
  * Integrated code to send the pictures to the server. [issue 279](https://code.google.com/p/posit-mobile/issues/detail?id=279)
  * Fixed a minor icon issue. [issue 280](https://code.google.com/p/posit-mobile/issues/detail?id=280)
  * Had to ditch content providers in order to write photo data into internal storage so that it would be removed when application gets uninstalled. [issue 281](https://code.google.com/p/posit-mobile/issues/detail?id=281)
  * Cleaned up unnecessary/commented code in CameraActivity. [issue 282](https://code.google.com/p/posit-mobile/issues/detail?id=282)
  * Integrated code to display thumbnail of photo in find when viewing the list of finds. [issue 283](https://code.google.com/p/posit-mobile/issues/detail?id=283)
  * Integrated code to sync the photo from the server to the phone. [issue 284](https://code.google.com/p/posit-mobile/issues/detail?id=284)
  * Replaced FileNotFound exceptions with a non-exception approach. [issue 285](https://code.google.com/p/posit-mobile/issues/detail?id=285)
  * Added in HFOSS header to CameraActivity and a few javadoc changes. [issue 290](https://code.google.com/p/posit-mobile/issues/detail?id=290)
  * Debugging the newly integrated POSIT. [issue 291](https://code.google.com/p/posit-mobile/issues/detail?id=291), [issue 292](https://code.google.com/p/posit-mobile/issues/detail?id=292), [issue 293](https://code.google.com/p/posit-mobile/issues/detail?id=293), [issue 294](https://code.google.com/p/posit-mobile/issues/detail?id=294), [issue 295](https://code.google.com/p/posit-mobile/issues/detail?id=295), [issue 296](https://code.google.com/p/posit-mobile/issues/detail?id=296), [issue 297](https://code.google.com/p/posit-mobile/issues/detail?id=297), [issue 298](https://code.google.com/p/posit-mobile/issues/detail?id=298), [issue 300](https://code.google.com/p/posit-mobile/issues/detail?id=300), [issue 302](https://code.google.com/p/posit-mobile/issues/detail?id=302)
  * Documented camera plugin with syncing. **See top of this page.**
  * Future enhancements to Camera plugin: [issue 305](https://code.google.com/p/posit-mobile/issues/detail?id=305)

Dec. 6, 2011
  * Ditched the SQLite database idea because there were problems and Ralph had to hack it for it to work with the tracker activity.
  * Having trouble running application on emulator. Created [issue 271](https://code.google.com/p/posit-mobile/issues/detail?id=271) for it.
  * Used the mediastore content provider to store the picture onto the phone for the camera activity.
  * Sent initial camera code for Ralph to review
  * Posted a team blog. [HFOSS blog](http://blog.hfoss.org/?p=500)

Nov. 29, 2011

  * **Revised plan to integrate camera back into posit**
  * Cleaned up camera code, but still need to store the data somewhere
  * Read about content providers to store images on the phone as suggested by Ralph
  * Having some trouble understanding how the SQLite db, ormlite, content provider, and syncing fit together

Nov. 22, 2011
  * Still working on integrating camera component.
  * This involves:
    * Adding a new extension point to the add\_find menu (successful)
    * Passing the data from one activity to another (somewhat successful-doesn't look elegant)
    * Adding a string field to store the encoded image (somewhat successful-only got it to work on outsidein, I tried to put it in the Find class, but I couldn't get it to show up in the 'Extras' string attr=val pair)
    * Encoding the image into string (successful)
    * Storing the encoded image in a string field in the database (successful)
    * Editing the GUI to add an ImageView (successful)
    * Decoding the string to display the image in the ImageView (successful)
    * Decoding the string to display in PositWeb (working on it)

So I guess I'm having problems generalizing the camera to other plugins at the moment. All because I can't add a field into the 'Extras' from the Find class.

I need to clean up the code before I can post a patch.

Nov. 15, 2011
  * I created a separate android project to test how to call the camera and displaying the image it captured. This needs to be tested on a phone because I'm not sure if I'm getting the correct picture resolution.
  * I then tested some code which would encode the Bitmap image into a Base64 string and vice versa. It seemed to work.
  * So the basic idea of dealing with pictures seems to be to store it as a string and encode/decode as necessary. This can be managed using the string of attr=val pairs.
  * After a few hours of frustration I learned that trying to add a new attr=val pair actually requires reinstallation of the app. And the naming convention must be very exact.
  * I'm actually trying to figure out the best way to integrate the camera functionality. Should it be mandatory or optional to take pictures?

Nov. 8, 2011
  * Worked on patching up issues
  * Created [issue 248](https://code.google.com/p/posit-mobile/issues/detail?id=248).
  * Created [issue 249](https://code.google.com/p/posit-mobile/issues/detail?id=249) and its patch.
  * Created [issue 250](https://code.google.com/p/posit-mobile/issues/detail?id=250) and its patch.
  * Still exploring and understanding Positweb
  * **Focus has shifted to integrating the camera back into posit**

Nov. 1, 2011

  * Finally debugged setting up positweb. Created setup guide on wiki [Installing\_on\_ubuntu](Installing_on_ubuntu.md)
  * Re-setup development environment (I had to reformat my computer)
  * Debugged connecting to localhost server on emulator. (Should use 10.0.2.2 instead of localhost)
  * Started reading the Smarty template engine to prettify positweb
  * Created [issue 247](https://code.google.com/p/posit-mobile/issues/detail?id=247) and its patch. This prettifies the display of information on positweb. **Patch is waiting to be applied to Positweb**

Oct. 25, 2011

  * Tested new build which integrated syncing and posted [issue 228](https://code.google.com/p/posit-mobile/issues/detail?id=228) [issue 230](https://code.google.com/p/posit-mobile/issues/detail?id=230) [issue 231](https://code.google.com/p/posit-mobile/issues/detail?id=231) [issue 232](https://code.google.com/p/posit-mobile/issues/detail?id=232) [issue 233](https://code.google.com/p/posit-mobile/issues/detail?id=233) [issue 234](https://code.google.com/p/posit-mobile/issues/detail?id=234) [issue 235](https://code.google.com/p/posit-mobile/issues/detail?id=235) [issue 236](https://code.google.com/p/posit-mobile/issues/detail?id=236).
  * Tried to install positweb, but it doesn't seem to like XAMPP
  * Reviewed MySQL, Php.

Oct. 18, 2011

  * Created patch for [issue 217](https://code.google.com/p/posit-mobile/issues/detail?id=217).
  * Exploring PositWeb's default branch.
  * Installed XAMPP for positweb
  * **Revised project proposal to focus more on the server side**

Oct. 11, 2011

  * Created patches for [issue 215](https://code.google.com/p/posit-mobile/issues/detail?id=215) and [issue 216](https://code.google.com/p/posit-mobile/issues/detail?id=216).
  * Played around with Google Map plugin
  * Drafted project proposal
  * Trying to figure out how to upload documents to wiki...

Oct. 4, 2011

  * Tested the application to find existing bugs before we begin integrating new code. [issue 209](https://code.google.com/p/posit-mobile/issues/detail?id=209), [issue 215](https://code.google.com/p/posit-mobile/issues/detail?id=215), [issue 216](https://code.google.com/p/posit-mobile/issues/detail?id=216), [issue 217](https://code.google.com/p/posit-mobile/issues/detail?id=217)
  * Familiarizing myself with parts of POSIT
  * Did some more android tutorials to familiarize myself with android development