package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Interface form = new Interface();
        System.out.println();


        JFrame frame = new JFrame("Student Management");
        frame.setContentPane(new Interface().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


//        ReaderWriter rw = new ReaderWriter();
//
//        List<Student> students = new ArrayList<>();
//        students.add(new Student("Popescu", "George", 9.5));
//        students.add(new Student("Ardelean", "Mihai", 8.2));
//        rw.write(students);

    }
}

