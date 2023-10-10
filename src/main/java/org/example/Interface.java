package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface {
    private JPanel panel;
    private JTextField numeTextField;
    private JTextField prenumeTextField;
    private JButton editButton;
    private JLabel answer;
    private JTextField medieTextField;
    private JTable table1;

    public Interface() {
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int variable1 = Integer.parseInt(numeTextField.getText());
                    int variable2 = Integer.parseInt(prenumeTextField.getText());
                    answer.setText(""+variable1*variable2);
                } catch (NumberFormatException ex) {
                    answer.setText("invalid input");
                }
            }
        });
    }

    public JPanel getPanel(){
        return panel;
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
    public JButton getSubmitButton() {
        return editButton;
    }
    public void setAnswer(String answer) {
        this.answer.setText(answer);
    }


}
