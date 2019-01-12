/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationapp;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.id.ORID;
import com.orientechnologies.orient.core.sql.executor.OResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Moaad
 */
public class Station {
    public Station(){
        super();
    }
    public String[] allStations() {
    int i=0;
    OrientDB orient = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
    ODatabaseSession db = orient.open("demo", "admin", "admin"); 
    String query = "SELECT from Station";
    
    
    OResultSet rs = db.query(query, "Moaad");
    String[] stationsList=new String[10]; 
    while (rs.hasNext()) {
        stationsList[i]=rs.next().getProperty("lieu").toString();
    i++;
    }
    return stationsList;  
} 
    public int distance(String a, String b){
        ORID v1=null;
        ORID v2 = null;
    	OrientDB orient = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
    	ODatabaseSession db = orient.open("demo", "admin", "admin");
    	String query = "SELECT from Station where lieu='"+a+"'";
	    String query1 = "SELECT from Station where lieu='"+b+"'";
	    OResultSet rs = db.query(query, "Alice");
	    while (rs.hasNext()) {
		      v1= rs.next().getIdentity().get();
            System.out.println("les fhg"+v1.toString());}
	    OResultSet rs1 = db.query(query1, "Alice");
	    while (rs1.hasNext()) {
		     v2= rs1.next().getIdentity().get();
		     System.out.println("les fhg"+v2.toString());}     
	    String query3 = "SELECT Dijkstra ("+v1+","+v2+",'valeur', 'both') from Station";
	    OResultSet rs3 = db.query(query3, "Alice");
	 
		 String item = rs3.next().toJSON();
		 String item1=item.substring(46,item.length()-2);
         String[] words=item1.split(",");
         int s=0;
         int c;
         System.out.println(words);
         for(int j=0;j<words.length-1;j++){
             System.out.println(words[j]);
             c=0;
             try{
            String dis="SELECT from Distance where in="+words[j]+"and out="+words[j+1];
             OResultSet rsd = db.query(dis, "moaad");
            
             
                 c=rsd.next().getProperty("valeur");
                  System.out.println(c);
                 s=c+s;
             }catch (Exception e ){
                e.getMessage();
                String dis="SELECT from Distance where out="+words[j]+"and in="+words[j+1];
             OResultSet rsd = db.query(dis, "moaad");
            
             
                 c=rsd.next().getProperty("valeur");
                  System.out.println(c);
                 s=c+s;
             }
             
         
        
        
    }return s;}
    public String[] dijkstra(String a, String b){
        ORID v1=null;
        ORID v2 = null;
    	OrientDB orient = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
    	ODatabaseSession db = orient.open("demo", "admin", "admin");
    	String query = "SELECT from Station where lieu='"+a+"'";
	    String query1 = "SELECT from Station where lieu='"+b+"'";
	    OResultSet rs = db.query(query, "Alice");
	    while (rs.hasNext()) {
		      v1= rs.next().getIdentity().get();
            System.out.println("les fhg"+v1.toString());}
	    OResultSet rs1 = db.query(query1, "Alice");
	    while (rs1.hasNext()) {
		     v2= rs1.next().getIdentity().get();
		     System.out.println("les fhg"+v2.toString());}     
	    String query3 = "SELECT Dijkstra ("+v1+","+v2+",'valeur', 'both') from Station";
	    OResultSet rs3 = db.query(query3, "Alice");
	 
		 String item = rs3.next().toJSON();
		 String item1=item.substring(46,item.length()-2);
         String[] words=item1.split(",");
         String[] words1=new String[words.length];
         for(String w1:words){
             System.out.println(w1);
         }
         int i=0;
         for(String w:words){
                
        	 String query5="Select from Station where @rid="+w;  
        	 OResultSet rs5 = db.query(query5, "Alice");
        	 while (rs5.hasNext()) {
    		     words1[i]=rs5.next().getProperty("lieu").toString();
                     i++;
    		     }         	 
}
          return words1;
    }}