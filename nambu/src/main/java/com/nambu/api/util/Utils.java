package com.nambu.api.util;

import com.google.gson.JsonObject;

public class Utils {
	public JsonObject getMetaErrGenerator(Integer responseCode, String type) throws Exception {

		JsonObject dataResult = new JsonObject();
		String desc = "";
		String result = "-3";

		try {
			if (responseCode == 10000 ) {
				desc = "AUTHENTICATION RESTRICTIONS";
				result = "-3";
			} else {
				desc = "ETC ERROR, PLEASE CHECK";
			}
			dataResult.addProperty("reason", "[" + responseCode + " ERROR] " + desc);
			dataResult.addProperty("result", result);
			dataResult.addProperty("data", "");

			return dataResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataResult;
	}
}