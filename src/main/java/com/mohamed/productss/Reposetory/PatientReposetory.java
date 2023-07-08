package com.mohamed.productss.Reposetory;

import com.mohamed.productss.enteties.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientReposetory extends JpaRepository<Patient,Long> {
    public Page<Patient> findByNameContains(String mc, Pageable pageable);
}
