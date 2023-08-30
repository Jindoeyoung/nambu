package com.nambu.api.service.uhj;

import org.apache.ibatis.annotations.Param;

import com.nambu.api.entity.uhj.StHakJeokM;

public interface UHJ01Service {
	public String getStudentList(@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm) throws Exception;
//	public List<StHakJeokM> getStudentList(@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm);

	public int insertStudent(@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm) throws Exception;

	public int updateStudent(@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm) throws Exception;

	public int deleteStudent(@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm) throws Exception;
}
