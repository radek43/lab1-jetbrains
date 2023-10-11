package org.example;

import java.util.UUID;

public class Student {
    private String id;
    private String nume;
    private String prenume;
    private String medie;

    public Student() {}

    public Student(String nume, String prenume, String medie) {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.nume = nume;
        this.prenume = prenume;
        this.medie = medie;
    }

    public Student(String id, String nume, String prenume, String medie) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.medie = medie;
    }


    public String getId() { return id; }

    public String getNume() { return nume; }

    public String getPrenume() {
        return prenume;
    }

    public String getMedie() {
        return medie;
    }

    @Override
    public String toString() {
        return "Student {" +
                "id='" + this.id + '\'' +
                "nume='" + this.nume + '\'' +
                ", prenume='" + this.prenume + '\'' +
                ", medie=" + this.medie +
                '}';
    }
}
