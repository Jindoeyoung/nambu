package com.nambu.api.service.uhj;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.nambu.api.entity.uhj.StHakJeokM;
import com.nambu.api.mapper.uhj.UHJ01Mapper;
import com.nambu.api.security.AuthCheck;

import lombok.RequiredArgsConstructor;

/**
 * <p>ServiceImpl</p>
 * <ul>
 * 	<li>Service 에 정의된 interface 를 상속받아 사용</li>
 * 	<li>각 서비스 로직 구현</li>
 * </ul> 
 */
@Service
@RequiredArgsConstructor
public class UHJ01ServiceImpl implements UHJ01Service {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UHJ01Mapper uhj01Mapper;
	AuthCheck authcheck = new AuthCheck();

    //============================================================
    //< SELECT
    //============================================================
	@Override
	public String getStudentList(@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm) throws Exception {
	    //============================================================
	    //< api-key check
	    //============================================================
		if (!authcheck.getMetaAuthErrGenerator(hakjeokm.getApikey()).equals("{}")) {
			return authcheck.getMetaAuthErrGenerator(hakjeokm.getApikey());
		}

		List<StHakJeokM> datas = uhj01Mapper.getStudentList(hakjeokm);

        //============================================================
        //< json 포맷 데이터 생성
        //============================================================		
		JsonObject dataResult = new JsonObject();
		JsonArray jsonArr1 = new JsonArray();
		String Message = "SUCCESS";
		String Success = "1";
		
		dataResult.addProperty("reason", Message);
		dataResult.addProperty("result", Success);

		if (datas.size() > 0) {
			for (StHakJeokM item : datas) {

				JsonObject Obj1 = new JsonObject();
				JsonObject Obj2 = new JsonObject();

				Obj1.addProperty("hakbeon", item.getHakbeon());
				Obj1.addProperty("haknyeon", item.getCurr_haknyeon());
				Obj1.addProperty("h_name", item.getH_name());
				Obj1.addProperty("hakgwa", item.getHakgwa());
				Obj1.addProperty("ban", item.getCurr_ban());
				Obj1.addProperty("sex", item.getSex());
				Obj1.addProperty("sangtae", item.getSangtae());
				Obj1.addProperty("bigo", item.getBigo());

				jsonArr1.add(Obj1);

				Obj2.add("result", jsonArr1);
				dataResult.add("data", Obj2);
			}
		} else {
			JsonObject Obj3 = new JsonObject();
			Obj3.add("result", jsonArr1);
			dataResult.add("data", Obj3);
		}
		return dataResult.toString();
	}


    //============================================================
    //< INSERT
    //============================================================
	@Override
	public int insertStudent(@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm) throws Exception {
		try {
			if (!authcheck.getMetaAuthErrGenerator(hakjeokm.getApikey()).equals("{}")) {
			    //============================================================
			    //< api-key check
			    //============================================================				
				logger.info("[UHJ01ServiceImpl][insertStudent] AUTHENTICATION RESTRICTIONS");
			} else {
				return uhj01Mapper.insertStudent(hakjeokm);
			}
		} catch (Exception e) {
			// TODO
			e.printStackTrace();
		}
		return 0;
	}

    //============================================================
    //< UPDATE
    //============================================================	
	@Override
	public int updateStudent(@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm) {
		try {
			if (!authcheck.getMetaAuthErrGenerator(hakjeokm.getApikey()).equals("{}")) {
			    //============================================================
			    //< api-key check
			    //============================================================				
				logger.info("[UHJ01ServiceImpl][updateStudent] AUTHENTICATION RESTRICTIONS");
			} else {
				return uhj01Mapper.updateStudent(hakjeokm);
			}
		} catch (Exception e) {
			// TODO
			e.printStackTrace();
		}
		return 0;
	}

    //============================================================
    //< DELETE
    //============================================================	
	@Override
	public int deleteStudent(@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm) {
		try {
			if (!authcheck.getMetaAuthErrGenerator(hakjeokm.getApikey()).equals("{}")) {
			    //============================================================
			    //< api-key check
			    //============================================================				
				logger.info("[UHJ01ServiceImpl][deleteStudent] AUTHENTICATION RESTRICTIONS");
			} else {
				return uhj01Mapper.deleteStudent(hakjeokm);
			}
		} catch (Exception e) {
			// TODO
			e.printStackTrace();
		}
		return 0;
	}
}
