/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import businessLogic.candidate.Candidate;
import businessLogic.candidate.CandidateController;
import businessLogic.dao.Database;
import businessLogic.election.ElectionController;
import businessLogic.election.ElectionRepository;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Sami
 */
public  class Candidates extends CommonGui {
private CandidateController candidateController;

private JLabel imageLabel;
private byte[] imageBytesField;
    /**
     * Creates new form Candidates
     */
    public Candidates() throws SQLException {
        initComponents();
        imageLabel = new JLabel();
       this.candidateController = new CandidateController();
        ElectionRepository electionRepository = new ElectionRepository();
        List<Integer> electionIds =electionRepository.getAllElectionIds();
        for (Integer id : electionIds) {
            candidateElections.addItem(id.toString());
        }
       fillTable(candidateTable);
//        candidateElections.addItem("1");
//        candidateElections.addItem("2");
//        candidateElections.addItem("3");
        addBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                onAdd();
            }
        });
        deleteBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                onDelete();
            }
        });
        backBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                onBack();
            }
        });
        editBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                onEdit();
            }
        });
        uploadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(selectedFile.getAbsolutePath()).getImage().getScaledInstance(candidatePhoto.getWidth(), candidatePhoto.getHeight(), Image.SCALE_DEFAULT));
                    candidatePhoto.setIcon(imageIcon);

                    // Convert the image file to byte array
                    byte[] imageBytes = new byte[0];
                    try {
                        imageBytes = Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    // Set the image bytes to a field for later use
                    imageBytesField = imageBytes;
                }
            }
        });
        candidateTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onSelection(candidateTable,candidatePhoto);
            }
        });

        Database.initializeDatabase();
    }
    protected void fillTable(JTable table){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0); // Clear the table
	List<Candidate> candidateList = candidateController.getAllCandidates();
	for (Candidate candidate : candidateList) {
	    Object[] row = new Object[6];
	    row[0] = candidate.getId();
	    row[1] = candidate.getCandidateName();
	    row[2] = candidate.getCandidateAge();
	    row[3] = candidate.getCandidateGender();
	    row[4] = candidate.getCandidateElect() ;
        row[5] =candidate.getCandidatePhoto();
	    model.addRow(row); // Add the row to the table
	}
        TableColumn photoColumn = table.getColumnModel().getColumn(5);
        photoColumn.setMinWidth(0);
        photoColumn.setMaxWidth(0);
        photoColumn.setWidth(0);
        photoColumn.setPreferredWidth(0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        candidateTable = new javax.swing.JTable();
        candidateName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        candidateAge = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        candidateGender = new javax.swing.JComboBox<>();
        candidateElections = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        uploadBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        candidatePhoto = new javax.swing.JLabel();

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
                .addContainerGap(415, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setText("Manage Candidate");

        candidateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Can_Id", "Can_Name", "Can_Age", "Can_Gender", "Can_Election", "Can_Photo"
            }
        ));
        jScrollPane1.setViewportView(candidateTable);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Age");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Gendar");

        candidateGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Elections");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("photo");

        uploadBtn.setBackground(new java.awt.Color(0, 102, 102));
        uploadBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        uploadBtn.setText("upload");
        uploadBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 153, 102), null, null));

        editBtn.setBackground(new java.awt.Color(204, 204, 0));
        editBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editBtn.setText("Edit");
        editBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 153, 102), null, null));

        addBtn.setBackground(new java.awt.Color(0, 153, 51));
        addBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addBtn.setText("Add");
        addBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 153, 102), null, null));

        deleteBtn.setBackground(new java.awt.Color(255, 0, 0));
        deleteBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 153, 102), null, null));

        backBtn.setBackground(new java.awt.Color(51, 51, 51));
        backBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        backBtn.setText("Back");
        backBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 153, 102), null, null));

        candidatePhoto.setBackground(new java.awt.Color(255, 51, 0));
        candidatePhoto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        candidatePhoto.setForeground(new java.awt.Color(255, 51, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(364, 364, 364))))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(uploadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(candidateName, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(candidateElections, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(candidateAge, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(candidateGender, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(candidatePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(candidateGender, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(candidateAge, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(candidateName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(candidatePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(candidateElections, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(uploadBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addBtn)
                            .addComponent(deleteBtn)
                            .addComponent(editBtn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addComponent(backBtn)
                .addGap(76, 76, 76))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Candidates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Candidates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Candidates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Candidates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Candidates().setVisible(true);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField candidateAge;
    private javax.swing.JComboBox<String> candidateElections;
    private javax.swing.JComboBox<String> candidateGender;
    private javax.swing.JTextField candidateName;
    private javax.swing.JLabel candidatePhoto;
    private javax.swing.JTable candidateTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton uploadBtn;

    @Override
    protected void onAdd() {
        // Retrieve data from the form fields
        String name = candidateName.getText();
        String ageText = candidateAge.getText();
        String gender = (String) candidateGender.getSelectedItem();
        String electionsText = (String) candidateElections.getSelectedItem();
        byte[] photo = imageBytesField;
        if (name.isEmpty() || ageText.isEmpty() || gender.isEmpty() || electionsText.isEmpty() || photo == null) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int age = ageText != null ? Integer.parseInt(ageText) : 0;
        int elections = electionsText != null ? Integer.parseInt(electionsText) : 0;

        // Call the addCandidate method from the CandidateController class to insert the new Candidate into the database
        try {
            candidateController.addCandidate(name, age, elections, photo, gender);
            JOptionPane.showMessageDialog(this, "Candidate added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            // Handle exception
            JOptionPane.showMessageDialog(this, "Error adding candidate: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Refresh the table to show the newly added Candidate
        fillTable(candidateTable);
    }

   @Override
protected void onDelete() {
    int selectedRow = candidateTable.getSelectedRow();
    if (selectedRow != -1) { // Check if a row is actually selected
        // Show a confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this candidate?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Retrieve the Candidate ID from the selected row
            int candidateId = (int) candidateTable.getValueAt(selectedRow, 0);

            // Call the delete method from the CandidateController class to delete the Candidate from the database
            boolean isDeleted = candidateController.deleteCandidate(candidateId);
            if (isDeleted) {
                // Refresh the table to remove the deleted Candidate
                fillTable(candidateTable);
                JOptionPane.showMessageDialog(this, "Candidate deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error deleting candidate", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a candidate to delete", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    @Override
    protected void onBack() {
        this.setVisible(false);
        new MainMenu().setVisible(true);

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
protected void onEdit() {
    int selectedRow = candidateTable.getSelectedRow();
    if (selectedRow != -1) { // Check if a row is actually selected
        // Retrieve the Candidate ID from the selected row
        int candidateId = (int) candidateTable.getValueAt(selectedRow, 0);

        // Retrieve the updated data from the form fields
        String name = candidateName.getText();
        String ageText = candidateAge.getText();
        String gender = (String) candidateGender.getSelectedItem();
        String electionsText = (String) candidateElections.getSelectedItem();
        byte[] photo = imageBytesField;

        int age = ageText != null ? Integer.parseInt(ageText) : 0;
        int elections = electionsText != null ? Integer.parseInt(electionsText) : 0;

        // Call the updateCandidate method from the CandidateController class to update the Candidate in the database
	boolean isUpdated = false;
	try {
	    isUpdated = candidateController.updateCandidate(candidateId, name, age, elections, photo,gender);
            if (isUpdated) {
                // Refresh the table to show the updated Candidate
                fillTable(candidateTable);
                JOptionPane.showMessageDialog(this, "Candidate updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(this, "Error updating candidate", "Error", JOptionPane.ERROR_MESSAGE);
            }
	} catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to update election: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

    } else {
        JOptionPane.showMessageDialog(this, "Please select a candidate to update", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

   @Override
    protected void onSelection(JTable table, JLabel label) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) { // Check if a row is actually selected

            candidateName.setText(table.getValueAt(selectedRow, 1).toString());
            candidateAge.setText(table.getValueAt(selectedRow, 2).toString());
            candidateGender.setSelectedItem(table.getValueAt(selectedRow, 3).toString());
            candidateElections.setSelectedItem(table.getValueAt(selectedRow, 4).toString());

            // Display the image
            byte[] imageBytes = (byte[]) table.getValueAt(selectedRow, 5);
            if (imageBytes != null) {
                // Convert the image bytes to an ImageIcon and display it in the candidatePhoto label
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(imageBytes).getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
               label.setIcon(imageIcon);
           }else{
                label.setIcon(null);
            }
        }
    }

    @Override
    protected void onSelection() {

    }
    // End of variables declaration//GEN-END:variables
}
