package jwp.controller;

import core.mvc.*;
import jwp.dao.QuestionDao;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class HomeController implements Controller{

    @Override
    public String execute(Map<String, String> params, Map<String, Object> model) throws SQLException {
        QuestionDao questionDao = new QuestionDao();
        List<Question> questions = questionDao.findAll();
        model.put("questions",questions);
        return "/home.jsp";
    }
}
