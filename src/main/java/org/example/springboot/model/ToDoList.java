package org.example.springboot.model;

import java.time.LocalDate;
import java.util.Date;


public class ToDoList {
    private static int ID;
    private int id;
    private String name;
    private LocalDate date;
    private int priority;
    private String description;
    private boolean isDone;

    public ToDoList(){
    }

    public ToDoList(String name, LocalDate date, int priority) {
        this.name = name;
        this.date = date;
        this.priority = priority;
        this.id = (int)(Math.random() * 100);
    }

    public ToDoList(String name, LocalDate date, int priority, String description) {
        this.name = name;
        this.date = date;
        this.priority = priority;
        this.description = description;
        this.id = (int)(Math.random() * 100);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
