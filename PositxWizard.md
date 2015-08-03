The wizard will automate many of the [steps](FindPlugin.md) necessary to build a new Find plugin.
Given the list of custom data fields, the wizard builds necessary classes and layouts to implement those fields. With an easy step-by-step instructions, the wizard spares developers from having to type a lot of boilerplate code.

[Launch the wizard](http://appinventor.cs.trincoll.edu/positwizard/) (works best on Google Chrome)

## Technical Description ##
### Overview ###
The wizard produces java and xml files by performing string substitutions on templates. Templates contain macros surrounded by percent signs (e.g. `%package_name%`). Macros are replaced with custom content.

Due to security restriction, the wizard cannot modify existing files. The user has to manually add new entries to Manifest and plugin\_preferences.xml.
### Libraries ###
The wizard runs entirely on the client side. It incorporates a number of Javascript libraries:
  * [jQuery](http://jquery.com/) : a Javascript query library
  * [fancyBox](http://fancyapps.com/fancybox/) : image viewer
  * [JSZip](http://stuk.github.io/jszip/) : dynamically create zip archives
  * [FileSaver.js](https://github.com/eligrey/FileSaver.js) : turn dynamically generated files into downloads.

In addition, the wizard adopts an HTML5 design template created by [HTML5 UP](http://html5up.net/).

## Credits ##
Philip Cho (Hyunsu.Cho@trincoll.edu)<br>
Trinity College, Class of 2015