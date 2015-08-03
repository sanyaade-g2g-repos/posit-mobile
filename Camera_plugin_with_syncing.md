# Introduction #

> #### The camera functional plug-in for POSIT lets users take a picture of their find. We allow up to one picture per find. Users can edit the picture of a find. Furthermore, the picture is deleted when the find is deleted. Finally, the find information and picture are synced between your phone and server when you use the sync functionality. ####

> #### The photos are stored as Base64 strings in the application's data space. They are stored as files with the filename equal to the GUID of the find. This implies that all photos taken with the POSIT application will be removed when the application is removed. ####

> #### This function plug-in is independent of basic POSIT and can be easily detached by modifying "plugins\_preferences.xml". ####


---


# Enabling the Camera plugin #

Under the /res/raw/plugin\_preferences.xml file:

Navigate to the Capture Media entry. Make sure the value of the **active** attribute is set to **true**. Setting it to **false** will disable the camera plugin.
```
		<Plugin active="true" 
			type="function" 
			extensionPoint="addFindMenu"
			name="Capture Media" 
			menuIcon="ic_menu_camera" 
			menuTitle="Capture Media"
			menuActivity="org.hfoss.posit.android.experimental.functionplugins.CameraActivity" 
			activity_returns_result="true"
			activity_result_action="1" />
```
You have now enabled the camera function plug-in in POSIT.


---


# Taking a picture for a find #

## This guide assumes you are ready to add finds to an existing project ##

Step 1. Start the application

Step 2. Click Add Find

![https://lh5.googleusercontent.com/-Om-PogdT0zI/TuQvL00VXKI/AAAAAAAAAAk/P2ZpJEBrIWM/s400/1StartApp.png](https://lh5.googleusercontent.com/-Om-PogdT0zI/TuQvL00VXKI/AAAAAAAAAAk/P2ZpJEBrIWM/s400/1StartApp.png)

Step 3. Press the menu button on your phone. Step 4. Click Capture Media.

![https://lh3.googleusercontent.com/-JSdwsKcq2ms/TuQv29nf0nI/AAAAAAAAABA/5tOyGahCGpU/s400/2AddFind.png](https://lh3.googleusercontent.com/-JSdwsKcq2ms/TuQv29nf0nI/AAAAAAAAABA/5tOyGahCGpU/s400/2AddFind.png) ![https://lh5.googleusercontent.com/-Q_SsL39aoMw/TuQv2TzvlJI/AAAAAAAAAA4/P6_swh0eeAQ/s400/3PressMenu.png](https://lh5.googleusercontent.com/-Q_SsL39aoMw/TuQv2TzvlJI/AAAAAAAAAA4/P6_swh0eeAQ/s400/3PressMenu.png)

Step 5. Click Take Picture. This launches the camera application. Step 6. Take your picture

![https://lh6.googleusercontent.com/-jo-vRweAwF4/TuQv2_36AsI/AAAAAAAAABE/NYVJsyIte84/s400/4PressCaptureMedia.png](https://lh6.googleusercontent.com/-jo-vRweAwF4/TuQv2_36AsI/AAAAAAAAABE/NYVJsyIte84/s400/4PressCaptureMedia.png) ![https://lh3.googleusercontent.com/-WKZK_HNHs2E/TuQv3VGta4I/AAAAAAAAABQ/eE5upobkeS4/s400/5PressTakePicture.png](https://lh3.googleusercontent.com/-WKZK_HNHs2E/TuQv3VGta4I/AAAAAAAAABQ/eE5upobkeS4/s400/5PressTakePicture.png)

Step 7. Press Continue. Pressing Retake Picture allows you to retake your picture.

![https://lh3.googleusercontent.com/-bqt1WmeM83c/TuQv5YDtjvI/AAAAAAAAABY/eLRoygKfoWY/s400/6TakePicture.png](https://lh3.googleusercontent.com/-bqt1WmeM83c/TuQv5YDtjvI/AAAAAAAAABY/eLRoygKfoWY/s400/6TakePicture.png)

Step 8. Fill in some information for the find. Step 9. Press Save. You should now be returned to the main screen

![https://lh4.googleusercontent.com/-of5n5IbmRBU/TuQv5WQy5lI/AAAAAAAAABc/qDix5xFFPU8/s400/7PressContinue.png](https://lh4.googleusercontent.com/-of5n5IbmRBU/TuQv5WQy5lI/AAAAAAAAABc/qDix5xFFPU8/s400/7PressContinue.png) ![https://lh6.googleusercontent.com/-EeD9o8r7910/TuQv5_O-ZCI/AAAAAAAAABo/LsVCYsG-gZU/s400/8FillInFindOptional.png](https://lh6.googleusercontent.com/-EeD9o8r7910/TuQv5_O-ZCI/AAAAAAAAABo/LsVCYsG-gZU/s400/8FillInFindOptional.png)

Step 10. Click View Finds. A thumbnail of the photo you took will be displayed beside the find information.

Step 11. To start the syncing process, press the menu button on your phone

Step 12. Press Sync

![https://lh3.googleusercontent.com/-D9R9V8nSna4/TuQv6077WuI/AAAAAAAAAB4/pMDQPjqf2YI/s400/9PressSave.png](https://lh3.googleusercontent.com/-D9R9V8nSna4/TuQv6077WuI/AAAAAAAAAB4/pMDQPjqf2YI/s400/9PressSave.png) ![https://lh3.googleusercontent.com/-zK6oA2KvxLI/TuQv6ahlNSI/AAAAAAAAABw/VoYhY9dkiVw/s400/10ViewFinds.png](https://lh3.googleusercontent.com/-zK6oA2KvxLI/TuQv6ahlNSI/AAAAAAAAABw/VoYhY9dkiVw/s400/10ViewFinds.png)

![https://lh4.googleusercontent.com/-AQ3cFoK1dk8/TuQv8Bj3CvI/AAAAAAAAACM/QVziAAeRUuI/s400/11PressMenu.png](https://lh4.googleusercontent.com/-AQ3cFoK1dk8/TuQv8Bj3CvI/AAAAAAAAACM/QVziAAeRUuI/s400/11PressMenu.png) ![https://lh5.googleusercontent.com/--lpr66MyIEw/TuQv7Uv7O-I/AAAAAAAAACA/NqszehjVlrY/s400/12PressSync.png](https://lh5.googleusercontent.com/--lpr66MyIEw/TuQv7Uv7O-I/AAAAAAAAACA/NqszehjVlrY/s400/12PressSync.png)

Here is an example of a find without a picture when viewing a list of finds.

![https://lh6.googleusercontent.com/-ft7q7fOuiuA/TuQv7ys-ieI/AAAAAAAAACI/YgaNZnlxXE8/s400/13ViewFindsNoPicture.png](https://lh6.googleusercontent.com/-ft7q7fOuiuA/TuQv7ys-ieI/AAAAAAAAACI/YgaNZnlxXE8/s400/13ViewFindsNoPicture.png)

# Viewing the find information and picture on the server #

## This assumes you are already logged into Positweb ##

Step 1. Click on Projects to view all your projects

![https://lh3.googleusercontent.com/-bIvLw5mk4yI/TuQv-TUZk_I/AAAAAAAAACY/Rk0j7VztNUc/s800/14PositwebProjects.png](https://lh3.googleusercontent.com/-bIvLw5mk4yI/TuQv-TUZk_I/AAAAAAAAACY/Rk0j7VztNUc/s800/14PositwebProjects.png)

Step 2. Select the project you wish to view

![https://lh4.googleusercontent.com/-OUewz6MH6yI/TuQwACd_l_I/AAAAAAAAACg/ahXtLjZ27p8/s800/15PositWebFinds.png](https://lh4.googleusercontent.com/-OUewz6MH6yI/TuQwACd_l_I/AAAAAAAAACg/ahXtLjZ27p8/s800/15PositWebFinds.png)

# Enjoy sharing your finds! #