package nico.dao.interf;

import nico.dao.DaoException;
import nico.model.Livre;

public interface DaoInterface {
    public Livre select(int isDeleted) throws DaoException;
    public void create(Object object) throws DaoException;
    public void update(Object object) throws DaoException;
    public void delete(Object object) throws DaoException;
}
