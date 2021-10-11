package dao;

import java.util.List;

import model.Compte;
import model.GroupeModule;
import model.Matiere;

public interface IPlanEtudes {
	public List<GroupeModule> getAllGroupesModules();
	List<Matiere> getAllMatieres();
	List<Matiere> getAlMatieresByGM(int id);
	GroupeModule getGroupeModuleById(int id);
	void addMatiere(Matiere m);
	Compte getCompteByLogin(String login,String mdp);
	List<Matiere> getAllMatiereByNom(String nom);

}
