package com.example.tuancan;

import com.example.tuancan.dao.AnswerMapper;
import com.example.tuancan.model.Answer;
import com.example.tuancan.service.AnswerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TuancanApplicationTests {

	@Autowired
	private AnswerService answerService;
	@Autowired
	private  AnswerMapper mapper;

	/*测试select mapper*/
	@Test
	public void testSelect(){
		System.out.println(mapper.selectAll());
	}

	/*测试分页*/
	@Test
	public void contextLoads() {

		Page<Object> objects = PageHelper.startPage(2, 1);

		System.out.println(objects);

		List<Answer> answers = mapper.selectAll();
		Answer a = answers.get(0);

		System.out.println(a);

	}

	@Test
	public void  getAll(){
		List<Answer> answers = mapper.getAll();
		System.out.print(answers);
	}
	@Test
	public void  getone(){
		Answer answer = mapper.getone(1);
		System.out.print(answer);
		//new GroupMealStaffMapper().selectByPrimaryKey()
	}
}
