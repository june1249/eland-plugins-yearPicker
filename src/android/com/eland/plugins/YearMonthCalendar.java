package com.eland.plugins;

import java.util.Calendar;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;

public class YearMonthCalendar extends CordovaPlugin {
	
	private final String YEAR_PICKER = "year";

	@Override
	public boolean execute(String action, JSONArray args,
			final CallbackContext callbackContext) throws JSONException {
		
		if(action.equals(YEAR_PICKER)) {
			final JSONObject status = new JSONObject();
			JSONObject arg_object = args.getJSONObject(0);
			int maxYear = arg_object.getInt("maxYear");
			final MonthYearPicker picker = new MonthYearPicker(this.cordova.getActivity(), maxYear);
			picker.build(new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					try {
						Log.i("MDM", "Year : " + picker.getSelectedYear() + ", month : " + picker.getSelectedMonthName());
						status.put("date", picker.getSelectedYear() + picker.getSelectedMonthName());
					} catch (JSONException e) {
						e.printStackTrace();
					}
					
					PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, status);
		            pluginResult.setKeepCallback(true);
		            callbackContext.sendPluginResult(pluginResult);
		            
				}
			}, null);
			
			picker.show();
			return true;
		}
		
		return true;
	}

}
