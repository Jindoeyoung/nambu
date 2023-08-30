package com.nambu.api.util;

import com.google.gson.JsonObject;

/**
 * <p>Util</p>
 * <ul>
 * 	<li>공통 function을 구현하여 사용</li>
 * </ul> 
 */
public class Utils {
	public JsonObject getMetaErrGenerator(Integer responseCode, String type) throws Exception {

		JsonObject dataResult = new JsonObject();
		String desc = "";
		String result = "0";

		try {
			if (responseCode == 10000 ) {
		        //============================================================
		        //< api-key 오류 시
		        //============================================================				
				desc = "AUTHENTICATION RESTRICTIONS";
				result = "-3";
			} else {
		        //============================================================
		        //< 기타 오류 시
		        //============================================================				
				desc = "ETC ERROR, PLEASE CHECK";
				result = "-4";
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