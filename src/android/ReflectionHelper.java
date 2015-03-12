package com.red_folder.phonegap.plugin.backgroundservice;

import android.util.Log;

public class ReflectionHelper {
	
	/*
	 ************************************************************************************************
	 * Static values 
	 ************************************************************************************************
	 */
	public static final String TAG = ReflectionHelper.class.getSimpleName();
	
	public static Class<?> LoadClass(String className) {
		Class<?> result = null;
	
		Log.d(TAG, "Attempting to load call: " + className);
		ClassLoader classLoader = ReflectionHelper.class.getClassLoader();

		try {
			result = classLoader.loadClass(className);
			Log.d(TAG, "Class loaded");
		} catch (ClassNotFoundException ex) {
			Log.d(TAG, "Class failed to load");
			Log.d(TAG, ex.getMessage());
		}
		
		return result;
	}
}
