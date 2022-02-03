package edu.eci.ieti.TasksRestAPI.dto;

import edu.eci.ieti.TasksRestAPI.data.TaskStatus;
import edu.eci.ieti.TasksRestAPI.exception.TaskException;

public class TaskDto {

    private String name;
    private String description;
    private String status;
    private String assignedTo;
    private String dueDate;

    public TaskDto(){

    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getName(){
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String toString(){
        return "{ Name: " + name + ", Description: " + description + ", Status: " + status + ", AssignedTo: " + assignedTo + ", DueDate: " + dueDate + "}";
    }
}
