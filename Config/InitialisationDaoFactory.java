package Config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import Dao.DaoFactory;

public class InitialisationDaoFactory implements ServletContextListener {

	public static final String ATT_DAO_FACTORY = "daofactory";

	public void contextInitialized(ServletContextEvent event) {
		
		// Instanciation de notre DAOFactory
		DaoFactory daoFactory = DaoFactory.getInstance();
	}
}
