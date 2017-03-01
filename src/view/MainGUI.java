/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import entities.Employee;
import javax.swing.JFrame;
import javax.swing.UIManager;
import model.EmployeeDAO;

/**
 *
 * @author Chi Nguyen T-rex
 */
public class MainGUI extends JFrame {
    private static Employee emp;
    private static final EmployeeDAO employeeDAO = new EmployeeDAO();

    private static JFrame mainFrameGUI;

    /**
     * Creates new form MainGUI
     * @param id
     */
    public MainGUI(int id) {
        initComponents();
        this.setLocation(80, 80);
        this.setSize(1200, 600);
        
        setEmployee(id);
        mainFrameGUI = this;
   
        
        switch(emp.getRole()) {
            case "Quản lý cửa hàng":
                add(new ManagerPanel());
                break;
            case "Nhân viên bán hàng":
                add(new SalePanel());
                break;
            case "Nhân viên thu ngân":
                add(new CashierPanel());
                break;
        }
       
        setVisible(true);
        
        
        
    }
    
    public static Employee getEmployee() {
        return emp;
    }
    
    public static void setEmployee(int id) {
        emp = employeeDAO.getEmployeeById(id);
    }
    
    public static JFrame getMainFrameGUI() {
        return mainFrameGUI;
    }

 

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        btnMenuItemExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new java.awt.GridLayout(1, 1));

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuItem1.setText("Log out");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        btnMenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        btnMenuItemExit.setBackground(new java.awt.Color(255, 255, 255));
        btnMenuItemExit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMenuItemExit.setText("Exit");
        btnMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(btnMenuItemExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnMenuItemExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnMenuItemExit;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
