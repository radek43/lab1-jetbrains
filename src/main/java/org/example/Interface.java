package org.example;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interface extends javax.swing.JFrame {
    private JPanel rootPanel;
    private JTable studentTable;
    private JTextField numeTextField;
    private JTextField prenumeTextField;
    private JTextField medieTextField;
    private JButton modificaButton;
    private JButton stergeButton;
    private JTextField idTextField;
    private DefaultTableModel tableModel = new DefaultTableModel();
    public Interface() {
        createTable();
        modificaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numeTextField.getText().isEmpty() || prenumeTextField.getText().isEmpty() || medieTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPanel, "Completati toate campurile necesare.");
                } else {
                    if (!isNumeric(medieTextField.getText())) {
                        JOptionPane.showMessageDialog(rootPanel, "Introduceti doar numere in campul 'medie'.");
                    } else {
                        if (isValueInTable(studentTable, idTextField.getText())) {

                        } else {
                            Student studentAdd = new Student(numeTextField.getText(), prenumeTextField.getText(), medieTextField.getText());
                            tableModel.addRow(new Object[]{studentAdd.getId(), studentAdd.getNume(), studentAdd.getPrenume(), studentAdd.getMedie()});
                        }
                        exportData(tableModel);
                    }
                }
            }
        });

        studentTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = studentTable.getSelectedRow();
                    if (selectedRow >= 0) {
                        String selectedId = (String) tableModel.getValueAt(selectedRow, 0);
                        String selectedNume = (String) tableModel.getValueAt(selectedRow, 1);
                        String selectedPrenume = (String) tableModel.getValueAt(selectedRow, 2);
                        String selectedMedie = (String) tableModel.getValueAt(selectedRow, 3);
                        idTextField.setText(selectedId);
                        numeTextField.setText(selectedNume);
                        prenumeTextField.setText(selectedPrenume);
                        medieTextField.setText(selectedMedie);
                    }
                }
            }
        });

    }
    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JTextField getNumeTextField() {
        return numeTextField;
    }

    public JTextField getPrenumeTextField() {
        return prenumeTextField;
    }

    public JTextField getMedieTextField() {
        return medieTextField;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }
    private void createTable() {
        studentTable.setDefaultEditor(Object.class, null);
        studentTable.setModel(tableModel);
        ReaderWriter rw = new ReaderWriter();
        List<Student> students = rw.read();

        tableModel.setColumnIdentifiers(new Object[]{"ID", "Nume", "Prenume", "Medie"});
        for (Student obj : students) {
            tableModel.addRow(new Object[]{obj.getId(), obj.getNume(), obj.getPrenume(), obj.getMedie()});
        }
    }

    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }

    private static Student[] exportData(TableModel model) {
        int rowCount = model.getRowCount();
        Student[] students = new Student[rowCount];

        ReaderWriter rw = new ReaderWriter();

        for (int i = 0; i < rowCount; i++) {
            String idExp = (String) model.getValueAt(i, 0);
            String numeExp = (String) model.getValueAt(i, 1);
            String prenumeExp = (String) model.getValueAt(i, 2);
            String medieExp = (String) model.getValueAt(i, 3);

            students[i] = new Student(idExp, numeExp, prenumeExp, medieExp);
        }

        ArrayList<Student> res = new ArrayList(Arrays.asList(students));

        rw.write(res);

        return students;
    }

    public static boolean isValueInTable(JTable table, Object value) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        int colCount = model.getColumnCount();

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                Object cellValue = model.getValueAt(row, col);
                if (cellValue != null && cellValue.equals(value)) {
                    return true; // Value found in the table
                }
            }
        }
        return false;
    }

}
