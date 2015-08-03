# Introduction #

The barcode function plugin allows you to do two things:

1) Create a barcode from a Find in POSIT

2) Scan a barcode created in POSIT

The barcode format used is [QRcodes](http://en.wikipedia.org/wiki/QR_code) (Quick Response Codes).


# Enabling the Barcode plugin #

If it isn't already, set active to "true" in the following code in res/raw/plugins\_preferences.xml

```

<Plugin active="true" 
type="function" 
extensionPoint="addFindMenu"
name="Scan Barcode" 
menuIcon="admin3" 
menuTitle="Scan Barcode"
menuActivity="org.hfoss.posit.android.functionplugin.barcode.CodeCaptureActivity" 
add_find_callback = "org.hfoss.posit.android.functionplugin.barcode.CodeCaptureActivity"
list_find_callback = "org.hfoss.posit.android.functionplugin.barcode.CodeCaptureActivity"
activity_returns_result="true"
activity_result_action="1" />

```

Then compile and run POSIT.

# Converting a Find to barcode format #

This is easy. Once you add a Find in POSIT, functionality already
exists in the FindActivity to show the Find in barcode form.

After you add your Find, head to the "View Finds" view and select the Find. You will see the option to "View Barcode".

Something like this:

![http://i1074.photobucket.com/albums/w411/fourknee/viewBarcode2.png](http://i1074.photobucket.com/albums/w411/fourknee/viewBarcode2.png)

You can then either edit the Find or Save it again.

# Scanning a barcode in POSIT to your own POSIT device #

To do this, go to the "Add Finds" page. You should have an option to
scan barcodes in your menu.

![http://i1074.photobucket.com/albums/w411/fourknee/scanbarcode_screenshot3.png](http://i1074.photobucket.com/albums/w411/fourknee/scanbarcode_screenshot3.png)

After selecting "Scan Barcode", a view finder will come up to let you
scan POSIT barcodes (other qrcodes will simply not be shown)

[![http://i1074.photobucket.com/albums/w411/fourknee/viewfinder_screenshot2.png](http://i1074.photobucket.com/albums/w411/fourknee/viewfinder_screenshot2.png)

If the scan is sucessful, you will be shown the POSIT Add Finds page
again, this time with the information from the new Find added.

[Watch a video demo of the barcode plugin here!](http://youtu.be/4918_-ji0q8)

Workflow of the Plugin:

When a Find is created, its details specifically the: Name, Description,
Latitude and Longitude are encoded as barcodes in the FindActivity.java
class under "org.hfoss.posit.android.api.activity" specifically in the
"encodeFindAsBarcode" function

```

protected void encodeFindAsBarcode(Find find){
  String guid = find.getGuid();
		
  SimpleDateFormat dateFormat = new SimpleDateFormat(
		"yyyy/MM/dd HH:mm:ss");
		String time = dateFormat.format(find.getTime()); //currentTime
		
		String findName = find.getName(); //Find name
		String description = find.getDescription(); //Find Description
		double latitude = find.getLatitude(); //Find Latitude location
		double longitude = find.getLongitude(); //Find Longitude location
		
		String findValuesToEncode = "POSITcode*" + guid + "*" + time + "*" + findName
				 + "*" + description + "*" + latitude + "*" + longitude;
		
		QrCodeEncoder doEncode = new QrCodeEncoder(findValuesToEncode);
		Bitmap bitmap = doEncode.encodeAndSave();
        setContentView(new BitMapView(this, bitmap));
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
		byte[] b = baos.toByteArray();
		String img_str = Base64.encodeToString(b, Base64.DEFAULT);
		
		Camera.savePhoto(find.getGuid() + "_code", img_str, this);
}

```

Also, "encodeFindAsBarcode" is called from the saveFind() function in
FindActivity.java whenever a new Find is created or a Find is updated.