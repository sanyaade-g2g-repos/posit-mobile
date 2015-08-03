#Describes the CsvFind Plugin

# Introduction #

A CsvFind is a Find that is constructed from a Csv row. Its purpose is to enable Posit to download and process data from open data sites such as NYC's open data site (http://nycopendata.socrata.com/).

CsvFinds currently are not saved to the Posit database or Synced to Posit Server.

A CsvFind extends the BasicFind.  Its fields should match the columns of the Csv File. In it first version, the Csv File must follow strict formatting specifications.

  * It must begin with a comma-delimited header row that starts with the string #GUID, ...
  * Its columns must not contain embedded commas.

Right now, the CsvFind class is linked to an NYC Museums data set as a proof of concept.  The CsvFind class and its related classes should be revised to permit them to be re-used with any properly formatted Csv file.

# Details #

### The CsvFind Plugin Specification ###
The CsvFind plugin is specified as follows in plugin\_preferences.xml:

<pre>
<!--  Downloads Find data from a open CSV dataset --><br>
<Plugin active="false" type="find" name="CsvFind"<br>
package="org.hfoss.posit.android.experimental.plugin"<br>
find_class="org.hfoss.posit.android.experimental.plugin.csv.CsvFind"<br>
find_factory="org.hfoss.posit.android.experimental.api.FindFactory<br>
find_activity_class="org.hfoss.posit.android.experimental.plugin.csv.CsvFindActivity"<br>
extra_activity_class=""<br>
extra_activity_class2=""<br>
list_finds_activity_class="org.hfoss.posit.android.experimental.plugin.csv.CsvListFindsActivity"<br>
find_data_manager="org.hfoss.posit.android.experimental.api.database.DbManager"<br>
preferences_xml="posit_preferences"<br>
add_find_layout="csv_add_find"<br>
list_find_layout="csv_list_row"<br>
main_list_button_label="listMuseums"<br>
main_add_button_label="invisible"<br>
main_extra_button_label=""<br>
main_extra_button_label2=""<br>
main_icon="posit_museum" /><br>
</pre>

Note that it is customized for the Museum data, with a museum icon, musuem-related button labels, etc.  Ideally these should be generalized.  Perhaps these data could be put in the Csv file as additional header material.

Note also the use of the "invisible" label for Posit's AddFind button. Code was added to PositMain to hide that button when it is so labeled.

### The CsvFind Class ###

It is not clear that the CsvFind class needs to be a Find subclass and tied to the Posit database.  Currently CsvFinds are not saved to the database and not synced to the Posit Server.

CsvFind's fields match 1-for-1 the column names of the Csv file.  This is currently done by hand.  But it should be done by reflection.

### The CsvFindActivity ###

The Csv data are integrated with the CsvFindActivity class. CsvFind data can only be displayed.  It cannot be edited.  Therefore the view uses mostly TextView components not EditText components.  This should make it possible to construct the csvFindActivity programmatically, building off of a bare-bones XML layout, using code such as the following to construct TextViews as needed:

<pre>
TextView newTV = new TextView(this);<br>
newTV.setText((((CsvFind)find).getClosing()));<br>
newTV.setPadding(4, 8, 0, 0);<br>
newTV.setLayoutParams(new LayoutParams(<br>
LayoutParams.FILL_PARENT,<br>
LayoutParams.WRAP_CONTENT));<br>
<br>
((LinearLayout)v).addView(newTV);<br>
</pre>

Key features of the XML layout are TextViews for the museum's phone number, web site, and address.  These are coded as ''autoLine'' tags, for example:

<pre>
<TextView<br>
android:id="@+id/phoneValueTextView" android:text="111-222-3333"<br>
android:autoLink="phone"<br>
android:layout_width="wrap_content" android:layout_height="wrap_content"<br>
android:layout_marginLeft="4dp" android:layout_marginTop="10dp"<br>
android:layout_marginBottom="10dp"<br>
android:textSize="16dp"><br>
<br>
<br>
Unknown end tag for </TextView><br>
<br>
<br>
</pre>

These TextView's are linked in the code using the ''Linkify'' statement:

<pre>
tv = (TextView)findViewById( R.id.phoneValueTextView );<br>
tv.setText(((CsvFind)find).getPhone());<br>
Linkify.addLinks( tv, Linkify.PHONE_NUMBERS );<br>
</pre>

### CsvFindListActivity ###

This class handles the File I/O and the parsing.  Its key method is the ''parseCsvFind'' method.  This method is too long to reproduce here. Basically, it assumes that the header data in the Csv file corresponds to the CsvFind's field names.  It figures out the type of each field and then converts the Csv data to the appropriate type.  It is based on Ryan McLeod's parse method from the SmsPlugin.

### Future Enhancements ###

This proof-of-concept version should be enhanced to allow a CsvFind to be instantiated with any, properly-formatted Csv data.  It would be good to do the same thing with online data formatted in XML or with data downloaded through RSS feeds.