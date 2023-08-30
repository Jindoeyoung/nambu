package com.nambu.api.mapper.uhj;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nambu.api.entity.uhj.StHakJeokM;

/**
 * <p>Mapper</p>
 */
@Mapper
public interface UHJ01Mapper {
	
    //============================================================
    //< SELECT
    //============================================================	
	List<StHakJeokM> getStudentList(
		@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm
	);

    //============================================================
    //< INSERT
    //============================================================	
	int insertStudent(
		@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm
	);

    //============================================================
    //< UPDATE
    //============================================================	
	int updateStudent(
		@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm
	);

    //============================================================
    //< DELETE
    //============================================================	
	int deleteStudent(
		@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm
	);
}
