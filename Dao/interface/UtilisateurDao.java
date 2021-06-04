package Dao.Interface;

import java.util.List;

import Dao.DaoConfigurationException;
import Modele.Livre;

public interface UtilisateurDao {
	
	// On dit que ces fonctions existe dans l'implémentation
	boolean creer( Livre livre ) throws DaoConfigurationException ;
	List<Livre> trouver() throws DaoConfigurationException;

}
