package org.example.springboot.dao;

import org.example.springboot.model.ToDoList;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TaskMapper implements RowMapper<ToDoList> {
    @Override
    public ToDoList mapRow(ResultSet rs, int rowNum) throws SQLException {
        ToDoList toDoList = new ToDoList();
        toDoList.setName(rs.getString("name"));
        LocalDate date = LocalDate.parse(rs.getString("date"));
        toDoList.setDate(date);
        toDoList.setDescription(rs.getString("description"));
        toDoList.setDone(rs.getBoolean("isDone"));
        toDoList.setPriority(rs.getInt("priority"));
        return toDoList;
    }
}
