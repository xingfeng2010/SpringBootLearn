package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JdbcService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询
     * @return
     */
    public List findAll() {
        String listSql = "select * from t_user";
        final List result = new ArrayList();
        jdbcTemplate.query(listSql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                Map row = new HashMap<>();
                row.put("id", resultSet.getInt("t_id"));
                row.put("name", resultSet.getString("t_name"));
                row.put("age", resultSet.getInt("t_age"));
                row.put("address", resultSet.getString("t_address"));
                result.add(row);
            }
        });

        return result;
    }

    /**
     * 新增
     * @param name
     * @param age
     * @param address
     * @return
     */
  public int save(String name, String age, String address) {
      String insertSql = "insert into t_user(t_name, t_age, t_address) values (?,?,?)";
      int count = jdbcTemplate.update(insertSql, new PreparedStatementSetter() {
          @Override
          public void setValues(PreparedStatement preparedStatement) throws SQLException {
              preparedStatement.setObject(1, name);
              preparedStatement.setObject(2, age);
              preparedStatement.setObject(3, address);
          }
      });

      return count;
  }

    /**
     * 更新
     * @param id
     * @param name
     * @return
     */
  public int update(String id, String name) {
      String updateSql = "update t_user set t_name = ? where t_id = ?";
      int count = jdbcTemplate.update(updateSql, new PreparedStatementSetter() {
          @Override
          public void setValues(PreparedStatement preparedStatement) throws SQLException {
              preparedStatement.setObject(1, name);
              preparedStatement.setObject(2, id);
          }
      });

      return count;
  }

    /**
     * 删除
     * @param id
     * @return
     */
  public int delete(String id) {
      String deleteSql = "delete from t_user where t_id=?";
      return jdbcTemplate.update(deleteSql, new Object[]{id});
  }




























}
