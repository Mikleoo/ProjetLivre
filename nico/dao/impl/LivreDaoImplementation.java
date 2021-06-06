package nico.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nico.dao.DaoException;
import nico.dao.DaoFactory;
import nico.dao.interf.DaoInterface;
import nico.model.Livre;

public class LivreDaoImplementation implements DaoInterface {
    
    private DaoFactory daoFactory;

    private static final String SQL_SELECT_BY_IS_NOT_DELETED = "SELECT * FROM livre WHERE est_supprime = ?";

    /**
     * Constructor
     * @param daoFactory
     */
    public LivreDaoImplementation(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    /**
     * Initialise prepared statement based on connexion passed as argument,
     * with SQL query, and given object
     * @param connexion
     * @param sql
     * @param returnGeneratedKeys
     * @param objects
     * @return
     * @throws SQLException
     */
    public static PreparedStatement preparedStatementInit(Connection connexion, String sql, boolean returnGeneratedKeys, Object... objects) throws SQLException {

        PreparedStatement prepStmt = connexion.prepareStatement(sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);

        for(int i = 0; i < objects.length; i++) {
            prepStmt.setObject(i + 1, objects[i]);
        }

        return prepStmt;
    }

    /**
     * Mapping resultSet of SQL query to Livre object
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private static Livre map(ResultSet resultSet) throws SQLException {
        Livre livre = new Livre();
        livre.setIdIsbn(resultSet.getInt("id_isbn"));
        livre.setNomLivre(resultSet.getString("nom_livre"));
        livre.setDateDeFin(resultSet.getDate("date_de_fin"));
        livre.setEstSupprime(resultSet.getInt("est_supprime"));
        livre.setIdAuteur(resultSet.getInt("id_auteur"));
        livre.setIdEditeur(resultSet.getInt("id_editeur"));
        livre.setIdPersonne(resultSet.getInt("id_personne"));
        livre.setIdLieu(resultSet.getInt("id_lieu"));

        return livre;
    }

    // Silent deconnection of resultset
    public static void silentDeconnection( ResultSet resultSet ) {
        if ( resultSet != null ) {
            try {
                resultSet.close();
            } catch ( SQLException e ) {
                System.out.println( "failed to close the ResultSet : " + e.getMessage() );
            }
        }
    }

    // Silent close of the Statement
    public static void silentDeconnection( Statement statement ) {
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException e ) {
                System.out.println( "failed to close the Statement : " + e.getMessage() );
            }
        }
    }

    // Silent close of Deconnection
    public static void silentDeconnection( Connection connexion ) {
        if ( connexion != null ) {
            try {
                connexion.close();
            } catch ( SQLException e ) {
                System.out.println( "failed to close Connection : " + e.getMessage() );
            }
        }
    }

    // Silent close of Statement and Connexion
    public static void silentDeconnections( Statement statement, Connection connexion ) {
        silentDeconnection( statement );
        silentDeconnection( connexion );
    }

    // Silent close of Statement, Connexion and ResultSet
    public static void silentDeconnections( ResultSet resultSet, Statement statement, Connection connexion ) {
        silentDeconnection( resultSet );
        silentDeconnection( statement );
        silentDeconnection( connexion );
    }
    
    @Override
    public Livre select(int isDeleted) throws DaoException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Livre livre = null;

        try {
            // retrieve connection from DaoFactory
            connection = daoFactory.getConnection();
            preparedStatement = LivreDaoImplementation.preparedStatementInit(connection, SQL_SELECT_BY_IS_NOT_DELETED, false, isDeleted);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                livre = map(resultSet);
            } 

        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            silentDeconnections(resultSet, preparedStatement, connection);
        }

        return livre;
    }

    @Override
    public void create(Object object) throws IllegalArgumentException, DaoException {}

    @Override
    public void update(Object object) throws IllegalArgumentException, DaoException {}

    @Override
    public void delete(Object object) throws IllegalArgumentException, DaoException {}
}