package com.nambu.api.mapper.uhj;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nambu.api.entity.uhj.StHakJeokM;

@Mapper
public interface UHJ01Mapper {
	List<StHakJeokM> getStudentList(
		@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm
	);

	int insertStudent(
		@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm
	);

	int updateStudent(
		@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm
	);

	int deleteStudent(
		@Param("ST_HAKJEOK_M") StHakJeokM hakjeokm
	);
}
