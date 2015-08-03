# Spring 2011 Proposal #

This is proposal to extend POSIT find functionality into a plugin-based design.


# Details #

The discussion we had couple of weeks ago about team of biologists needing a specialized software tool which has some sort of data accumulation ability similar to that of POSIT, but with completely different method of creating a "find" gave me this idea.

Even on first-generation devices, there is a lot of cool ways to use phone capabilities to measure several kinds of environmental factors. To list a few: various dB sound/volume meters, magnetic field meters, height and distance meters, vibration/earthquake meters, and finally ability to take pictures and videos.

On the other hand, even with existing method of adding a find consisting of an image and/or a text note, a customer may want a customized layout to display and sort images.

I think that POSIT can be used by more people if it supports more features, but all custom additions pose difficult code management questions: do we fork main dev line for an individual feature? at which point do we fork? what do we do if we like several custom features, but they are not compatible with current main line?

In my opinion, the creation of a find process would benefit most from customization. And I would like to work on adding a plugin support to POSIT. Under this change, every add-find activity shall be wrapped into individual plugin module which can be downloaded, installed, and uninstalled without affecting rest of the application.

This feature will require the following changes:

**1. Data changes**

Instead of a photograph file, each find shall consist of a zipped archive file containing any arbitrary find data. A standard manifest.xml descriptor shall be generated at the root of the archive declaring find information, such as data-type, POSIT version, plugin dependencies, etc. Each plugin type will have its own set of tables pertaining to finds of its type. Actual find name and an attached text comment stored in database shall not be changed.

**2. Server changes**

Each project shall include type finds it is intended to host. As part of adding a new plugin to POSIT, server shall be made configurable to use alternate code to display finds of each particular type. For example, current server setup shall work for finds of photograph type. Pages to display sound, graph and other types of finds may be added by developers of associated plugins.

**3. Client changes**

During project selection, selected project type must match type of POSIT plugin installed. The way finds are displayed to the user is up to the individual plugin implementation. For example, plugin for photograph finds shall use same code currently used to display finds. Plugin developers shall have an option to display their type of finds however they choose.


I think this would open a lot of possibilities to POSIT project, allowing it be more appealing to wider audience. On the other hand, this should alleviate difficulty associated with students willing to make their own changes to components of POSIT code dealing with management and display of finds on both server, and client sides.