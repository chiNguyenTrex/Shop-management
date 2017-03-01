/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entities.Employee;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.EmployeeDAO;
import model.EmployeeTableModel;

/**
 *
 * @author Chi Nguyen T-rex
 */
public class EmployeeManagement extends javax.swing.JPanel {

    private EmployeeDAO employeeDAO;
    private EmployeeTableModel tableModel;

    private String nameImage = "";
    private JFileChooser fileChooser;
    private BufferedImage bufferedImage;
    private ImageIcon imageIcon;
    private ListSelectionModel listSelectionModel;
    private ListSelectionListener listSelectionListener;

    private Font originalFont;
    private Font newFont;
    private Color originalColor;
    
    private List<Employee> listFind;

    /**
     * Creates new form ProductManagement
     */
    public EmployeeManagement() {
        initComponents();

        originalFont = new Font("Tahoma", Font.ITALIC, 14);
        newFont = new Font("Tahoma", Font.PLAIN, 14);
        originalColor = new Color(204, 204, 204);

        employeeDAO = new EmployeeDAO();
        tableModel = new EmployeeTableModel(employeeDAO.getEmployeeList());
        employeeTable.setModel(tableModel);

        employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel = employeeTable.getSelectionModel();
        listSelectionModel.addListSelectionListener(listSelectionListener = new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }

                int rowIndex = employeeTable.getSelectedRow();
                //OR
                /*
                 int rowIndex2 = ((ListSelectionModel) e.getSource()).getMinSelectionIndex();
                 */

                txtUsername.setText(tableModel.getValueAt(rowIndex, 2) + "");
                txtName.setText(tableModel.getValueAt(rowIndex, 1) + "");
                passwordField.setText(tableModel.getPassword(rowIndex));
                txtEmail.setText(tableModel.getEmail(rowIndex));
                txtPhone.setText(tableModel.getValueAt(rowIndex, 6) + "");
                txtBirthDate.setDate((Date) tableModel.getValueAt(rowIndex, 5));
                comboboxRole.setSelectedItem(tableModel.getValueAt(rowIndex, 4));

                if (((String) tableModel.getValueAt(rowIndex, 3)).equals("Nam")) {
                    radioMale.setSelected(true);
                } else {
                    radioFemale.setSelected(true);
                }

                String imageLink = tableModel.getImage(rowIndex);
                if (imageLink == null) {
                    lblImage.setText("No image");
                } else {
                    lblImage.setText("");
                    try {
                        bufferedImage = ImageIO.read(new File("empImages/" + imageLink));
                        imageIcon = new ImageIcon(bufferedImage.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), 0));
                        lblImage.setIcon(imageIcon);
                    } catch (IOException ex) {
                        Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSex = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        btnGetImage = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNameWarn = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblSex = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        txtFind = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        passwordField = new javax.swing.JPasswordField();
        jPanel16 = new javax.swing.JPanel();
        comboboxRole = new javax.swing.JComboBox();
        jPanel17 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblBirth = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        txtEmail = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        txtBirthDate = new com.toedter.calendar.JDateChooser();
        jPanel22 = new javax.swing.JPanel();
        txtPhone = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lblImage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setText("Image");
        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnGetImage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGetImage.setText("Browser");
        btnGetImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGetImage)
                .addGap(55, 55, 55))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGetImage)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.LINE_END);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridLayout(7, 3));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Họ và tên");

        lblNameWarn.setForeground(new java.awt.Color(255, 51, 51));
        lblNameWarn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblNameWarn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNameWarn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        jPanel3.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Giới tính");

        lblSex.setForeground(new java.awt.Color(255, 51, 51));
        lblSex.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSex, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        txtName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroupSex.add(radioMale);
        radioMale.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioMale.setText("Nam");

        buttonGroupSex.add(radioFemale);
        radioFemale.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioFemale.setText("Nữ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioMale)
                .addGap(75, 75, 75)
                .addComponent(radioFemale)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioMale)
                    .addComponent(radioFemale))
                .addContainerGap())
        );

        jPanel3.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        txtFind.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        txtFind.setForeground(new java.awt.Color(204, 204, 204));
        txtFind.setText("Tìm kiếm theo tên nhân viên");
        txtFind.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFindFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFindFocusLost(evt);
            }
        });
        txtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindActionPerformed(evt);
            }
        });
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFindKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFind, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Username");

        lblUsername.setForeground(new java.awt.Color(255, 51, 51));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        jPanel3.add(jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Password");

        lblPassword.setForeground(new java.awt.Color(255, 51, 51));
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        jPanel3.add(jPanel12);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Vai trò");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(207, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        jPanel3.add(jPanel13);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel14);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel15);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        comboboxRole.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboboxRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Quản lý cửa hàng", "Nhân viên bán hàng", "Nhân viên thu ngân" }));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboboxRole, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboboxRole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel16);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Email");

        lblEmail.setForeground(new java.awt.Color(255, 51, 51));
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        jPanel3.add(jPanel17);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Ngày sinh");

        lblBirth.setForeground(new java.awt.Color(255, 51, 51));
        lblBirth.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(lblBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblBirth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        jPanel3.add(jPanel18);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Điện thoại");

        lblPhone.setForeground(new java.awt.Color(255, 51, 51));
        lblPhone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        jPanel3.add(jPanel19);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel20);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        txtBirthDate.setDateFormatString("dd-MM-yyyy");
        txtBirthDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel21);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        txtPhone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel22);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(btnAdd)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel23);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(btnUpdate)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel24);

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(btnDelete)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel25);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        employeeTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(employeeTable);

        jPanel2.add(jScrollPane1);

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        listSelectionModel.removeListSelectionListener(listSelectionListener);

        int check = 0;
        String username, password, name, email, phone, role = "", sex;
        Date date;

        if ((name = txtName.getText()).equals("")) {
            lblNameWarn.setText("Bạn chưa nhập tên");
        } else {
            lblNameWarn.setText("");
            check++;
        }

        if ((username = txtUsername.getText()).equals("")) {
            lblUsername.setText("Bạn chưa nhập username");
        } else {
            if (employeeDAO.isUsernameDublicate(username)) {
                lblUsername.setText("Username đã tồn tại");
            } else {
                lblUsername.setText("");
                check++;
            }
        }

        if (buttonGroupSex.getSelection() == null) {
            lblSex.setText("Bạn chưa chọn giới tính");
        } else {
            lblSex.setText("");
            check++;
        }

        if ((password = new String(passwordField.getPassword())).equals("")) {
            lblPassword.setText("Bạn chưa nhập password");
        } else {
            lblPassword.setText("");
            check++;
        }

        if ((email = txtEmail.getText()).equals("")) {
            lblEmail.setText("Bạn chưa nhập email");
        } else {
            lblEmail.setText("");
            check++;
        }

        if ((phone = txtPhone.getText()).equals("")) {
            lblPhone.setText("Bạn chưa nhập sđt");
        } else {
            try {
                Integer.parseInt(phone);
                lblPhone.setText("");
                check++;
            } catch (Exception e) {
                lblPhone.setText("SĐT không hợp lệ");
            }
        }

        if ((date = txtBirthDate.getDate()) == null) {
            lblBirth.setText("Bạn phải chọn ngày sinh");
        } else {
            lblBirth.setText("");
            check++;
        }

        if (check == 7) {

            switch (comboboxRole.getSelectedIndex()) {
                case 0:
                    role = "Quản lý cửa hàng";
                    break;
                case 1:
                    role = "Nhân viên bán hàng";
                    break;
                case 2:
                    role = "Nhân viên thu ngân";
                    break;
            }

            sex = radioMale.isSelected() ? "Nam" : "Nữ";

            Employee employee = new Employee(username, password, name, role, email, sex, phone, date, nameImage, null);
            employeeDAO.addOrUpdateEmployee(employee);

            tableModel = new EmployeeTableModel(employeeDAO.getEmployeeList());
            employeeTable.setModel(tableModel);
        }

        listSelectionModel.addListSelectionListener(listSelectionListener);

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnGetImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetImageActionPerformed
        lblImage.setText("");
        fileChooser = new JFileChooser("D:\\Java Development\\Shop Manager");
        int select = fileChooser.showOpenDialog(this);
        if (select == JFileChooser.APPROVE_OPTION) {

            try {
                nameImage = fileChooser.getSelectedFile().getName();
                bufferedImage = ImageIO.read(new File("empImages/" + nameImage));
                imageIcon = new ImageIcon(bufferedImage.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), 0));
                lblImage.setIcon(imageIcon);
            } catch (IOException ex) {
                Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnGetImageActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        listSelectionModel.removeListSelectionListener(listSelectionListener);

        int row = employeeTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn hãy chọn dòng cần xóa!", "Delete", JOptionPane.INFORMATION_MESSAGE);
        } else {

            if (employeeDAO.deleteEmployee(employeeDAO.getEmployeeByUsernameAndPassword(txtUsername.getText(), new String(passwordField.getPassword())))) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!", "Delete", JOptionPane.INFORMATION_MESSAGE);
                tableModel = new EmployeeTableModel(employeeDAO.getEmployeeList());
                employeeTable.setModel(tableModel);
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!", "Delete", JOptionPane.INFORMATION_MESSAGE);
            }

        }

        listSelectionModel.addListSelectionListener(listSelectionListener);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        listSelectionModel.removeListSelectionListener(listSelectionListener);

        int row = employeeTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn hãy chọn dòng cần update!", "Update", JOptionPane.INFORMATION_MESSAGE);
        } else {

            int check = 0;
            String username, password, name, email, phone, role = "", sex;
            Date date;

            if ((name = txtName.getText()).equals("")) {
                lblNameWarn.setText("Bạn chưa nhập tên");
            } else {
                lblNameWarn.setText("");
                check++;
            }

            if ((username = txtUsername.getText()).equals("")) {
                lblUsername.setText("Bạn chưa nhập username");
            } else {
                lblUsername.setText("");
                check++;
            }

            if (buttonGroupSex.getSelection() == null) {
                lblSex.setText("Bạn chưa chọn giới tính");
            } else {
                lblSex.setText("");
                check++;
            }

            if ((password = new String(passwordField.getPassword())).equals("")) {
                lblPassword.setText("Bạn chưa nhập password");
            } else {
                lblPassword.setText("");
                check++;
            }

            if ((email = txtEmail.getText()).equals("")) {
                lblEmail.setText("Bạn chưa nhập email");
            } else {
                lblEmail.setText("");
                check++;
            }

            if ((phone = txtPhone.getText()).equals("")) {
                lblPhone.setText("Bạn chưa nhập sđt");
            } else {
                try {
                    Integer.parseInt(phone);
                    lblPhone.setText("");
                    check++;
                } catch (Exception e) {
                    lblPhone.setText("SĐT không hợp lệ");
                }
            }

            if ((date = txtBirthDate.getDate()) == null) {
                lblBirth.setText("Bạn phải chọn ngày sinh");
            } else {
                lblBirth.setText("");
                check++;
            }

            if (check == 7) {

                switch (comboboxRole.getSelectedIndex()) {
                    case 0:
                        role = "Quản lý cửa hàng";
                        break;
                    case 1:
                        role = "Nhân viên bán hàng";
                        break;
                    case 2:
                        role = "Nhân viên thu ngân";
                        break;
                }

                sex = radioMale.isSelected() ? "Nam" : "Nữ";

                Employee employee = new Employee(username, password, name, role, email, sex, phone, date, tableModel.getImage(row), null);
                employee.setIdEmployee(tableModel.getIdEmployee(row));
                if (employeeDAO.addOrUpdateEmployee(employee)) {
                    JOptionPane.showMessageDialog(this, "Update thành công!", "Update", JOptionPane.INFORMATION_MESSAGE);
                    tableModel = new EmployeeTableModel(employeeDAO.getEmployeeList());
                    employeeTable.setModel(tableModel);

                } else {
                    JOptionPane.showMessageDialog(this, "Update thất bại!", "Update", JOptionPane.INFORMATION_MESSAGE);
                }

            }

        }
        listSelectionModel.addListSelectionListener(listSelectionListener);

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtFindKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyTyped

    }//GEN-LAST:event_txtFindKeyTyped

    private void txtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindActionPerformed

    }//GEN-LAST:event_txtFindActionPerformed

    private void txtFindFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFindFocusGained
        txtFind.setText("");
        txtFind.setForeground(Color.BLACK);
        txtFind.setFont(newFont);
    }//GEN-LAST:event_txtFindFocusGained

    private void txtFindFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFindFocusLost
        txtFind.setText("Tìm kiếm theo tên nhân viên");
        txtFind.setForeground(originalColor);
        txtFind.setFont(originalFont);
    }//GEN-LAST:event_txtFindFocusLost

    private void txtFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyReleased
        listSelectionModel.removeListSelectionListener(listSelectionListener);
        String text = txtFind.getText();
        listFind = employeeDAO.getListEmployeeByName(text);
        tableModel = new EmployeeTableModel(listFind);
        employeeTable.setModel(tableModel);
        listSelectionModel.addListSelectionListener(listSelectionListener);

    }//GEN-LAST:event_txtFindKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGetImage;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroupSex;
    private javax.swing.JComboBox comboboxRole;
    private javax.swing.JTable employeeTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBirth;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblNameWarn;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private com.toedter.calendar.JDateChooser txtBirthDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
