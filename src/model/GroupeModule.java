package model;

public class GroupeModule {
	private int id;
	private String nom;
	private int niveau;
	public GroupeModule() {
		
	}
	public GroupeModule(int id, String nom, int niveau) {
		super();
		this.id = id;
		this.nom = nom;
		this.niveau = niveau;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	

}
