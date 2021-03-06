/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.CustomerDAO;
import DAO.InvoiceDetailDAO;
import DAO.PetDAO;
import DAO.ServiceDAO;
import DTO.Customer;
import DTO.Pet;
import DTO.SERVICE;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class mainFrame extends javax.swing.JFrame {

    /**
     * Creates new form mainFrame
     */
    Locale lo;

    public mainFrame() {
        initComponents();
        //xoa cac hang co trong bang
        DefaultTableModel model = (DefaultTableModel) tblService.getModel();
        model.setRowCount(0);
        loadCustomer();
        loadServices();
        //lay ngay hien hanh
        Date date = new Date();
        txtDate.setText(date.toString());

        loadLang();
    }

    public void loadLang() {
        if (rdoLangViet.isSelected()) {
            lo = new Locale("vn", "VN");
        } else {
            lo = new Locale("en", "US");
        }
        ResourceBundle rb = ResourceBundle.getBundle("Language.lang", lo);
        jLabel1.setText(rb.getString("key1"));
        jLabel2.setText(rb.getString("key2"));
        jLabel3.setText(rb.getString("key3"));
        jLabel4.setText(rb.getString("key4"));
        jLabel5.setText(rb.getString("key5"));
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.ENGLISH);
        String dh = df.format(new Date());
        txtDate.setText(dh);
        NumberFormat mf = NumberFormat.getCurrencyInstance(lo);
        String money = mf.format(1000);
        lblMoney.setText(money);

    }

    void loadServices() {
        try {
            ArrayList<SERVICE> list = ServiceDAO.getServices();
            if (list != null && !list.isEmpty()) {
                cbxSerives.removeAllItems();
                for (SERVICE service : list) {
                    cbxSerives.addItem(service.getId() + "-" + service.getName());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void loadCustomer() {
        try {
            ArrayList<Customer> list = CustomerDAO.getCustomers();
            if (list != null && !list.isEmpty()) {
                cbxCustomers.removeAllItems();
                for (Customer customer : list) {
                    cbxCustomers.addItem(customer.getId() + "-" + customer.getName());

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtInvoiceID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxCustomers = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxPets = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbxSerives = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblService = new javax.swing.JTable();
        btnCreate = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        rdoLangViet = new javax.swing.JRadioButton();
        rdoLangEng = new javax.swing.JRadioButton();
        lblMoney = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Invoice ID");

        jLabel2.setText("Date");

        jLabel3.setText("Customer");

        cbxCustomers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCustomersActionPerformed(evt);
            }
        });

        jLabel4.setText("Pet");

        cbxPets.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Services");

        cbxSerives.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Choose service");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblService.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "PET ID", "SERVICE ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblService.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblService);

        btnCreate.setText("Create Invoice");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnView.setText("View");

        buttonGroup2.add(rdoLangViet);
        rdoLangViet.setText("Vietnamese");
        rdoLangViet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoLangVietActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoLangEng);
        rdoLangEng.setSelected(true);
        rdoLangEng.setText("English");
        rdoLangEng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoLangEngActionPerformed(evt);
            }
        });

        lblMoney.setText("Money");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(87, 87, 87)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(96, 96, 96)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel3))))
                            .addGap(132, 132, 132)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtInvoiceID, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(140, 140, 140)
                                            .addComponent(jLabel2))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cbxCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4)))
                                    .addGap(100, 100, 100)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDate)
                                        .addComponent(cbxPets, 0, 205, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cbxSerives, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(335, 335, 335)
                                    .addComponent(lblMoney)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(btnCreate)
                        .addGap(83, 83, 83)
                        .addComponent(btnView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoLangViet)
                        .addGap(73, 73, 73)
                        .addComponent(rdoLangEng)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtInvoiceID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbxPets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbxSerives, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMoney)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnView)
                    .addComponent(rdoLangViet)
                    .addComponent(rdoLangEng))
                .addContainerGap(227, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCustomersActionPerformed
        // TODO add your handling code here:
        try {
            if (cbxCustomers.getModel().getSize() == 0) {
                return;
            }
            String tmp = "" + cbxCustomers.getSelectedItem(); //1-abc
            int ownerId = Integer.parseInt(tmp.split("-")[0]);
            ArrayList<Pet> list = PetDAO.getPets(ownerId);
            if (list != null && !list.isEmpty()) {
                cbxPets.removeAllItems();
                for (Pet pet : list) {
                    cbxPets.addItem(pet.getId() + "-" + pet.getName());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }


    }//GEN-LAST:event_cbxCustomersActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //lay petID, serviceID tu 2 comboBox
        if (cbxPets.getModel().getSize() == 0 || cbxSerives.getModel().getSize() == 0) {
            return;
        }

        String getPet = "" + cbxPets.getSelectedItem();
        String getService = "" + cbxSerives.getSelectedItem();
        int petId = Integer.parseInt(getPet.split("-")[0]);
        int serviceId = Integer.parseInt(getService.split("-")[0]);
        DefaultTableModel model = (DefaultTableModel) tblService.getModel();
        Vector row = new Vector();
        row.add(petId);
        row.add(serviceId);
        model.addRow(row);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        //b1: chen invoicedId, Date, customerId vao bang Invoice
        try {
            int invoiceId = Integer.parseInt(txtInvoiceID.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String date = txtDate.getText();
            date = sdf.format(new Date());
            String tmp = "" + cbxCustomers.getSelectedItem();
            int ownerId = Integer.parseInt(tmp.split("-")[0]);
            if (CustomerDAO.insertInvoice(invoiceId, date, ownerId) > 0) {
                //b2: chen cac dong trong tbl vao bang invoiceDetail
                for (int i = 0; i < tblService.getRowCount(); i++) {
                    int petId = Integer.parseInt("" + tblService.getValueAt(i, 0));
                    int proId = Integer.parseInt("" + tblService.getValueAt(i, 1));
                    InvoiceDetailDAO.inserInvoiceDetail(invoiceId, proId, petId);
                }
                JOptionPane.showMessageDialog(this, "Invoice is saved!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btnCreateActionPerformed

    private void rdoLangVietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoLangVietActionPerformed
        // TODO add your handling code here:
        rdoLangViet.setSelected(true);
        loadLang();
    }//GEN-LAST:event_rdoLangVietActionPerformed

    private void rdoLangEngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoLangEngActionPerformed
        // TODO add your handling code here:
        rdoLangEng.setSelected(true);
        loadLang();
    }//GEN-LAST:event_rdoLangEngActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnView;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbxCustomers;
    private javax.swing.JComboBox<String> cbxPets;
    private javax.swing.JComboBox<String> cbxSerives;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMoney;
    private javax.swing.JRadioButton rdoLangEng;
    private javax.swing.JRadioButton rdoLangViet;
    private javax.swing.JTable tblService;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtInvoiceID;
    // End of variables declaration//GEN-END:variables
}
