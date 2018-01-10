package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.model.Answer;

public class AddAnswerController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Answer answer = new Answer(request.getParameter("writer"), request.getParameter("contents"),
				Long.parseLong(request.getParameter("questionId")));

		AnswerDao answerDao = new AnswerDao();
		Long saveAnswerId = answerDao.insert(answer);
		Answer savedAnswer = answerDao.findById(saveAnswerId);
		
		return ApiJsonMapper.mapping(response, savedAnswer);
	}

}
