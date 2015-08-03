### Testing Tasks ###

  * (novice) Choose a particular feature of POSIT and conduct a thorough testing of it -- its user interface, its functionality -- and identify bugs, desirable feature enhancements, and other issues.

  * (intermediate, expert) Design and begin implementation of a **unit test** corpus for POSIT.  See the following Android tutorial to get started: http://developer.android.com/resources/tutorials/testing/helloandroid_test.html

  * (intermediate) Design and implement tests of POSITx's plug-in architecture.

### Refactoring Tasks ###

  * (novice, several students)  Identify and remove unused resources from POSIT's codebase -- i.e., strings, images, xmls.

  * (expert) Efficiency:  Do an analysis of the code and refactor it for greater efficiency.  This would include using final and static modifiers where appropriate throughout the code.

  * (novice) String Literals: Go through the code base and remove all non-trivial occurrences of literal strings replacing them with String resources in strings.xml.  All strings used in the program should be declared in either the strings.xml resource or as static final variables.

  * (intermediate) Reincorporate the POSIT tutorial into the plug-in architecture.  This revised function should enable developers of plug-ins to incorporate a tutorial for the plug-in.

### Bugs ###

  * See the Issues tab for the current list of issues and bug reports.

### User Interface Work ###

  * (novice) Find a consistent set of open source icons and replace the icons throughout the app, removing those resources that are replaced.

  * Test POSIT against newer tablets to ensure smooth transition between screen resolutions from mobile device to larger tablet screens. Also address the lack of IMEI numbers in tablets, used by POSIT to identify devices.

**Add an ability to configure POSIT either at installation or through the settings interface to allow a user with the appropriate privileges to toggle activate/deactivate various plugins that come pre-compiled with POSIT.**

### Major Development Projects ###

  * (expert) Incorporate POSIT-Haiti's SMS functionality into POSIT's plug-in architecture.  Design issue:  Should this be seen as a type of Sync activity or should it be separate from Sync.

  * Develop and integrate functionality to incorporate "Scanning" in bar codes using the phones camera. Add ability to capture bar code as part of a new "find" registration as well as read in a printed bar code, that's been previously associated with an existing find and retrieve the corresponding "find" record associated with that bar code.

  * Build on preliminary work carried out to allow the synching of "finds" across two more more phones using Bluetooth. Develop this into a plugin in the new architecture.

  * Port the POSIT Server from PHP platform to Python or Java based version that can be hosted on Google's App Engine or Amazon's EC2 Cloud, which will allow for greater flexibility with hosting and automatic scaling of the server side application moving forward.

  * Enhance the map display on the mobile application to allow the grouping of finds and usability of the mapping function/plugin in POSIT.

  * Take stock of existing synching procedures and functionality, including over wifi, SMS, google accounts etc.. and develop a generic synching library that will be part of POSIT's core functionality.

  * Enhance the project sharing capabilities on the server side.

  * Develop ability to create and upload customized forms to store and retrieve "find" data. For instance user can create a form to collect certain fields about a bird and upload it to his device or create a different form to collect data about the condition of buildings in a certain area.
