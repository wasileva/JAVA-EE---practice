package com.student.hibernate_test;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main (String[] args){
        
        Laptop laptop = new Laptop();
        laptop.setId(3);
        laptop.setName("MAC");     
        
        Student student = new Student();
        student.setId(2);
        student.setAge(22);
        StudentFullName fullName = new StudentFullName("Mikki", "Voli", "Koor");
        student.setName(fullName);   
        student.getLaptops().add(laptop);             
      
        Book book = new Book(1, "Fathers and Children", "Dostoevsky"); 

        Configuration con = new Configuration().configure();
                                
        con.addAnnotatedClass(Student.class);
        con.addAnnotatedClass(Laptop.class);
        con.addAnnotatedClass(Book.class);
        
        StandardServiceRegistryBuilder sBuilder = new StandardServiceRegistryBuilder().
                applySettings(con.getProperties());
        SessionFactory sFactory = con.buildSessionFactory(sBuilder.build());
          
        Session session1 = sFactory.openSession();     
        Transaction transaction1 = session1.beginTransaction();
        
        SQLQuery query = session1.createSQLQuery("select * from students");
        query.addEntity(Student.class);
        List<Student> sts = query.list();
        
        for (Student s : sts){
            System.out.println(s);
        }
        
        SQLQuery q = session1.createSQLQuery("select age, fName from students");
        q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List students = q.list();
        
        for (Object obj : students){
            Map map = (Map)obj;
            System.out.println(map.get("age") + " " + map.get("fName"));           
        }
    /*  session1.save(laptop);
        session1.save(student);
        session1.save(book);     
        Student stRead = session1.get(Student.class, 1);
   */
        Query q1 = session1.createQuery("from Book where id = 1");
        q1.setCacheable(true);
        Book lap = (Book) q1.uniqueResult();
        System.out.println(lap);
    
    /*  stRead.setAge(19);
        session1.update(stRead);
        student.setId(4);
        session1.delete(student);
    */

        transaction1.commit();
        session1.close();
        
        Session session2 = sFactory.openSession();
        Transaction transaction2 = session2.beginTransaction();
        
     // Student stRead2 = session2.get(Student.class, 1);
        Query q2 = session2.createQuery("from Book where id = 1");
        q2.setCacheable(true);
        Book lap2 = (Book) q2.uniqueResult();
        System.out.println(lap2);
     
        transaction2.commit();
    }
}
