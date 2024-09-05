package com.sist.jobgem.repository;

import com.sist.jobgem.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CareerRepository extends JpaRepository<Career, Integer> {
    List<Career> findByIdIn(List<Integer> crIdx);
}
