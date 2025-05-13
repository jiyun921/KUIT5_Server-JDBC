package jwp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.mvc.*;
import jwp.dao.AnswerDao;
import jwp.dao.QuestionDao;
import jwp.model.Answer;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import static core.mvc.ViewResolver.JSON_VIEW_PREFIX;

public class AddAnswerController implements Controller {
    AnswerDao answerDao = new AnswerDao();
    QuestionDao questionDao = new QuestionDao();
    @Override
    public String execute(Map<String, String> params, Map<String, Object> model) throws SQLException {
        Answer answer = new Answer(Integer.parseInt(params.get("questionId")), params.get("writer"),
                params.get("contents"));

        Answer savedAnswer = answerDao.insert(answer);

        Question question = questionDao.findByQuestionId(answer.getQuestionId());
        question.increaseCountOfAnswer();
        questionDao.updateCountOfAnswer(question);

        model.put("answer", answer);
        return JSON_VIEW_PREFIX;
    }

}
