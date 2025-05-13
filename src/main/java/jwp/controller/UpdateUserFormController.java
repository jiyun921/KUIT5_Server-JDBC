package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.*;
import jwp.dao.UserDao;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Map;

public class UpdateUserFormController implements Controller {
    private HttpSession session;
    @Override
    public String execute(Map<String, String> params, Map<String, Object> model) throws SQLException {
        String userId = params.get("userId");         // 수정되는 user
        //User user = MemoryUserRepository.getInstance().findUserById(userId);
        UserDao userDao = new UserDao();
        User user = userDao.findByUserId(userId);

        // 수정하는 user
        Object value = session.getAttribute("user");

        if (user != null && value != null) {
            if (user.equals(value)) {            // 수정되는 user와 수정하는 user가 동일한 경우
                return "/user/updateForm.jsp";
            }
        }
        return "redirect:/";
    }
}