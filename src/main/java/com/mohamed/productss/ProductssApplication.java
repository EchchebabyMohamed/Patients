package com.mohamed.productss;

import com.mohamed.productss.Reposetory.PatientReposetory;
import com.mohamed.productss.enteties.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ProductssApplication implements CommandLineRunner {
    @Autowired
    private PatientReposetory patientReposetory;
    public static void main(String[] args) {
        SpringApplication.run(ProductssApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
