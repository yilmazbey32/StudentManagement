package com.project.repository.business;

import com.project.entity.concretes.business.EducationTerm;
import com.project.entity.enums.Term;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationTermRepository extends JpaRepository<EducationTerm,Long> {
    boolean existsByTermAndYear(Term term, int year);
}
