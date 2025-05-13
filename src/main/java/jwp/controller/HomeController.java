package jwp.controller;

import core.mvc.*;
import jwp.dao.QuestionDao;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class HomeController implements ControllerV1 {

    private final QuestionDao questionDao = new QuestionDao();
    public String execute(Map<String, String> params, Map<String, Object> model) throws SQLException {
        List<Question> questions = questionDao.findAll();
        model.put("questions",questions);
        return "/home.jsp";
    }

    @Override
    public ModelAndView execute(Map<String, String> params) throws SQLException {
        List<Question> questions = questionDao.findAll();

        return new ModelAndView("/home.jsp").addObject("questions", questions);
    }
}
