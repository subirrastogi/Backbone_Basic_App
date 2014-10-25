package com.subir.rest.example;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.subir.hibernate.example.Person;

@Path("/persons")
public class PersonService {
	
	private SessionFactory sessionFactory;

	public PersonService(){
		 sessionFactory= new Configuration().configure().buildSessionFactory(
				    new StandardServiceRegistryBuilder().build() );
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAllPersons(){
		//List<Person> list=new ArrayList<Person>();
		Session session = sessionFactory.getCurrentSession();
		Transaction t= session.beginTransaction();
		Query query=session.createQuery("from Person");
		
		List<Person> list=query.list();
		t.commit();
		return list;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Person createPerson(Person p){
		Session session = sessionFactory.getCurrentSession();
		Transaction t= session.beginTransaction();
			Serializable y= session.save(p);
			Person p1=(Person)session.get(Person.class,p.getPid());
		t.commit();
		return p1;
		
	}
	
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Person updatePerson(@PathParam("id")String id, Person p){
		
		System.out.println("Id :"+id);
		System.out.println(p.getName());
		Session session = sessionFactory.getCurrentSession();
		Transaction t= session.beginTransaction();
			session.saveOrUpdate(p);
			Person p1=(Person)session.get(Person.class,p.getPid());
		t.commit();
		return p;
		
	}

}
