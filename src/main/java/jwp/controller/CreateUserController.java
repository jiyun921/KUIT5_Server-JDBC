package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.*;
import jwp.dao.UserDao;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Map;

public class CreateUserController implements ControllerV2 {

    @Override
    public String execute(Map<String, String> params, Map<String, Object> model) throws SQLException {
        User user = new User(params.get("userId"),
                params.get("password"),
                params.get("name"),
                params.get("email"));
        // MemoryUserRepository.getInstance().addUser(user);
        UserDao userDao = new UserDao();
        userDao.insert(user);

        return "redirect:/user/list";
    }
}