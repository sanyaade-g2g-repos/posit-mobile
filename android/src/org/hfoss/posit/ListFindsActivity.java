/*
 * File: ListFindsActivity.java
 * 
 * Copyright (C) 2009 The Humanitarian FOSS Project (http://www.hfoss.org)
 * 
 * This file is part of POSIT, Portable Open Search and Identification Tool.
 *
 * POSIT is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License (LGPL) as published 
 * by the Free Software Foundation; either version 3.0 of the License, or (at
 * your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU LGPL along with this program; 
 * if not visit http://www.gnu.org/licenses/lgpl.html.
 * 
 */
package org.hfoss.posit;

import org.hfoss.posit.provider.MyDBHelper;
import org.hfoss.posit.utilities.Utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.SimpleCursorAdapter.ViewBinder;

/**
 * Displays a summary of Finds on this phone in a clickable list.
 *
 */
public class ListFindsActivity extends ListActivity implements ViewBinder{

	private static final String TAG = "ListActivity";
	private MyDBHelper mDbHelper;
	private Cursor mCursor;  // Used for DB accesses

	private static final int confirm_exit=1;

	private static final int CONFIRM_DELETE_DIALOG = 0;
	public static final int FIND_FROM_LIST = 0;
	private static int PROJECT_ID;
    private static final boolean DBG = false;


	/** 
	 * Called when the Activity starts and
	 *  when the user navigates back to ListFindsActivity
	 *  from some other app. It creates a
	 *  DBHelper and calls fillData() to fetch data from the DB.
	 *  @param savedInstanceState contains the Activity's previously
	 *   frozen state.  In this case it is unused.
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		PROJECT_ID = sp.getInt("PROJECT_ID", 0);
		mDbHelper = new MyDBHelper(this);
	}

	/** 
	 * Called when the activity is ready to start 
	 *  interacting with the user. It is at the top of the Activity
	 *  stack.
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		super.onResume();

		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		PROJECT_ID = sp.getInt("PROJECT_ID", 0);
		fillData();
	}

	/**
	 * Called when the system is about to resume some other activity.
	 *  It can be used to save state, if necessary.  In this case
	 *  we close the cursor to the DB to prevent memory leaks.
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onPause(){
		super.onPause();
		stopManagingCursor(mCursor);
		mDbHelper.close(); // NOTE WELL: Can't close while managing cursor
		mCursor.close();
	}

	@Override
	protected void onStop() {
		super.onStop();
		mDbHelper.close();
		mCursor.close();
	}


	@Override
	protected void onDestroy() {
		super.onDestroy();
		mDbHelper.close();
		mCursor.close();
	}


	/**
	 * Puts the items from the DB table into the rows of the view. Note that
	 *  once you start managing a Cursor, you cannot close the DB without 
	 *  causing an error.
	 */
	private void fillData() {
		String[] columns = MyDBHelper.list_row_data;
		int [] views = MyDBHelper.list_row_views;

		mCursor = mDbHelper.fetchAllFinds(PROJECT_ID);	

		//		Uri allFinds = Uri.parse("content://org.hfoss.provider.POSIT/finds_project/"+PROJECT_ID);
		//	    mCursor = managedQuery(allFinds, null, null, null, null);

		if (mCursor.getCount() == 0) { // No finds
			setContentView(R.layout.list_finds);
			return;
		}
		startManagingCursor(mCursor); // NOTE: Can't close DB while managing cursor

		// CursorAdapter binds the data in 'columns' to the views in 'views' 
		// It repeatedly calls ViewBinder.setViewValue() (see below) for each column
		// NOTE: The columns and views are defined in MyDBHelper.  For each column
		// there must be a view and vice versa, although the column (data) doesn't
		// necessarily have to go with the view, as in the case of the thumbnail.
		// See comments in MyDBHelper.
		SimpleCursorAdapter adapter = 
			new SimpleCursorAdapter(this, R.layout.list_row, mCursor, columns, views);
		adapter.setViewBinder(this);
		setListAdapter(adapter); 
		//stopManagingCursor(mCursor);
	}


	/* (non-Javadoc)
	 * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}

	/**
	 * Invoked when the user clicks on one of the Finds in the
	 *   list. It starts the FindActivity in EDIT mode, which will read
	 *   the Find's data from the DB.
	 *   @param l is the ListView that was clicked on 
	 *   @param v is the View within the ListView
	 *   @param position is the View's position in the ListView
	 *   @param id is the Find's RowID
	 */
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(this, FindActivity.class);
		intent.setAction(Intent.ACTION_EDIT);
		if (DBG) Log.i(TAG,"id = " + id);
		intent.putExtra(MyDBHelper.COLUMN_ID, id);
//		intent.putExtra(MyDBHelper.COLUMN_GUID, mDbHelper.getGuIdFromRowId(id));

		startActivityForResult(intent, FIND_FROM_LIST);
		FindActivity.SAVE_CHECK=false;
	}

	/**
	 * Creates the menus for this activity.
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.list_finds_menu, menu);
		return true;
	}

	/** 
	 * Starts the appropriate Activity when a MenuItem is selected.
	 * @see android.app.Activity#onMenuItemSelected(int, android.view.MenuItem)
	 */
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		Intent intent;
		switch (item.getItemId()) {

		case R.id.sync_finds_menu_item: 

			SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
			boolean syncIsOn = sp.getBoolean("SYNC_ON_OFF", true);
			if (!syncIsOn) {
				Utils.showToast(this, "Synchronization is turned off.");
				break;
			}
			intent = new Intent(this, SyncActivity.class);
			intent.setAction(Intent.ACTION_SYNC);
			startActivity(intent);
			break;

		case R.id.map_finds_menu_item:
			mDbHelper.close();
			intent = new Intent(this, MapFindsActivity.class);
			startActivity(intent);
			break;

		case R.id.delete_finds_menu_item:
			showDialog(CONFIRM_DELETE_DIALOG);
			break;

			//		case R.id.georss:
			//			generateGeoRSS();
			//			break;
			//			
		}
		return true;
	}

	/**
	 * What is this and why is it here??
	 */
	//	public void generateGeoRSS() {
	//		mCursor = mDbHelper.fetchAllFinds(PROJECT_ID);
	//		startManagingCursor(mCursor);
	//
	//		try{
	//			FileOutputStream fout = new FileOutputStream("/data/rss/data.xml");
	//			PrintStream out = new PrintStream(fout);
	//			out.println("<feed xmlns=\"http://www.w3.org/2005/Atom\"");
	//			out.println("xmlns:georss=\"http://www.georss.org/georss\"");
	//			out.println("xmlns:gml=\"http://www.opengis.net/gml\">");
	//			mCursor.moveToFirst();
	//			while(!mCursor.isAfterLast()) {
	//				out.println("<entry>");
	//				out.println("<title>"+
	//					mCursor.getString(mCursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_NAME))+
	//					"</title>");
	//				out.println("<description>"+
	//					mCursor.getString(mCursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_DESCRIPTION))+
	//					"</description>");
	//				out.println("<georss:where>");
	//				out.println("<gml:Point>");
	//				out.println("<gml:pos>"+
	//					mCursor.getDouble(mCursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_LATITUDE))+" "+
	//					mCursor.getDouble(mCursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_LONGITUDE))+
	//					"</gml:pos>");
	//				out.println("</gml:Point>");
	//				out.println("</georss:where>");
	//				out.println("<datetime>"+
	//						mCursor.getString(mCursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_TIME))+
	//						"</datetime>");
	//				out.println("</entry>");
	//				mCursor.moveToNext();
	//			}
	//			out.println("</feed>");
	//			out.close();
	//		}
	//		catch(IOException e){e.printStackTrace();}
	//		finally{
	//			Utils.showToast(this, "GeoRSS created!");
	//		}
	//	}

	/**
	 * Part of ViewBinder interface. Binds the Cursor column defined 
	 * by the specified index to the specified view. When binding is handled 
	 * by this ViewBinder, this method must return true. If this method returns false, 
	 * SimpleCursorAdapter will attempt to handle the binding on its own.
	 */
	public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
		TextView tv = null; // = (TextView) view;
		long findIden = cursor.getLong(cursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_BARCODE));
		switch (view.getId()) {
	
		case R.id.find_image:
			if (DBG) Log.i(TAG,"setViewValue case find_image=" + view.getId() );
			int rowId = cursor.getInt(cursor
					.getColumnIndexOrThrow(MyDBHelper.COLUMN_ID));
			MyDBHelper myDbHelper = new MyDBHelper(this);
			ContentValues values = myDbHelper.getImages(rowId);
			ImageView iv = (ImageView) view;
			if (values != null && values.containsKey(getString(R.string.imageUriDB))) {
				String strUri = values.getAsString(getString(R.string.imageUriDB));
				if (DBG) Log.i(TAG,"setViewValue strUri=" + strUri);
				if (strUri != null) {
					if (DBG) Log.i(TAG,"setViewValue strUri=" + strUri);
					Uri iUri = Uri.parse(strUri);
					iv.setImageURI(iUri);
					iv.setScaleType(ImageView.ScaleType.FIT_XY);
				} else {
					iv.setImageResource(R.drawable.person_icon);
					iv.setScaleType(ImageView.ScaleType.FIT_XY);
				}
			} else {
				iv.setImageResource(R.drawable.person_icon);
				iv.setScaleType(ImageView.ScaleType.FIT_XY);
			}
			if (DBG) Log.i(TAG,"setViewValue case find_image finished");
			return true;
		case R.id.latitude_id:
			tv = (TextView) view;
			String lat = cursor.getString(cursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_LATITUDE));
			tv.setText("Location: "+lat);
			return true;
		case R.id.longitude_id:
			tv = (TextView) view;
			String lon = cursor.getString(cursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_LONGITUDE));
			tv.setText(", "+lon);
			return true;
		case R.id.status:
			tv = (TextView) view;
			int status = cursor.getInt(cursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_SYNCED));
			tv.setText(status==1?"Synced  ":"Not synced  ");
			return true;
		case R.id.num_photos:
			tv = (TextView) view;
			Uri findPhotos = Uri.parse("content://org.hfoss.provider.POSIT/photo_findid/"+findIden);
			int count = managedQuery(findPhotos, null, null, null, null).getCount();
			tv.setText(count+" photos  ");
			return true;
		default:
			return false;
		}
	}
	/*@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if(keyCode==KeyEvent.KEYCODE_BACK){
			showDialog(confirm_exit);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}*/



	/**
	 * This method is invoked by showDialog() when a dialog window is created. It displays
	 *  the appropriate dialog box, currently a dialog to confirm that the user wants to 
	 *  delete all the finds.
	 */
	@Override
	protected Dialog onCreateDialog(int id) {

		switch (id) {
		case CONFIRM_DELETE_DIALOG:
			return new AlertDialog.Builder(this)
			.setIcon(R.drawable.alert_dialog_icon)
			.setTitle(R.string.alert_dialog)
			.setPositiveButton(R.string.alert_dialog_ok, 
					new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					// User clicked OK so do some stuff 
					MyDBHelper mDbHelper = new MyDBHelper(ListFindsActivity.this);
					if (mDbHelper.deleteAllFinds()) {
						mDbHelper.close();
						Utils.showToast(ListFindsActivity.this, R.string.deleted_from_database);
						finish();
					} else {
						mDbHelper.close();
						Utils.showToast(ListFindsActivity.this, R.string.delete_failed);
						dialog.cancel();
					}
					/*
					int count = getContentResolver().delete(Uri.parse("content://org.hfoss.provider.POSIT/finds_project/"+PROJECT_ID), null, null);
					if (DBG) Log.i("PROVIDER", "deleted "+ count);
					Utils.showToast(ListFindsActivity.this, R.string.deleted_from_database);
					setContentView(R.layout.list_finds);
					 */
					//finish();
					//Intent intent = new Intent(ListFindsActivity.this, ListFindsActivity.class);
					//startActivity(intent);
					//TabMain.moveTab(0);
					//TabMain.moveTab(1);
				}
			}).setNegativeButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					/* User clicked Cancel so do nothing */
				}
			}).create();

		} // switch

		switch (id) {
		case confirm_exit:
			return new AlertDialog.Builder(this)
			.setIcon(R.drawable.alert_dialog_icon)
			.setTitle(R.string.exit)
			.setPositiveButton(R.string.alert_dialog_ok, 
					new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					// User clicked OK so do some stuff 
					finish();
				}
			}).setNegativeButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					/* User clicked Cancel so do nothing */
				}
			}).create();

		default:
			return null;
		}
	}

}
