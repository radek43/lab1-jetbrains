package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
}
