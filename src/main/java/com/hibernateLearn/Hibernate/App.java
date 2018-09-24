package com.hibernateLearn.Hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/*
    	Laptop laptop=new Laptop();
    	laptop.setId(102);
    	laptop.setBrand("Lenovo");
    	
    	Student stu=new Student();
    	stu.setRollno(2);
    	stu.setName("Rahul");
    	stu.setMarks(100);
    	stu.getLaptop().add(laptop); 
    	
    	laptop.getStud().add(stu);
        */
        
    	Student st=null;
        Configuration conf=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        SessionFactory sf=conf.buildSessionFactory(reg);
        Session s=sf.openSession();
        Transaction tx=s.beginTransaction();
        
        //s.save(stu);
        //s.save(laptop);
        st=(Student)s.get(Student.class,2);
        System.out.println(st);
        tx.commit();
     
    }
}
