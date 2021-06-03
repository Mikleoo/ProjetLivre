package Dao.Interface;

import Dao.DaoConfigurationException;
import Modele.Livre;

public interface UtilisateurDao {
	
	// On dit que ces fonctions existe dans l'implémentation
	boolean creer( Livre livre ) throws DaoConfigurationException ;
	Livre trouver() throws DaoConfigurationException;

}
