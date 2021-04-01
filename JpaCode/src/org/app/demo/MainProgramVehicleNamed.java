package org.app.demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MainProgramVehicleNamed {
	
public static void main(String[]args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("JpaCode");
	EntityManager manager=emf.createEntityManager();
	manager.getTransaction().begin();
	
//Inform Hibernate about named queries
	Query query =manager.createNamedQuery("UpdateVehicleColorBasedOnNumOfWheels");
//placeholders reference variable names
	Scanner sc =new Scanner(System.in);
	System.out.println("enter the color");
	String col=sc.next();
	System.out.println("enter the min number of wheels");
	int min=sc.nextInt();
	System.out.println("enter the max number of wheels");
	int max=sc.nextInt();
//setter methods for named parameters)
   	query.setParameter("vk",col);
	query.setParameter("ns",min);
	query.setParameter("mn",max);
//Execute of Named Query(DML)
	query.executeUpdate();
	System.out.println("...........................................................");
	
//Inform Hibernate about named queries
	Query q1=manager.createNamedQuery("DeleteRecordBasedOnVehnumber");
//Execute of named query(DML)
	q1.executeUpdate();
	System.out.println("deleted the records of vehNum of AP");
	System.out.println(".............................................................");
//Inform Hibernate about named queries
	Query q3=manager.createNamedQuery("SelectAll");
//Execute of named query(DQL)
	List result =q3.getResultList();
	System.out.println(result);
	
	manager.getTransaction().commit();
	manager.close();
}
}
