package com.nambu.api.controller.uhj;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nambu.api.entity.uhj.StHakJeokM;
import com.nambu.api.service.uhj.UHJ01Service;

import lombok.RequiredArgsConstructor;

/**
 * <p>Controller</p>
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/uhj/uhj01", produces = "application/json; charset=utf8")
public class UHJ01Controller {

	private final UHJ01Service uhj01Service;

    //============================================================
    //< SELECT
    //============================================================
	@PostMapping("")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String getUser(@RequestBody StHakJeokM _hakjeokm) throws Exception {
		return uhj01Service.getStudentList(_hakjeokm);
	}

    //============================================================
    //< INSERT
    //============================================================
	@PostMapping("/insert")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public int insertUser(@RequestBody StHakJeokM _hakjeokm) throws Exception {
		return uhj01Service.insertStudent(_hakjeokm);
	}

    //============================================================
    //< UPDATE
    //============================================================
	@PutMapping("")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public int updatetUser(@RequestBody StHakJeokM _hakjeokm) throws Exception {
		return uhj01Service.updateStudent(_hakjeokm);
	}

    //============================================================
    //< DELETE
    //============================================================
	@DeleteMapping("")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public int deletetUser(@RequestBody StHakJeokM _hakjeokm) throws Exception {
		return uhj01Service.deleteStudent(_hakjeokm);
	}
}
