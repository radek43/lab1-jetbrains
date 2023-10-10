package org.example;

public class Student {
    private String nume;
    private String prenume;
    private double medie;

    public Student(String nume, String prenume, Double medie) {
        this.nume = nume;
        this.prenume = prenume;
        this.medie = medie;
    }

    @Override
    public String toString() {
        return "Student {" +
                "nume='" + this.nume + '\'' +
                ", prenume='" + this.prenume + '\'' +
                ", medie=" + this.medie +
                '}';
    }
}
