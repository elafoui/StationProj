/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationapp;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.sql.executor.OResultSet;

/**
 *
 * @author Moaad
 */
public class Personne {
    public String[] histo_depart(String nom){
        String[] v1=new String[2];
        int i=0;
        OrientDB orient = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
    	ODatabaseSession db = orient.open("demo", "admin", "admin");
    	String query = "SELECT from Histo where prenom='"+nom+"'";
        OResultSet rs = db.query(query, "depart");
	    while (rs.hasNext()) {
		      v1[i]= rs.next().getProperty("depart");
                      i++;
    }     System.out.println(v1[0]);
            return v1;
    
}
 public String[] histo_arrivee(String nom){
        String[] v1=new String[2];
        int i=0;
        OrientDB orient = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
    	ODatabaseSession db = orient.open("demo", "admin", "admin");
    	String query = "SELECT from Histo where prenom='"+nom+"'";
        OResultSet rs = db.query(query, "depart");
	    while (rs.hasNext()) {
		      v1[i]= rs.next().getProperty("arrivee");
                      i++;
    }
            return v1;
    
}
}
