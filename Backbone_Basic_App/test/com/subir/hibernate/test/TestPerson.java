package com.subir.hibernate.test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.subir.hibernate.example.MonthlyExpense;
import com.subir.hibernate.example.Person;

public class TestPerson {
	private SessionFactory sessionFactory = null;
	public static void main(String[] args){
		
		TestPerson test = new TestPerson();
		test.init();
		//test.createPerson();
		test.createPersonWithMonth();
	}

	private void createPersonWithMonth() {
		Session session = sessionFactory.getCurrentSession();
		Person p = new Person();
		p.setName("PersonC");
		
		Calendar c=Calendar.getInstance();
		c.set(2014,02,1);
		Date dob=c.getTime();
		p.setDob(dob);
		p.setAddress("East");
		p.setCity("Mumbai");
		p.setCountry("India");
		
		MonthlyExpense exp1 = new MonthlyExpense();
		exp1.setAmount(1000);
		exp1.setMonth("Nov-2014");
		exp1.setCategory("Grocery");
		
		MonthlyExpense exp2 = new MonthlyExpense();
		exp2.setAmount(1000);
		exp2.setMonth("Oct-2014");
		exp2.setCategory("electricity bill");
		Set<MonthlyExpense> expenses = new HashSet<MonthlyExpense>();
		expenses.add(exp1);
		expenses.add(exp2);
		
		p.setMonthlyExpenses(expenses);
		
		Transaction t = session.beginTransaction();
		session.save(p);
		t.commit();
		
		session = sessionFactory.getCurrentSession();
		Transaction t1 = session.beginTransaction();
		Person a=(Person)session.get(Person.class,101);
		System.out.println(a.getPid()+" ::"+a.getName()+" dob :"+a.getDob().toString());
		t1.commit();
	}

	public void init(){
		 sessionFactory= new Configuration().configure().buildSessionFactory(
				    new StandardServiceRegistryBuilder().build() );
	}
	public void createPerson(){
		Session session = sessionFactory.getCurrentSession();
		Person p = new Person();
		p.setName("PersonB");
		
		Calendar c=Calendar.getInstance();
		c.set(2014,02,13);
		Date dob=c.getTime();
		p.setDob(dob);
		p.setAddress("East");
		p.setCity("Mumbai");
		p.setCountry("India");
		
		Transaction t = session.beginTransaction();
		session.save(p);
		
		Person a=(Person)session.get(Person.class,101);
		System.out.println(a.getPid()+" ::"+a.getName());
		t.commit();
		
		
	}
}
