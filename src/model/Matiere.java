package model;

public class Matiere {
	private int id;
	private String nom;
	private int nbr_heures;
	private int nb_h_tp;
	private float coef;
	private GroupeModule gp;
	public Matiere() {
	}
	public Matiere(int id, String nom, int nbr_heures, int nb_h_tp, float coef, GroupeModule gp) {
		super();
		this.id = id;
		this.nom = nom;
		this.nbr_heures = nbr_heures;
		this.nb_h_tp = nb_h_tp;
		this.coef = coef;
		this.gp = gp;
	}
	@Override
	public String toString() {
		return "Matiere [id=" + id + ", nom=" + nom + ", nbr_heures=" + nbr_heures + ", nb_h_tp=" + nb_h_tp + ", coef="
				+ coef + ", gp=" + gp + "]";
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
	public int getNbr_heures() {
		return nbr_heures;
	}
	public void setNbr_heures(int nbr_heures) {
		this.nbr_heures = nbr_heures;
	}
	public int getNb_h_tp() {
		return nb_h_tp;
	}
	public void setNb_h_tp(int nb_h_tp) {
		this.nb_h_tp = nb_h_tp;
	}
	public float getCoef() {
		return coef;
	}
	public void setCoef(float coef) {
		this.coef = coef;
	}
	public GroupeModule getGp() {
		return gp;
	}
	public void setGp(GroupeModule gp) {
		this.gp = gp;
	}
	
	

}
