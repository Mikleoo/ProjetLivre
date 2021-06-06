package nico.dao.test;

import nico.dao.impl.*;
import nico.dao.*;
import nico.model.*;

public class Test {

    public static void main(String args[]) {
		System.out.println("test");
		LivreDaoImplementation ldi = new LivreDaoImplementation(DaoFactory.getInstance());
        System.out.println("test2");
        Livre l = ldi.select(0);
    	System.out.println(l);
    }
}