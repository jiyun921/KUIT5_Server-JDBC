package jwp.controller;

import core.mvc.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jwp.dao.UserDao;
import jwp.util.UserSessionUtils;

import java.sql.SQLException;
import java.util.Map;

public class ListUserController implements ControllerV2 {

    private HttpSession session;

    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Override
    public String execute(Map<String, String> params, Map<String, Object> model) throws SQLException {
        UserDao userDao = new UserDao();
        if (UserSessionUtils.isLogined(session)) {
            model.put("users", userDao.findAll());
            return "/user/list.jsp";
        }
        return "redirect:/user/loginForm";
    }
}