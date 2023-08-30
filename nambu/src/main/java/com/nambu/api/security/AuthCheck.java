package com.nambu.api.security;

import com.google.gson.JsonObject;
import com.nambu.api.util.Utils;

/**
 * <p>인증 처리</p> 
 */
public class AuthCheck {
	/**
	 * <p>api-key 인증</p>
	 * @param apikey 클라이언트로 부터 받은 apikey
	 * @return Json 
	 */	
	public String getMetaAuthErrGenerator(String apikey) throws Exception {
		Utils utils = new Utils();
		SignVerifier verifier = new SignVerifier();
		JsonObject result = new JsonObject();
	    //============================================================
	    //< api-key 인증 처리
	    //============================================================
	    if (!verifier.verifySignature(apikey)) {
	        result = utils.getMetaErrGenerator(10000, "AUTH");
	        return result.toString();
	    }
	    return result.toString();
	}
}