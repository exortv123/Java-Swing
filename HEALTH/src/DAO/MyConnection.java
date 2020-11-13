/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author user
 */
public class MyConnection {
   public static  Connection makeConnection()
   {
       Connection cn=null;
       try {
           //b1: nap driver
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           String url="jdbc:sqlserver://localhost:1433;databaseName=HEALTH_HISTORY_REPORT";
           cn=DriverManager.getConnection(url,"sa","TGUAH123duy@" );

       } catch (Exception e) {
           e.printStackTrace();
       }
       
       return cn;
   }
}
