/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Customer;
import DTO.Pet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class PetDAO {
   public static ArrayList<Pet> getPets(int ownerID) throws SQLException
    {
        ArrayList<Pet> list=new ArrayList<>();
        Connection cn=MyConnection.makeConnection();
        if(cn!=null)
        {
           String sql="select PetID,PetName,age,OWNERID,TYPEID\n" +
                      "from PET\n" +
                      "where OWNERID=?" ;
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setInt(1, ownerID);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                int id=rs.getInt("PetID");
                String name=rs.getString("PetName");
                int age =rs.getInt("age");
                int ownerid=rs.getInt("OWNERID");
                int typeid=rs.getInt("TYPEID");
                Pet p=new Pet(id, name, age, ownerid, typeid);
                list.add(p);
                
            }
            cn.close();
        }
        return list;
    }
}
