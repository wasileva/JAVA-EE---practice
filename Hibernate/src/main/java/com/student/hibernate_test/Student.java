package com.student.hibernate_test;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="students")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Student {
    @Id
   // @GeneratedValue()
    private int id;   
    private StudentFullName name;   
    private int age;
    
    
    @Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
    @OneToMany(mappedBy="student", fetch=FetchType.EAGER)
    private List<Laptop> laptops = new ArrayList<>();

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentFullName getName() {
        return name;
    }

    public void setName(StudentFullName name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuffer buf = null;
        if (laptops!=null){
            buf = new StringBuffer();
            for (Laptop lap : laptops){
                buf.append( " " + lap.getId() + " " + lap.getName() + " " );
            }
        }
        return "Student{" + "id=" + id + ", name=" + name + ", age=" + age +  "  laptop" + buf + '}';
    }
   
}
