package com.example.todotracker.models;

public class Task {
    private Long id;
    private String title;
    private String description;
    private Status status;
    public enum Status{
        YET_TO_START,
        IN_PROGRESS,
        COMPLETED
    }
    public Task(){}
    public Task(Long id,String title,String description,Status status){
        this.id=id;
        this.title=title;
        this.description=description;
        this.status=status;
    }

    // Getters and Setters
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getDescrption(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public Status getStatus(){
        return status;
    }
    public void setStatus(Status status){
        this.status=status;
    }
}
