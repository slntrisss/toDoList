package org.example.springboot.controller;

import org.example.springboot.dao.ToDoDAO;
import org.example.springboot.model.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ToDoController {

    private ToDoDAO dao;

    @Autowired
    public ToDoController(ToDoDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/index")
    public String index(Model model){
        List<ToDoList> list = dao.index();
        model.addAttribute("lists", list);
        return "toDo/index";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") int id, Model model){
        ToDoList toDoList = dao.show(id);
        model.addAttribute("tasks", toDoList);
        return "toDo/show";
    }

    @GetMapping("/create")
    public String newList(@ModelAttribute("list") ToDoList toDoList){
        return "toDo/new";
    }

    @PostMapping("/index")
    public String create(@ModelAttribute("toDoList") ToDoList toDoList){
        dao.create(toDoList);
        return "redirect:/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        ToDoList list = dao.show(id);
        model.addAttribute("list", list);
        return "toDo/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("list") ToDoList list, @PathVariable("id") int id){
        dao.update(id, list);
        return "redirect:/index";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        dao.delete(id);
        return "redirect:/index";
    }
}
