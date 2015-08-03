# Introduction #

With the unveiling of Android 4.0.3, the phone and tablet operating systems were united. This came with a new user interface guideline posted at http://developer.android.com/design/index.html. POSITx has also been primarily used on a phone though the it could be installed on a tablet, but the user interface wasn't optimal. Instead of creating the addition of two separate UI's, the decision was to unite them and make sure that it was the same irregardless of the version of Android. This is where Action Bar Sherlock comes into the picture.

From abs.io "ActionBarSherlock is an extension of the compatibility library designed to facilitate the use of the action bar design pattern across all versions of Android with a single API." The main features that were wanted were the actionbar, and the use of fragments. First the actionbar is what appears at the top of the screen for the app, it may be used for navigation and it also can show menu items. Secondly are Fragments, these are used in conjunction with FragmentActivitys to replace the old style of Activitys. With Fragments one is able to code two for example and on a phone have only one show at a time per FragmentActivity and on a tablet have 2 show for one FragmentActivity. This is used in POSIT to have a two column view on a tablet which one side shows the list of finds, and the second column displays the selected find or has a form to create a new find.


# Details #

New Requirements
  * **SDK Platform** and **Google APIs by Google Inc.** for API level 15
  * **ActionBarSherlock v4.0.1** from http://abs.io

Steps to setup clone
  1. Download and extract v4.0.1 of ActionBarSherlock from abs.io to your home directory.
  1. In Eclipse create a new Android Project from existing source, select the library folder contained in the extraced zip then select finish.
  1. Right click on newly created "com\_actionbarsherlock" project and select properties.
  1. Select Android and make sure "Is Library" check box is checked also make sure **Android 4.0.3** is selected as the build target.
  1. In project properties add the jar file "android-support-v4.jar" contained in libs to the Build Path.
  1. There should be no red x's on the "com\_actionbarsherlock" library now.
  1. Create new project from existing Mercurial source using https://code.google.com/r/ericenns-posit-ucosp-2012/ as the URL.
  1. Select test\_branch as the branch to checkout.
  1. Go to project properties and to Android in there under Library click add and select "com\_actionbarsherlock" also make sure **Google APIs 4.0.3** is selected as the build target.
  1. Clean your project if errors and everything should be good to go.