package entities;

public class Client {
	private int clientId;
	private String nom;
	private String pr�nom;

	public Client() {
	} // Constructeur par d�faut

	public Client(int clientId, String nom, String pr�nom) {
		this.clientId = clientId;
		this.nom = nom;
		this.pr�nom = pr�nom;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPr�nom() {
		return pr�nom;
	}

	public void setPr�nom(String prenom) {
		this.pr�nom = prenom;
	}

	@Override
	public String toString() {
		return "Je suis le client : " + clientId + " nomm� : " + nom + " " + pr�nom;
	}
}
