package com.example.tuancan;

import com.example.tuancan.dao.AnswerMapper;
import com.example.tuancan.model.Answer;
import com.example.tuancan.service.AnswerService;
import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TuancanApplicationTests {

	@Autowired
	private AnswerService answerService;
	@Autowired
	private  AnswerMapper mapper;
	@Test
	public void contextLoads() {
		 
		System.out.println(mapper.selectOne(2));




	}

}
