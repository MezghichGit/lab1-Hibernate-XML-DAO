package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entities.Client;

public class DaoClient {
	//addClient permet d'ajouter un nouveau client � la base
		public Client addClient(Client temp){
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction(); // d�buter la transaction
				// on cr�e une instance de la classe de donn�es
				//Client c1 = new Client(600, "Alain", "Claude");

				session.save(temp);
				tx.commit();// � commit� de la transaction
			} 
			catch (Exception e) {
				//System.out.println("Un probl�me dans la base");
				if (tx != null) {
					tx.rollback();// on effectue un roll back en cas d�exception
	                    // afin de garder la coh�rence des donn�es
					session.close();
				}
				
			}
			session.close();// fermeture de la session hibernate
			return temp;
		}
}
