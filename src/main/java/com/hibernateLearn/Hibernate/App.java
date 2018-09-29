package com.hibernateLearn.Hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
        
    	//Student st=null;
    	
    	Taylor ty=new Taylor();
    	ty.setId(2);
    	ty.setFav(true);
    	Songs song= new Songs();
    	song.setName("22");
    	song.setYear(2012);
    	ty.setSong(song);
    	
    	Taylor t1=null;
    	Taylor t2=null;
    	List<Taylor> tay=new ArrayList<Taylor>();
    	List<Taylor> taylor=new ArrayList<Taylor>();
    	//Configuration conf=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        Configuration conf=new Configuration().configure().addAnnotatedClass(Taylor.class);
    	ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        SessionFactory sf=conf.buildSessionFactory(reg);
        Session s=sf.openSession();
        s.beginTransaction();
        //t1=(Taylor)s.get(Taylor.class,1);
        tay=(List<Taylor>)s.createQuery("from Taylor").setCacheable(true).list();
        s.getTransaction().commit();
        s.close();
        
        
        Session s2=sf.openSession();
        s2.beginTransaction();
        //t2=(Taylor)s2.get(Taylor.class,1);
        taylor=(List<Taylor>)s2.createQuery("from Taylor").setCacheable(true).list();
        s2.getTransaction().commit();
        s2.close();
        
        
        
        
        
//        Transaction tx=s.beginTransaction();
//        
//        tay=s.createQuery("from Taylor").list();
//        
//        //Saving in Cache Level 1
//        t1=(Taylor)s.get(Taylor.class, 1);
//        //t2=(Taylor)s.get(Taylor.class, 1);
//        //s.persist(ty);        
//        /*s.save(stu);
//        s.save(laptop);*/
//        /*st=(Student)s.get(Student.class,2);
//        System.out.println(st);*/
//        tx.commit();
//        
//        
//        Session st=sf.openSession();
//        Transaction txt=st.beginTransaction();
//        taylor=st.createQuery("from Taylor").list();
//        
//        t2=(Taylor)st.get(Taylor.class,1);
//        txt.commit();
//        
//        for(Taylor t:tay){
//        	System.out.println(t);
//        }
//        for(Taylor t:taylor){
//        	System.out.println(t);
//        }
    }
}
