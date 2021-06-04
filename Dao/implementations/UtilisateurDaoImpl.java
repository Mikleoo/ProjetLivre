package Dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.DaoConfigurationException;
import Dao.DaoFactory;
import Dao.DaoUtilitaire;
import Dao.Interface.UtilisateurDao;
import Modele.Livre;

public class UtilisateurDaoImpl implements UtilisateurDao {

	private DaoFactory daoFactory;

	// Preparation des requetes sql
	private static final String SQL_SELECT_PAR_SUPPR = "SELECT livre.nom_livre, livre.date_de_fin, auteur.nom_auteur, editeur.nom_editeur, lieu.nom_lieu, personne.nom_personne FROM livre INNER JOIN auteur ON livre.id_auteur = auteur.id_auteur INNER JOIN editeur ON livre.id_editeur = editeur.id_editeur INNER JOIN lieu ON livre.id_lieu = lieu.id_lieu INNER JOIN personne ON livre.id_personne = personne.id_personne WHERE est_supprime = false";
	private static final String SQL_INSERT_LIVRE = "INSERT INTO livre (nom_livre, date_de_fin) VALUES (?, ?)";
	private static final String SQL_INSERT_AUTEUR = "INSERT INTO auteur (nom_auteur) VALUES (?)";
	private static final String SQL_INSERT_EDITEUR = "INSERT INTO editeur (nom_editeur) VALUES (?)";
	private static final String SQL_INSERT_LIEU = "INSERT INTO lieu (nom_lieu) VALUES (?)";
	private static final String SQL_INSERT_PERSONNE = "INSERT INTO personne (nom_personne) VALUES (?)";

	public UtilisateurDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	// Fonction creer qui rentre un utilisateur dans la bdd et renvoie true en cas de succes
	public boolean creer(Livre livre) throws DaoConfigurationException {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        // Recuperation d'une connexion depuis la Factory
	        connexion = daoFactory.getConnection();
	        // Preparation de la requete puis envoie
	        preparedStatement = DaoUtilitaire.initialisationRequetePreparee(connexion, SQL_INSERT_LIVRE, true, livre.getNomLivre(), livre.getDate());
	        preparedStatement.executeUpdate();
	        preparedStatement = DaoUtilitaire.initialisationRequetePreparee(connexion, SQL_INSERT_AUTEUR, true, livre.getAuteur());
	        preparedStatement.executeUpdate();
	        preparedStatement = DaoUtilitaire.initialisationRequetePreparee(connexion, SQL_INSERT_EDITEUR, true, livre.getEditeur());
	        preparedStatement.executeUpdate();
	        preparedStatement = DaoUtilitaire.initialisationRequetePreparee(connexion, SQL_INSERT_LIEU, true, livre.getLieu());
	        preparedStatement.executeUpdate();
	        preparedStatement = DaoUtilitaire.initialisationRequetePreparee(connexion, SQL_INSERT_PERSONNE, true, livre.getNomPreteur());
	        preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Requete SQL bien execute");
            return true;
	    } catch ( SQLException e ) {
	    	e.printStackTrace();
	    }
	    return false;
	}
	
	// Fonction trouver qui cherche un utilisateur via son nom et remplie notre class Utilisateur
	public List<Livre> trouver() throws DaoConfigurationException {
	    PreparedStatement preparedStatement = null;
	    ResultSet res = null;
	    List<Livre> livre = new ArrayList<Livre>();

	    try {
	        // Recuperation d'une connexion depuis la Factory
	    	Connection connexion = daoFactory.getConnection();
	    	// Preparation de la requete puis envoie
	        preparedStatement = DaoUtilitaire.initialisationRequetePreparee(connexion, SQL_SELECT_PAR_SUPPR, true);
	        res = preparedStatement.executeQuery();
	        // Set les infos dans notre class Utilisateur
	        while(res.next()){
	        	Livre u = new Livre();
	        	u.setNomLivre(res.getString("nom_livre"));
	        	u.setDate(res.getString("date_de_fin"));
	        	u.setAuteur(res.getString("nom_auteur"));
	        	u.setEditeur(res.getString("nom_editeur"));
	        	u.setLieu(res.getString("nom_lieu"));
	        	u.setNomPreteur(res.getString("nom_personne"));
	        	u.setEditeur(res.getString("nom_editeur"));
	        	livre.add(u);
	        	System.out.println(u.toString());
            }
	        res.close();
            preparedStatement.close();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
	    return livre;
	}
	
}