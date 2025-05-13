package jwp.controller;

import core.jdbc.KeyHolder;
import core.mvc.*;
import jwp.dao.QuestionDao;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Map;

public class CreateQuestionController implements ControllerV2 {

    @Override
    public String execute(Map<String, String> params, Map<String, Object> model) throws SQLException {
        QuestionDao questionDao = new QuestionDao();
        Question question = new Question(
                params.get("writer"),
                params.get("title"),
                params.get("contents"));
        Question savedQuestion = questionDao.insert(question);
        return "redirect:/";
    }
}