package Dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import Dao.implementations.UtilisateurDaoImpl;
import Dao.Interface.UtilisateurDao;

public class DaoFactory {
	
	// On configure toutes nos constantes pour le fichier de configuration
	private static final String FICHIER_PROPERTIES = "/Config/config.txt";
	private static final String PROPERTY_URL = "url";
	private static final String PROPERTY_DRIVER = "driver";
	private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
	private static final String PROPERTY_MOT_DE_PASSE = "motdepasse";
	
	private String url;
	private String nomUtilisateur;
	private String motDePasse;
	
	private static Connection con = null;
	
	DaoFactory( String url, String username, String password ) {
        this.url = url;
        this.nomUtilisateur = username;
        this.motDePasse = password;
    }
	
	// Le getInstance qui va gérer toute la connection à la bdd
	public static DaoFactory getInstance() {
		System.out.println("Bien rentre dans le DaoFactory");
		Properties properties = new Properties();
		String url;
		String driver;
		String nomUtilisateur;
		String motDePasse;

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream fichierProperties = classLoader.getResourceAsStream(FICHIER_PROPERTIES);

		if(fichierProperties == null) {
			throw new DaoConfigurationException("Le fichier properties " + FICHIER_PROPERTIES + " est introuvable");
		}

		try {
			properties.load(fichierProperties);
			url = properties.getProperty(PROPERTY_URL);
			System.out.println("URL : " + url + "\n");
			driver = properties.getProperty(PROPERTY_DRIVER);
			System.out.println("DRIVER : " + driver + "\n");
			nomUtilisateur = properties.getProperty(PROPERTY_NOM_UTILISATEUR);
			System.out.println("nomUtilisateur : " + nomUtilisateur + "\n");
			motDePasse = properties.getProperty(PROPERTY_MOT_DE_PASSE);
			System.out.println("motDePasse : " + motDePasse + "\n");
			System.out.println("La lecture du fichier : Good \n");
		} catch (IOException e) {
			throw new DaoConfigurationException("Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e);
		}
		
		try {
			Class.forName(driver);
			System.out.println("Le driver à été trouvé \n");
		} catch (ClassNotFoundException e) {
			throw new DaoConfigurationException("Le driver est introuvable dans le classpath ", e);
		}
		
		DaoFactory instance = new DaoFactory(url, nomUtilisateur, motDePasse);
		return instance;
	}
	
	//Methode chargee de fournir une connexion a la base de donnees
	public Connection getConnection() throws SQLException {
		return con;
	}

	//Methodes de recuperation de l'implementation des differents DAO (un seulpour le moment)
	public UtilisateurDao getUtilisateurDao() {
			return new UtilisateurDaoImpl(getInstance());
	}
	
	

}
