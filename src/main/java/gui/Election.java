/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;


import businessLogic.election.ElectionController;
import businessLogic.dao.Database;
import businessLogic.election.Elections;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class Election extends CommonGui {
    private ElectionController electionController;


    /**
     * Creates new form Election
     */
    public Election() {
        initComponents();
        this.electionController = new ElectionController();
        fillTable();
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                onAdd();
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDelete();
            }
        });
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBack();
            }
        });
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onEdit();
            }
        });
        electionTable.getSelectionModel().addListSelectionListener(e -> onSelection());


        Database.initializeDatabase();

    }

    private void fillTable() {
        DefaultTableModel model = (DefaultTableModel) electionTable.getModel();
        model.setRowCount(0); // Clear the table
        try {
            List<Elections> electionsList = electionController.getAllElections();
            for (Elections election : electionsList) {
                Object[] row = new Object[3];
                row[0] = election.getId();
                row[1] = election.getElectionName();
                row[2] = election.getElectionDate();
                model.addRow(row); // Add the row to the table
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "An error occurred while fetching the elections: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    protected void onAdd() {
        String name = electionName.getText();
        SimpleDateFormat date = new SimpleDateFormat("MMM d, y");
        java.util.Date selectedDate = ElectionDate.getDate();
        if (name.isEmpty() || selectedDate == null) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String date1 = date.format(selectedDate);
        try {
            boolean isAdded = electionController.addElection(name, date1);
            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Election added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                fillTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add election", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to add election: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    protected void onDelete() {
        int selectedRow = electionTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an election to delete", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this election?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        int id = (int) electionTable.getValueAt(selectedRow, 0); // Assuming the id is in the first column
        try {
            boolean isDeleted = electionController.deleteElection(id);
            if (isDeleted) {
                JOptionPane.showMessageDialog(this, "Election deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                fillTable(); // Refresh the table
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete election", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to delete election: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    protected void onBack() {

    }

    @Override
    protected void onEdit() {
        int selectedRow = electionTable.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) electionTable.getValueAt(selectedRow, 0); // Assuming the id is in the first column
            String name = electionName.getText();
            SimpleDateFormat date = new SimpleDateFormat("MMM d, y");
            java.util.Date selectedDate = ElectionDate.getDate();
            if (name.isEmpty() || selectedDate == null) {
                JOptionPane.showMessageDialog(this, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String date1 = date.format(selectedDate);
            try {
                boolean isUpdated = electionController.updateElection(id, name, date1);
                if (isUpdated) {
                    JOptionPane.showMessageDialog(this, "Election updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    fillTable(); // Refresh the table
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update election", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Failed to update election: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an election to edit", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    protected void onSelection(JTable table, JLabel label) {
    }

    @Override
    protected void onSelection() {
        int selectedRow = electionTable.getSelectedRow();
        if (selectedRow >= 0) {
            String name = (String) electionTable.getValueAt(selectedRow, 1);
            String date = (String) electionTable.getValueAt(selectedRow, 2);
            electionName.setText(name);
            try {
                ElectionDate.setDate(new SimpleDateFormat("MMM d, y").parse(date));
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        }
    }

    @Override
    protected void onUpdate() {

    }

    @Override
    protected void onView() {

    }

    @Override
    protected void onSearch() {

    }


    @Override
    protected void processWindowEvent(java.awt.event.WindowEvent evt) {
        if (evt.getID() == java.awt.event.WindowEvent.WINDOW_CLOSING) {
            int exitConfirm = JOptionPane.showOptionDialog(this,
                    "Are you sure you want to close this window?", "Confirm Exit",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (exitConfirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else {
            super.processWindowEvent(evt);
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

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        electionTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        electionName = new javax.swing.JTextField();
        ElectionDate = new com.toedter.calendar.JDateChooser();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("Election Management System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(474, 474, 474)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(50, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setText("Manage Election");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Name");

        electionTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String[]{
                        "ID", "Name", "Date"
                }
        ));
        jScrollPane1.setViewportView(electionTable);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Add date");

        addBtn.setBackground(new java.awt.Color(0, 153, 0));
        addBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addBtn.setText("Add");


        editBtn.setBackground(new java.awt.Color(255, 255, 0));
        editBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editBtn.setText("Edit");

        deleteBtn.setBackground(new java.awt.Color(255, 153, 153));
        deleteBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteBtn.setText("Delete");

        backBtn.setBackground(new java.awt.Color(102, 102, 102));
        backBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        backBtn.setText("Back");
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 21, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                .addComponent(backBtn)
                                                                                                .addComponent(electionName, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGap(71, 71, 71))
                                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                        .addGap(9, 9, 9)
                                                                                        .addComponent(jLabel3)))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(addBtn)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(editBtn)
                                                                                .addGap(11, 11, 11)))
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(152, 152, 152)
                                                                                .addComponent(jLabel5))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(123, 123, 123)
                                                                                .addComponent(ElectionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(51, 51, 51)
                                                                                .addComponent(deleteBtn)))
                                                                .addGap(198, 198, 198)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(120, 120, 120))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(385, 385, 385))))
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(electionName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ElectionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(205, 205, 205)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(addBtn)
                                                        .addComponent(editBtn)
                                                        .addComponent(deleteBtn))
                                                .addGap(65, 65, 65)
                                                .addComponent(backBtn))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        // TODO add your handling code here:
        new MainMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnMouseClicked


    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Election.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Election.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Election.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Election.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Election().setVisible(true);
//            }
//        });
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser ElectionDate;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField electionName;
    private javax.swing.JTable electionTable;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
