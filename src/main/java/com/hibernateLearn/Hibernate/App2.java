package com.hibernateLearn.Hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App2 {

	public static void main(String[] args) {
		Configuration conf=new Configuration().configure().addAnnotatedClass(Students.class);
		ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf=conf.buildSessionFactory(sr);
		Session s=sf.openSession();
		
	    Transaction tx=s.beginTransaction();
		
	    //Store The Data
		/*Random r=new Random();
		
		Students st;
		for(int i=1;i<=20;i++){
			st=new Students();
			st.setRollno(i);
			st.setName("Name " + i);
			st.setMarks(r.nextInt(100));
			s.persist(st);
		}*/
	    
	    int m=40;
	    Students st=(Students)s.createQuery("from Students where id=9").uniqueResult();
	    System.out.println(st);
	    st.setMarks(100);
	    
	    //Move the Object in Detached State

		s.evict(st);
	    
	    Object[] st2=(Object[])s.createQuery("Select name,marks from Students where id=9").uniqueResult();
	    System.out.println(st2[0]+"  :  "+st2[1]);
	    

	    
	    List<Students> slist=s.createQuery("from Students where marks> :b")
	    		.setParameter("b",m).list();
		
	    for(Students l:slist){
			l.setName("Rahul");
	    	System.out.println(l);
		}
		
		List<Integer> mids=new ArrayList<Integer>();
		mids.add(67);
		mids.add(40);
		mids.add(87);
		mids.add(69);
		
		
		List<Object[]> slist2=(List<Object[]>)s.createQuery("Select name,marks from Students where marks IN :mids")
				.setParameterList("mids",mids)
				.list();
		for(Object[] o:slist2){
			System.out.println(o[0]+"  :  "+o[1]);
		}
		
		
		
		Long l =(Long)s.createQuery("Select sum(marks) from Students where marks> :b")
				.setParameter("b",40).uniqueResult();
		System.out.println(l);
		
		
		tx.commit();
	}
}
