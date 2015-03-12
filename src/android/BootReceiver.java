package com.red_folder.phonegap.plugin.backgroundservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {  
	
	/*
	 ************************************************************************************************
	 * Overriden Methods 
	 ************************************************************************************************
	 */
	@Override  
	public void onReceive(Context context, Intent intent) {
		
		// Get all the registered and loop through and start them
		String[] serviceList = PropertyHelper.getBootServices(context);
		
		if (serviceList != null) {
			for (int i = 0; i < serviceList.length; i++)
			{
				// Fix to https://github.com/Red-Folder/bgs-core/issues/18
				// Gets the class from string
				Class<?> serviceClass = ReflectionHelper.LoadClass(serviceList[i]);

				Intent serviceIntent = new Intent(context, serviceClass);         
				context.startService(serviceIntent);
			}
		}
	} 
	
} 
