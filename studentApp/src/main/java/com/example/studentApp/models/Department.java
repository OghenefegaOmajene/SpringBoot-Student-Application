package com.example.studentApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

    public Department(){

    }

    public Department(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //create Builder method
    public static DepartmentBuilder builder(){
        return new DepartmentBuilder();
    }

    //create Builder class
    public static class DepartmentBuilder{
        private long id;
        private String name;
        private String description;

        public DepartmentBuilder id(long id){
            this.id = id;
            return this;
        }

        public DepartmentBuilder name(String name){
            this.name = name;
            return this;
        }

        public DepartmentBuilder description(String description){
            this.description = description;
            return this;
        }

        public Department build(){
            return new Department(id, name, description);
        }
    }
}
