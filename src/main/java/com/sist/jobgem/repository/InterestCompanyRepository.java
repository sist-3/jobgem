package com.sist.jobgem.repository;

import com.sist.jobgem.entity.InterestCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestCompanyRepository extends JpaRepository<InterestCompany, Integer> {
    
}
