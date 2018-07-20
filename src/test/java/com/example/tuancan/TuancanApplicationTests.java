package com.example.tuancan;

import com.example.tuancan.dao.AnswerMapper;
import com.example.tuancan.model.Answer;
import com.example.tuancan.model.QuestionNaire;
import com.example.tuancan.service.AnswerService;
import com.example.tuancan.utils.JsonUtil;
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

	/*测试根据员工id 查询*/
	@Test
	public void  getone(){
		Answer answer = mapper.getone(3);
		System.out.println(answer);
		System.out.println(answer.getGMStaff().getGMStaffId());
	}

	/*测试根据员工id 查询*/
	@Test
	public void  selectAnswerByQues_idOrderByAnswer_date(){
		QuestionNaire questionNaire = new QuestionNaire();
		questionNaire.setQuestionnaireId(1);
		List<Answer> answers = mapper.selectAnswerByQues_idOrderByAnswer_date(questionNaire);
		System.out.println(JsonUtil.toJson(answers));
	}
}
