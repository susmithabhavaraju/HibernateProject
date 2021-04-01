package org.app.demo;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class MainProgramVehicle {

	public static void main(String[]args)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("JpaCode");
		EntityManager manager=emf.createEntityManager();
		manager.getTransaction().begin();
//To insert the records into the table
		Scanner scanner=new Scanner(System.in);
		for(int i=1;i<=2;i++)
		{
		Vehicle vh=new Vehicle();
		System.out.println("enter the vehNum");
		vh.setVehNum(scanner.next());
		System.out.println("enter the no of wheels");
		vh.setNoOfWheels(scanner.nextInt());
		System.out.println("enter the vehicle color");
		vh.setVehCol(scanner.next());
		manager.persist(vh);//(insert method)
		}
		//jpql query
		String jpql="update Vehicle set vehCol ='BLUE' where NoOfWheels<2";
		String jpql1="update Vehicle set vehCol='ORANGE' where NoOfWheels between 2 and 5";
		String jpql2="delete from Vehicle where vehNum like 'AP%' ";
//(runtime values using positional parameter)
		String jpql3="update Vehicle set vehCol=?1 where NoOfWheels between ?2 and ?5";
//(runtime values using named parameters)
		String jpql4="update Vehicle set vehCol=:vk where NoOfWheels between :ns and :mn";
//inform hibernate about jpql query
		Query query =manager.createQuery(jpql);
		Query q =manager.createQuery(jpql1);
		Query q2=manager.createQuery(jpql2);
		Query q3 = manager.createQuery(jpql3);
		Query q4=manager.createQuery(jpql4); 
//placeholders reference variable names
		Scanner sc =new Scanner(System.in);
		System.out.println("enter the color");
		String col=sc.next();
		System.out.println("enter the min number of wheels");
		int min=sc.nextInt();
		System.out.println("enter the max number of wheels");
		int max=sc.nextInt();
//(setter methods for positional parameters)
			q3.setParameter(1,col);
			q3.setParameter(2,min);
			q3.setParameter(3,max);
//setter methods for named parameters)
	       	q4.setParameter("vk",col);
			q4.setParameter("ns",min);
			q4.setParameter("mn",max);
//executing query
		query.executeUpdate();
		q.executeUpdate();
		q2.executeUpdate();
		q3.executeUpdate();
		q4.executeUpdate();
		
		manager.getTransaction().commit();
		manager.close();
	
	
		
	}
}
