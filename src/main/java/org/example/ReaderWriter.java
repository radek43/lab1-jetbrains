package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.util.Arrays;

public class ReaderWriter {
    public void write(List<Student> students) {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            String json = objectMapper.writeValueAsString(students);
            String filePath = "src/main/java/org/example/students.json";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(json);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> read() {
        List<Student> res = new ArrayList<Student>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String filePath = "src/main/java/org/example/students.json";
            res = Arrays.asList(objectMapper.readValue(new File(filePath), Student[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void update(Student studentToAdd) {
        List<Student> existingStudents = read();
        existingStudents.add(studentToAdd);
        write(existingStudents);
    }
}
