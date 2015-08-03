# Introduction #

  * 4th year CS student from Simon Fraser University (Vancouver).

  * Focus on software engineering.

  * Part of the Fall 2011 UCOSP team.

# Project Documentation #
[Twitter Function Plugin](TwitterFunctionPlugin.md)

# Project Proposal #
(Updated on Oct 24, 2011)

[Proposal PDF](https://docs.google.com/viewer?a=v&pid=explorer&chrome=true&srcid=0B3iKLWrXDKKWNDUzMWFkYzYtZTkyYS00OTUzLTg2NWQtZDZhNDdjYTcxMTNl&hl=en)

[Proposal ODT](https://docs.google.com/leaf?id=0B3iKLWrXDKKWNWJjYTQ2YzEtNGJhMi00ZjQyLTg2ZGEtZDc4OTE1OWQ5OGQ5&hl=en_US)

[Google Clone](http://code.google.com/r/stanfung-twitter-posit-plugin/source/browse)

# Weekly Progress #

Nov. 29, 2011
  * Research: twitpic. find plugin to upload to twitpic for tweets.
    * https://github.com/yusuke/twitter4j/blob/master/twitter4j-examples/src/main/java/twitter4j/examples/media/TwitpicImageUpload.java
  * Fixed bugs.
  * Pulled code from main repository to clone.
  * Completed:
    * Adding tweet find to add-find-menu
    * Tweet a single find.
  * In progress: Saving access token to shared preferences.
  * Questions:
    * Passing in Find (or data in general) to function plugin.

Nov. 22, 2011
  * Good progress on feature at http://code.google.com/r/stanfung-twitter-posit-plugin/source/browse/?name=test_branch
  * Able to tweet stub. https://twitter.com/#!/stanley_fung
  * Commit in detail:
    * Added twitter4j library.
    * Altered eclipse project to use the jar.
    * Create request token to be sent to twitter with consumer key and secret.
    * Login to Twitter by creating a webview to twitter site.
    * Link Intent so that response from twitter will get sent to activity with android manifest, and onIntent overwrite.
    * Send Message to twitter.
    * Return to ListFinds afterwards.
  * Challenges:
    * Logging in. Used: http://www.anddev.org/advanced-tutorials-f21/sending-a-tweet-t54389.html
    * Unable to type in webview. Used: http://stackoverflow.com/questions/2083909/android-webview-refusing-user-input
    * How to control callback and using intent filter. Used: http://honza.ca/2010/09/how-to-use-twitter-oauth-on-android
  * To do: Incorporate finds data.

  * Problem: Incorporating finds data would be in the area of a Find Plugin.

Nov. 15, 2011
  * Twitter api uses OAuth protocol to authenticate users. Researched protocol and attempted to implement. Found that it was a bit too tedious. Authenticating with OAuth requires a lot attention to details. I found that the less secure way of authenticating was deprecated. Switching to alternative, importing a library to handle the login and posting new updates.
  * Have been able to get a request token from Twitter. Stuck trying to authenticate it. (There are 3 steps. As described in the link below. Get Request Token, Authenticate, Get Access Token)
  * Created a clone of posit.mobile-plugin
  * Created a stub functional plugin for send to twitter.
  * (Q: Can I create a menu extension point in Find Plugin but still have it be considered a functional plugin?)

Nov. 8, 2011
  * Finished [Issue 238](https://code.google.com/p/posit-mobile/issues/detail?id=238). Awaiting Server for Testing. (Interesting background info #1: I noticed the notification constructor I was using turned out to be deprecated. But the new constructor for notification was only available after API 11.)
  * Worked with API using an external RESTful client to see the interaction.
  * Creating requests for data to Twitter (Independent from POSIT data atm).
  * Looked into opensource Twitter libraries. (There is a tradeoff. Using external libraries would be efficient if in the future, more complex features are wanted. For the current scope, custom implementation will be sufficient.)

Nov. 1, 2011
  * Continued working on [Issue 238](https://code.google.com/p/posit-mobile/issues/detail?id=238)
  * Created a Patch for [Issue 245](https://code.google.com/p/posit-mobile/issues/detail?id=245)
  * Research on Notifications and Preferences

Oct. 24, 2011
  * Created two new issues. [Issue 244](https://code.google.com/p/posit-mobile/issues/detail?id=244) & [Issue 245](https://code.google.com/p/posit-mobile/issues/detail?id=245)
  * Done research and submitted initial patch for for [Issue 238](https://code.google.com/p/posit-mobile/issues/detail?id=238)
  * Reviewed other Issues and commented. For ex: [Issue 224](https://code.google.com/p/posit-mobile/issues/detail?id=224), [Issue 232](https://code.google.com/p/posit-mobile/issues/detail?id=232) and [Issue 240](https://code.google.com/p/posit-mobile/issues/detail?id=240).
  * Completed version 0.4 of Proposal according to discussion from last meeting and reviewing other proposals.
  * Updated links personal wiki to useful material I have read.

Oct. 18, 2011

  * Reimplemented patch for [Issue 220](https://code.google.com/p/posit-mobile/issues/detail?id=220).
  * Reported and submitted patch for [Issue 224](https://code.google.com/p/posit-mobile/issues/detail?id=224).
  * Prepped Proposal.

Oct. 11, 2011

  * Completed almost all of the basic layout tutorials.
  * Learning how the Android Google Map API works.
  * Adding OutsideIn specific unique ID for [Issue 220](https://code.google.com/p/posit-mobile/issues/detail?id=220).
  * Brainstormed ideas for proposal.

Carry Over to next week:
  * Suspect that the soft input keyboard will block add find if/when more fields are added. Verify this.
  * Create description for unique identifier components.
  * Port rest of the OutsideIn form?

Oct. 4, 2011

  * Tested the new changes to in POSIT to see if there are any bugs.
  * Found two bugs: [Issue 219](https://code.google.com/p/posit-mobile/issues/detail?id=219), [Issue 220](https://code.google.com/p/posit-mobile/issues/detail?id=220).

# Details #
[POSIT sandbox](http://www.posit-project.org/sandbox)

[TableLayout spanning columns](http://www.droidnova.com/tablelayout-supports-column-span,105.html)

[ContentResolver tutorial](http://www.androidcoder.org/blog/introduction-android-content-resolver-content-observer-part-3/)

[Email](http://www.helloandroid.com/tutorials/how-send-email-your-application)

[notifications tutorial](http://developer.android.com/guide/topics/ui/notifiers/notifications.html)

[preferences tutorial](http://www.rominirani.com/android-preferences-tutorial/)

[OAuth for Twitter](https://dev.twitter.com/docs/auth/oauth)