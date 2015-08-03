### Introduction ###

The HFOSS project has created a number of tutorials that expand upon or extend the Android tutorials.

  * [Hello Android](http://notes.hfoss.org/index.php/Tutorial:Hello_Android)
  * [MapView with GPS](http://notes.hfoss.org/index.php/Tutorial:Hello_Mapview,_with_GPS)
  * [Camera and Gallery](http://notes.hfoss.org/index.php/Tutorial:Camera_and_Gallery_Demo)
  * [Camera and Gallery, II](http://notes.hfoss.org/index.php/Tutorial:Camera/Gallery_Part_II)
  * [A Contacts App](http://notes.hfoss.org/index.php/Tutorial:Creating_a_Contacts_Application)
  * [Camera App](http://notes.hfoss.org/index.php/Tutorial:Creating_a_Camera_Application) (old)

Here are some other useful links.

  * [Flashing the HTC development phone](http://developer.htc.com/adp.html)
  * [Hello Testing for Android](http://developer.android.com/resources/tutorials/testing/helloandroid_test.html)
  * [Activity Testing Tutorial for Android](http://developer.android.com/resources/tutorials/testing/activity_test.html)

##### Coding Conventions and Guidelines: #####

Start by reading the following document:

[Code style guidelines for contributors](http://source.android.com/source/code-style.html)

Sun has established very good rules on how to write Javadoc comments. You should know and follow these rules:

http://java.sun.com/j2se/javadoc/writingdoccomments/
```
/**
 * Returns an Image object that can then be painted on the screen. 
 * The url argument must specify an absolute {@link URL}. The name
 * argument is a specifier that is relative to the url argument. 
 * <p>
 * This method always returns immediately, whether or not the 
 * image exists. When this applet attempts to draw the image on
 * the screen, the data will be loaded. The graphics primitives 
 * that draw the image will incrementally paint on the screen. 
 *
 * @param  url  an absolute URL giving the base location of the image
 * @param  name the location of the image, relative to the url argument
 * @return      the image at the specified URL
 * @see         Image
 */
 public Image getImage(URL url, String name) {
     try {
         return getImage(new URL(url, name));
     } catch (MalformedURLException e) {
         return null;
     }
 }
```
Your code should have comments like this as you are developing it!. In other words, don't wait until the end of the summer or even the end of the week. Write you Javadoc comments as you develop the code. When we look at your code, we primarily want to read your comments, not the code itself.