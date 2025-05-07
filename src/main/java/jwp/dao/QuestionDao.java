package jwp.dao;

import core.jdbc.JdbcTemplate;
import core.jdbc.RowMapper;
import jwp.model.Question;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class QuestionDao {
    public  List<Question> findAll() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "SELECT * FROM Questions";
        RowMapper<Question> rowMapper = new RowMapper<Question>() {
            @Override
            public Question mapRow(ResultSet resultSet) {
                try {
                    return new Question(resultSet.getInt("questionId"),
                            resultSet.getString("writer"),
                            resultSet.getString("title"),
                            resultSet.getString("contents"),
                            resultSet.getTimestamp("createdDate"),
                            resultSet.getInt("countOfAnswer")
                    );
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        };
        return jdbcTemplate.query(sql, preparedStatement -> {}, rowMapper);
    }
}
