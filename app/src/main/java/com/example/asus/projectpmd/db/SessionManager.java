package com.example.asus.projectpmd.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;

public class SessionManager {

	// Shared Preferences
	private SharedPreferences loginPreferences;
	// Editor for Shared preferences
	private Editor loginPrefsEditor;
	// Context

	Context _context;

	// Shared pref mode
	int PRIVATE_MODE = 0;

	// Sharedpref file name
	private static final String PREF_NAME = "loginPrefs";
	public static final String IMAGE_BITMAP = "image_bitmap";

	public SessionManager(Context context){
		this._context = context;
		loginPreferences = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
		loginPrefsEditor = loginPreferences.edit();
	}

	public String imageBitmap() {
		return loginPreferences.getString(IMAGE_BITMAP, "");
	}


	public void setImageBitmap(String bm) {
		loginPrefsEditor.putString(IMAGE_BITMAP, bm);
		loginPrefsEditor.commit();
	}


}
