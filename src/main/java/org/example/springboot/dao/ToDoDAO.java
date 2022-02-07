package org.example.springboot.dao;

import org.example.springboot.model.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class ToDoDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ToDoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ToDoList> index(){
        List<ToDoList> lists =  jdbcTemplate.query("SELECT * FROM toDoList",
                new TaskMapper());
        sort(lists);
        return lists;
    }

    public ToDoList show(int id){
        return jdbcTemplate.query("SELECT * FROM toDoList WHERE id=?", new Object[]{id},
                new TaskMapper()).stream().findAny().orElse(null);
    }

    public void create(ToDoList newList){
        jdbcTemplate.update("INSERT INTO toDoList VALUES(?, ?, ?, ?, ?, ?)", newList.getName(),
                newList.getDate(), newList.getPriority(), newList.getDescription(), newList.isDone());
    }

    public void update(int id, ToDoList list){
        jdbcTemplate.update("UPDATE toDoList SET name=?, date=?, priority=?, description=?, isDone=? WHERE id=?",
                list.getName(), list.getDate(), list.getPriority(), list.getDescription(), list.isDone(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM toDoList WHERE id=?", id);
    }
    private void sort(List<ToDoList> list){
        Collections.sort(list, new Comparator<ToDoList>() {
            @Override
            public int compare(ToDoList o1, ToDoList o2) {
                return o1.getPriority() - o2.getPriority();
            }
        });
    }
}
