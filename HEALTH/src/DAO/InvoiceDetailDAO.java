/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class InvoiceDetailDAO {
    public static int inserInvoiceDetail(int invoiceId, int proId, int petId) throws SQLException {
        Connection cn = (Connection)MyConnection.makeConnection();
        int result = 0;
        if(cn!=null) {
        String sql = "insert INVOICEDETAIL values(?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, invoiceId);
            pst.setInt(2, proId);
            pst.setInt(3, petId);
            result = pst.executeUpdate();
            cn.close();
        }
        return result;
    }
}
