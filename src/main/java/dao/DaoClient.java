package dao;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entities.Client;

public class DaoClient {
	//addClient permet d'ajouter un nouveau client à la base
		public Client addClient(Client temp){
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction(); // débuter la transaction
				// on crée une instance de la classe de données
				//Client c1 = new Client(600, "Alain", "Claude");

				session.save(temp);
				tx.commit();// ” commit” de la transaction
			} 
			catch (Exception e) {
				//System.out.println("Un problème dans la base");
				if (tx != null) {
					tx.rollback();// on effectue un roll back en cas d’exception
	                    // afin de garder la cohérence des données
					session.close();
				}
				
			}
			session.close();// fermeture de la session hibernate
			return temp;
		}



		//getClient permet dechercher un client avec idC = id
		public Client getClient(int id)
		{
			Client c=null;
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction(); // débuter la transaction
				
				 c= (Client)session.load(Client.class,id);
				tx.commit();
			} 
			catch (Exception e) {
				//System.out.println("Un problème dans la base");
				if (tx != null) {
					tx.rollback();// on effectue un roll back en cas d’exception
	                    // afin de garder la cohérence des données
					session.close();
				}
			
			}
			session.close();// fermeture de la session hibernate
			return c;
		}
		
		//deleteClient permet de supprimer un client avec id
				public Client deleteClient(int id)
				{
					Client c=null;
					Session session = HibernateUtil.getSessionFactory().openSession();
					Transaction tx = null;
					try {
						tx = session.beginTransaction(); // débuter la transaction
						
						 c= (Client)session.load(Client.class,id);
						 session.delete(c) ; //suppression de l’objet « c »
						tx.commit();
					} 
					catch (Exception e) {
						//System.out.println("Un problème dans la base");
						if (tx != null) {
							tx.rollback();// on effectue un roll back en cas d’exception
			                    // afin de garder la cohérence des données
							session.close();
						}
						
					}
					session.close();// fermeture de la session hibernate
					return c;	
				}
				
				//update
				
				//updateClient permet de mettre à jour un client avec id
				public Client updateClient(int id, String nom)
				{
					Client c=null;
					Session session = HibernateUtil.getSessionFactory().openSession();
					Transaction tx = null;
					try {
						tx = session.beginTransaction(); // débuter la transaction
						
						 c= (Client)session.load(Client.class,id);
						 c.setNom(nom);
						 session.save(c) ; //suppression de l’objet « c »
						tx.commit();
					} 
					catch (Exception e) {
						//System.out.println("Un problème dans la base");
						if (tx != null) {
							tx.rollback();// on effectue un roll back en cas d’exception
			                    // afin de garder la cohérence des données
							session.close();
						}
						
					}
					session.close();// fermeture de la session hibernate
					return c;
				}
				
				public List<Client> getAllClient()
				{
					List<Client> ls=null;
					Session session = HibernateUtil.getSessionFactory().openSession();
					Transaction tx = null;
					try {
						tx = session.beginTransaction(); // débuter la transaction
						
						//Méthode 1
						 //ls = (List<Client>)session.createCriteria(Client.class).list();
						// Fin méthode 1
						
						//Méthode 2: HQL
						String hql = "from Client";
						Query query = session.createQuery(hql);
						ls = query.list();
						// Fin méthode 2
						 
						//System.out.println(ls);
						tx.commit();
					} 
					catch (Exception e) {
						//System.out.println("Un problème dans la base");
						if (tx != null) {
							tx.rollback();// on effectue un roll back en cas d’exception
			                    // afin de garder la cohérence des données
							session.close();
						}
						
					}
					session.close();// fermeture de la session hibernate
					return ls;
				}
				
				//get number of client
				public Long getCountClient() {
					Session session = HibernateUtil.getSessionFactory().openSession();
					Transaction tx = null;
					Long numberOfClient = null;
					try {
						tx = session.beginTransaction();
						String hql = "select count(*) from Client";
						Query query = session.createQuery(hql);
						numberOfClient  = (Long) query.uniqueResult();
						
						tx.commit();
					} catch (Exception e) {
						if (tx != null) {
							tx.rollback();
							session.close();
						}
						
					}
					session.close();
					
					return numberOfClient;
				}
}
