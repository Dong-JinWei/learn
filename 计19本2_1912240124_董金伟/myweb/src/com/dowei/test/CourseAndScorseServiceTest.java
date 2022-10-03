package com.dowei.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.dowei.pojo.CourseAndScorse;
import com.dowei.service.CourseAndScorseService;
import com.dowei.service.impl.CourseAndScorseServiceImpl;

public class CourseAndScorseServiceTest {

	CourseAndScorseService courseAndScorseService = new CourseAndScorseServiceImpl();

	@Test
	public void queryScourseAndScorse() {

		List<Map<?, ?>> ScorseList = new ArrayList<Map<?, ?>>();

		List<CourseAndScorse> list = courseAndScorseService.queryScourseAndScorse("admin");

		for (CourseAndScorse courseAndScorse : list) {
			String username = courseAndScorse.getUsername();
			String cno = courseAndScorse.getCno();
			String cname = courseAndScorse.getCname();
			String ctecher = courseAndScorse.getCtecher();
			String scid = courseAndScorse.getScid();
			String scno = courseAndScorse.getScno();
			String score = courseAndScorse.getScore();

			Map<String, String> scoresMap = new HashMap<String, String>();
			scoresMap.put("username", username);
			scoresMap.put("cno", cno);
			scoresMap.put("cname", cname);
			scoresMap.put("ctecher", ctecher);
			scoresMap.put("scid", scid);
			scoresMap.put("scno", scno);
			scoresMap.put("score", score);

			ScorseList.add(scoresMap);
		}

		for (Map<?, ?> map_1 : ScorseList) {
			System.out.println(map_1);
		}

	}

}
