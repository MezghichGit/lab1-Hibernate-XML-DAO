package main;

import java.util.List;
import java.util.Scanner;

import dao.DaoClient;
import entities.Client;

public class Main {

	public static void main(String[] args) {
		
		
	//STEP 1 : On va lire les données depuis le clavier
		
		Scanner lect = new Scanner(System.in);
		
		//Saisi de l'id du client
		//System.out.println("Donner un ID");
		//int idC = lect.nextInt();
		
		//Saisi du nom du client
		
		//System.out.println("Donner le nom");
		//String nom = lect.next();
		
		//Saisi du prenom du client
	    //System.out.println("Donner le prenom");
		//String prenom = lect.next();
		
		//STEP 2 : On va créer un Objet Client avec ces données saisi
		//Client c = new Client(idC,nom,prenom);
		//Client c = new Client(nom,prenom);
		//STEP 3 : Appeler l'objet DAO
		
		DaoClient daoclient = new DaoClient();
		
		
		//STEP 4 : On persist
		//Client c1 = daoclient.addClient(c);
		//System.out.println(c1);
		//System.out.println("Ajout avec succès");
		
		/*********** Méthode getClient ***********/
		
		//Client c = daoclient.getClient(2);
		//System.out.println(c);
		
		/*********** Méthode deleteClient ***********/
		
		//Client c = daoclient.deleteClient(2);
		//System.out.println(c);
		
		/*********** Méthode updateClient ***********/
		 /*Client c = daoclient.updateClient(1,"Amine Mezghich");
		 c = daoclient.getClient(1);
		 System.out.println(c);*/
		
		//List<Client> lc = daoclient.getAllClient();
		//System.out.println(lc);
		System.out.println(daoclient.getCountClient());

	}

}
