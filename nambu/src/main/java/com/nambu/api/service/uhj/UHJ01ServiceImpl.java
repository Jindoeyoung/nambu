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

@Service
@RequiredArgsConstructor
public class UHJ01ServiceImpl implements UHJ01Service {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UHJ01Mapper uhj01Mapper;
//	private final UHJ01Mapper uhj01Mapper;

	AuthCheck authcheck = new AuthCheck();
//	@Autowired(required=false)
//	private AuthCheck authcheck;
//	@Autowired
//	private final AuthCheck authcheck;

	@Override
	public String getStudentList(@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm) throws Exception {

	    //============================================================
	    //< api-key check
	    //============================================================
		if (!authcheck.getMetaAuthErrGenerator(hakjeokm.getApikey()).equals("{}")) {
			return authcheck.getMetaAuthErrGenerator(hakjeokm.getApikey());
		}

		List<StHakJeokM> datas = uhj01Mapper.getStudentList(hakjeokm);

		JsonObject dataResult = new JsonObject();
		JsonArray jsonArr1 = new JsonArray();

		String Message = "SUCCESS";
		dataResult.addProperty("reason", Message);
		dataResult.addProperty("result", "1");



		if (datas.size() > 0) {

			for (StHakJeokM item : datas) {
//			System.out.println("item==>"+item);

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

//			dataResult.addProperty("data", "");
		}

		return dataResult.toString();
//		return uhj01Mapper.getStudentList(hakjeokm).toString();
	}


	@Override
	public int insertStudent(@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm) throws Exception {
		try {
			if (!authcheck.getMetaAuthErrGenerator(hakjeokm.getApikey()).equals("{}")) {
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

	@Override
	public int updateStudent(@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm) {
		try {
			if (!authcheck.getMetaAuthErrGenerator(hakjeokm.getApikey()).equals("{}")) {
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

	@Override
	public int deleteStudent(@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm) {
		try {
			if (!authcheck.getMetaAuthErrGenerator(hakjeokm.getApikey()).equals("{}")) {
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