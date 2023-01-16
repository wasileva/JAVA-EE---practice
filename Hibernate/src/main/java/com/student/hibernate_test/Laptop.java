package com.student.hibernate_test;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="laptops")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Laptop {
    
    @Id
    private int id;
    private String name;
    @ManyToOne
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Laptop() {
    }

    public Laptop(int id, String name, Student student) {
        this.id = id;
        this.name = name;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Laptop{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
