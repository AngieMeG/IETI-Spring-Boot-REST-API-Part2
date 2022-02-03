package edu.eci.ieti.TasksRestAPI.data;

import edu.eci.ieti.TasksRestAPI.dto.TaskDto;
import edu.eci.ieti.TasksRestAPI.exception.TaskException;

public class Task {

    private String id;
    private String name;
    private String description;
    private String status;
    private String assignedTo;
    private String dueDate;
    private String created;

    public Task(){

    }

    public Task(TaskDto taskDto) throws TaskException {
        name = taskDto.getName();
        description = taskDto.getDescription();
        try{
            TaskStatus.valueOf(taskDto.getStatus());
            status = taskDto.getStatus();
        } catch (IllegalArgumentException ex){
            throw new TaskException(TaskException.INVALID_STATUS);
        }
        
        assignedTo = taskDto.getAssignedTo();
        dueDate = taskDto.getDueDate();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) throws TaskException {
        try{
            TaskStatus.valueOf(status);
            this.status = status;
        } catch (IllegalArgumentException ex){
            throw new TaskException(TaskException.INVALID_STATUS);
        }
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getId() {
        return id;
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

    public String getCreated() {
        return created;
    }

    public String toString(){
        return "{ ID: " + id + ", Name: " + name + ", Description: " + description + ", Status: " + status + ", AssignedTo: " + assignedTo + ", DueDate: " + dueDate +
        ", Created: " + created+ "}";
    }

    public boolean equals(Task task){
        boolean areEquals = false;
        if(this.name.equals(task.getName()) && this.description.equals(task.getDescription()) && this.status.equals(task.getStatus()) && 
            this.assignedTo.equals(task.getAssignedTo()) && this.dueDate.equals(task.getDueDate())){
                areEquals = true;
            }
        return areEquals;
    }
}
