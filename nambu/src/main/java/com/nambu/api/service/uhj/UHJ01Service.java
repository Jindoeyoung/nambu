package com.nambu.api.service.uhj;

import org.apache.ibatis.annotations.Param;

import com.nambu.api.entity.uhj.StHakJeokM;

/**
 * <p>Service</p>
 */
public interface UHJ01Service {
	
    //============================================================
    //< SELECT
    //============================================================	
	public String getStudentList(@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm) throws Exception;

    //============================================================
    //< INSERT
    //============================================================
	public int insertStudent(@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm) throws Exception;

    //============================================================
    //< UPDATE
    //============================================================	
	public int updateStudent(@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm) throws Exception;

    //============================================================
    //< DELETE
    //============================================================	
	public int deleteStudent(@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm) throws Exception;
}
