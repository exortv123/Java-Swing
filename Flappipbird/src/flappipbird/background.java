/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappipbird;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.java2d.pipe.DrawImage;

/**
 *
 * @author USER
 */
public class background extends javax.swing.JPanel {

    PairColumn[] pColumn;
    Column[] c;
    boolean conchoi = true;
    boolean conchoichim = true;
    boolean lock = true;
    int point = 0;
    Bird cu;
    RecordTable rec = new RecordTable();

    /**
     * st Creates new form background
     */
    public background() throws InterruptedException, IOException {
        init();
        initComponents();
        
        
        
        t.start();
        t2.start();
    }
//  public  void run(){
//      while(conchoi){
//          for (Column column : c) {
//              column.x = column.x-10;
//          }
//          for (Column column : c) {
//              if(column.x == 0){ // neu da sat panel
//                  column.x = 1000;
//              }
//          }
//          repaint();
//          try {
//              Thread.sleep(1000);
//          } catch (Exception e) {
//              e.printStackTrace();
//          }
//      }
//  }

    public ImageIcon loadImage() {

        return new ImageIcon("back.png");
    }

    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            while (conchoi) {
                for (PairColumn pc : pColumn) {
                    pc.moveCol(10);
                }
                point += calPoint();
                txtPoint.setText(point + "");
                if (isGaneOver()) {
                    conchoi = false;
                    setConChoiChim(false);
                    Integer result = 2;
                    JDialog jd = new ReportTable(null, false, point, rec, result, txtPoint);
                    jd.setVisible(true);
                    while (!txtPoint.getText().equalsIgnoreCase("end")) {
                        if (txtPoint.getText().equalsIgnoreCase("00"))System.exit(0);
                    }
                    System.out.println(txtPoint.getText());

                    if (txtPoint.getText().equalsIgnoreCase("end")) {
                        conchoi = true;
                        setConChoiChim(true);
                        point = 0;
                        cu.resetPos();
                        for (PairColumn pairColumn : pColumn) {
                            pairColumn.resetColPos();
                            pairColumn.reSizeCol();

                        }
                        repaint();
                    } else System.exit(0);

                }
                for (PairColumn pc : pColumn) {
                    if (pc.getCurrentPos() <= 0) {
                        pc.setPos(1750);
                        pc.reSizeCol();
                    }
                }
                repaint();
                //goi ham re paint nghia la goi ham paint component
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    });
    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {

                if (conchoichim) {
                    cu.y = cu.y + 1;
//                    repaint(90, 0, 100, 1000);
                    repaint();
                }
                try {
                    Thread.sleep(5);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    });

//    @Override
//    public void paintComponents(Graphics g) {
//        super.paintComponent(g);
//       
//    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
//         this.setSize(1500, 1000);

        ImageIcon img = loadImage();
        g.drawImage(img.getImage(), 0, 0, 1920, 1080, this);


        for (Column column : c) {
            column.drawColumn(g);
        }
        cu.drawChim(g);
    }

    private synchronized void setConChoiChim(boolean n) {
        while (!lock);
        lock = false;
        conchoichim = n;
        lock = true;

    }

    public int calPoint() {
        for (PairColumn pairColumn : pColumn) {
            if (pairColumn.getCurrentPos() <= 80 & !pairColumn.pointed) {
                pairColumn.pointed = true;
                return 1;
            }
        }
        return 0;
    }

    void init() {
        c = new Column[12];
        c[0] = new Column(Color.GREEN, 250, 0, 100, 250);
        c[1] = new Column(Color.GREEN, 600, 0, 90, 350);
        c[2] = new Column(Color.GREEN, 900, 0, 110, 250);
        c[5] = new Column(Color.GREEN, 1200, 0, 110, 800);
        c[7] = new Column(Color.GREEN, 1500, 0, 110, 800);
        c[9] = new Column(Color.GREEN, 1750, 0, 110, 800);
        c[3] = new Column(Color.GREEN, 250, 500, 100, 400);
        c[4] = new Column(Color.GREEN, 600, 450, 90, 700);
        c[6] = new Column(Color.GREEN, 1200, 450, 90, 700);
        c[8] = new Column(Color.GREEN, 1500, 450, 90, 500);
        c[10] = new Column(Color.GREEN, 900, 450, 90, 400);
        c[11] = new Column(Color.GREEN, 1750, 450, 90, 300);

        pColumn = new PairColumn[6];
        pColumn[0] = new PairColumn(c[0], c[3], 250);
        pColumn[1] = new PairColumn(c[1], c[4], 600);
        pColumn[2] = new PairColumn(c[2], c[6], 900);
        pColumn[3] = new PairColumn(c[5], c[8], 1200);
        pColumn[4] = new PairColumn(c[7], c[10], 1500);
        pColumn[5] = new PairColumn(c[9], c[11], 1750);
        cu = new Bird("12.png", 100, 450, 70, 50);

    }

    public boolean isGaneOver() {
        for (Column column : c) {
            if (column.intersects(cu)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPoint = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        txtPoint.setEditable(false);
        txtPoint.setFont(new java.awt.Font("Thanhoa", 1, 18)); // NOI18N
        txtPoint.setForeground(new java.awt.Color(204, 0, 0));
        txtPoint.setText("point");
        txtPoint.setDisabledTextColor(new java.awt.Color(204, 0, 0));
        txtPoint.setEnabled(false);
        txtPoint.setSelectedTextColor(new java.awt.Color(255, 0, 0));
        txtPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPointActionPerformed(evt);
            }
        });

        jLabel1.setText("Point:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(495, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(348, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPointActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPointActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtPoint;
    // End of variables declaration//GEN-END:variables
}
