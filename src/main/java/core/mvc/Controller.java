package core.mvc;

import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Map;

public interface Controller {
    default void setSession(HttpSession session) {
    }

    default void setUserFromSession(User user) {
    }
}
