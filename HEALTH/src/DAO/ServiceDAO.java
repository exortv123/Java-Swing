/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.SERVICE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ServiceDAO {
    public static ArrayList<SERVICE> getServices() throws SQLException
    {
        ArrayList<SERVICE> list=new ArrayList<>();
        Connection cn=MyConnection.makeConnection();
        if(cn!=null)
        {
           String sql="select PROID,PRONAME,PRICE\n" +
                      "from [PROCEDURE]" ;
            PreparedStatement pst=cn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                int serviceID=rs.getInt("PROID");
                String name=rs.getString("PRONAME");
                int price= rs.getInt("PRICE");
                SERVICE s=new SERVICE(serviceID, name, price);
                list.add(s);
            }
            cn.close();
        }
        return list;
    }
}
