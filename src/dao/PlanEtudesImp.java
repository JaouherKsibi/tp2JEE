package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Compte;
import model.GroupeModule;
import model.Matiere;

public class PlanEtudesImp implements IPlanEtudes {
	public PlanEtudesImp() {
		try {
			Class.forName("com.mysql.jdbc.Driver");//chargement du driver
			String url ="jdbc:mysql://localhost:3308/tp2";
			
			cnx=DriverManager.getConnection(url,"root","");
		}catch(ClassNotFoundException e) {
			System.out.println("erreur de chargement du driver ");
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println ("erreur autre que le chargement du driver");
			e.printStackTrace();
		}
	}

	private Connection cnx;

	@Override
	public List<GroupeModule> getAllGroupesModules() {
		List<GroupeModule> lo=new ArrayList<GroupeModule>();
		PreparedStatement prst;
		try {
			
			prst = cnx.prepareStatement("select * from GroupeMod ");
			
			
			
			ResultSet rs =prst.executeQuery();
			while (rs.next())
			{
				lo.add(new GroupeModule( rs.getInt(1),rs.getString(2),rs.getInt(3)));
			}
			return lo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Matiere> getAllMatieres() {
		List<Matiere> lo=new ArrayList<Matiere>();
		PreparedStatement prst;
		GroupeModule gp;
		try {
			
			prst = cnx.prepareStatement("select * from Matiere ");
			
			
			
			ResultSet rs =prst.executeQuery();
			while (rs.next())
			{
				
				lo.add(new Matiere( rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getFloat(5),getGroupeModuleById(rs.getInt(6))));
			}
			return lo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Matiere> getAlMatieresByGM(int id) {
		List<Matiere> lo=new ArrayList<Matiere>();
		PreparedStatement prst;
		try {
			
			prst = cnx.prepareStatement("select * from Matiere where idgm=? ");
			prst.setInt(1, id);
			
			
			ResultSet rs =prst.executeQuery();
			while (rs.next())
			{
				lo.add(new Matiere( rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getFloat(5),getGroupeModuleById(id)));
			}
			return lo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public GroupeModule getGroupeModuleById(int id) {
		GroupeModule lo=new GroupeModule();
		PreparedStatement prst;
		try {
			
			prst = cnx.prepareStatement("select * from GroupeMod where idgm=? ");
			
			prst.setInt(1, id);
			
			ResultSet rs =prst.executeQuery();
			while (rs.next())
			{
				lo=new GroupeModule( rs.getInt(1),rs.getString(2),rs.getInt(3));
			}
			return lo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addMatiere(Matiere m) {
		String req="insert into Matiere(idmat,nom,nbhc,nbhtp,coef,idgm)values(?,?,?,?,?,?)";
		try {
			PreparedStatement prst=cnx.prepareStatement(req);
			prst.setInt(1,m.getId());
			prst.setString(2,m.getNom());
			prst.setInt(3,m.getNbr_heures());
			prst.setInt(4,m.getNb_h_tp());
			prst.setFloat(5,m.getCoef());
			prst.setInt(6,m.getGp().getId());
			prst.executeUpdate();
		} 
		catch (SQLException e) {
			
			System.out.println("erreur d'insertion du groupe a la base ");
			e.printStackTrace();
		}
		catch(Exception e1)
		{
			System.out.println("autre erreur a l'insertion du groupe a la base ");
		}
		
		
	}

	public Compte getCompteByLogin(String login, String mdp) {
		PreparedStatement prst;
		try {
			Compte c=null;
			prst = cnx.prepareStatement("select * from user where (email=? and password=?)");
			prst.setString(1, login);
			prst.setString(2, mdp);
			
			ResultSet rs =prst.executeQuery();
			while (rs.next())
			{
				c=new Compte( rs.getString(2),rs.getString(3),rs.getString(4));
			}
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<Matiere> getAllMatiereByNom(String nom) {
		List<Matiere> lo=new ArrayList<Matiere>();
		PreparedStatement prst;
		try {
			
			prst = cnx.prepareStatement("select * from Matiere where nom like ? ");
			prst.setString(1, "%"+nom+"%");
			
			
			ResultSet rs =prst.executeQuery();
			while (rs.next())
			{
				lo.add(new Matiere( rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getFloat(5),getGroupeModuleById(rs.getInt(6))));
			}
			return lo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int id_matiere_creation() {
		PreparedStatement prst;int c=0;
		try {
			prst = cnx.prepareStatement("select max(idmat) from matiere ");
			
			ResultSet rs =prst.executeQuery();
			while (rs.next())
			{
				c= rs.getInt(1);
			}
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

}
