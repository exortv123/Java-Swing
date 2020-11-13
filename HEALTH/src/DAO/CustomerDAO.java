/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class CustomerDAO {

    public static ArrayList<Customer> getCustomers() throws SQLException {
        ArrayList<Customer> list = new ArrayList<>();
        Connection cn = MyConnection.makeConnection();
        if (cn != null) {
            String sql = "select OWNERID,OWNERNAME,ADDRESS\n"
                    + "from [OWNER]";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("OWNERID");
                String name = rs.getString("OWNERNAME");
                String address = rs.getString("ADDRESS");
                Customer c = new Customer(id, name, address);
                list.add(c);
            }
            cn.close();
        }
        return list;
    }

    public static int insertInvoice(int invoiceId, String date, int ownerId) throws SQLException {
        Connection cn = (Connection) MyConnection.makeConnection();
        int result = 0;
        if (cn != null) {
            String sql = "insert INVOICE values(?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, invoiceId);
            pst.setString(2, date);
            pst.setInt(3, ownerId);
            result = pst.executeUpdate();
            cn.close();
        }
        return result;
    }
}
