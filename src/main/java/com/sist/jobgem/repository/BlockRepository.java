package com.sist.jobgem.repository;

import com.sist.jobgem.dto.BlockDto;
import com.sist.jobgem.entity.Block;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRepository extends JpaRepository<Block, Integer> {

    @Query("SELECT new com.sist.jobgem.dto.BlockDto(b) FROM Block b WHERE b.coIdx = :coIdx ORDER BY b.blDate DESC LIMIT 3")
    List<BlockDto> findAllByCoIdx(@Param("coIdx") int coIdx);

    @Query("SELECT new com.sist.jobgem.dto.BlockDto(b) FROM Block b " +
            "WHERE b.coIdx = :coIdx " +
            "AND (:name IS NULL OR b.jobseeker.joName LIKE %:name%)")
    Page<BlockDto> findAllByCoIdxAndJoName(@Param("coIdx") int coIdx,
                                         @Param("name") String name,
                                         Pageable pageable);

    
    @Query("SELECT b FROM Block b " +
           "WHERE (:type = 'bldate' AND cast(b.blDate as string) LIKE %:value%) " +
           "OR (:type = 'blcontent' AND b.blContent LIKE %:value%) " +
           "OR (:type = 'joinDate' AND cast(b.jobseeker.user.usJoinDate as string) LIKE %:value%) " +
           "OR (:type = 'leaveDate' AND cast(b.jobseeker.user.usLeaveDate as string) LIKE %:value%) " +
           "OR (:type = 'name' AND b.jobseeker.joName LIKE %:value%) " +
           "OR (:type = 'phone' AND b.jobseeker.joTel LIKE %:value%) " +
           "OR (:type = 'gender' AND b.jobseeker.joGender LIKE %:value%) " +
           "OR (:type = 'birth' AND cast(b.jobseeker.joBirth as string) LIKE %:value%) " +
           "OR (:type = 'address' AND b.jobseeker.joAddress LIKE %:value%) " +
           "OR (:type = 'edu' AND b.jobseeker.joEdu LIKE %:value%) " +
           "OR (:type = 'sal' AND b.jobseeker.joSal LIKE %:value%)")
    Page<BlockDto> findByTypeAndValuejobseekerContaining(@Param("type") String type, @Param("value") String value, Pageable pageable);

    @Query("SELECT b FROM Block b " +
            "WHERE (:type = 'bldate' AND cast(b.blDate as string) LIKE %:value%) OR " +
            "(:type = 'blcontent' AND b.blContent LIKE %:value%) OR " +
            "(:type = 'name' AND b.company.coName LIKE %:value%) OR " +
            "(:type = 'number' AND b.company.coNumber LIKE %:value%) OR " +
            "(:type = 'address' AND b.company.coAddress LIKE %:value%) OR " +
            "(:type = 'tel' AND b.company.coTel LIKE %:value%) OR " +
            "(:type = 'type' AND b.company.coType LIKE %:value%) OR " +
            "(:type = 'open' AND cast(b.company.coOpen as string) LIKE %:value%) OR " +
            "(:type = 'employee' AND cast(b.company.coEmployee as string) LIKE %:value%) OR " +
            "(:type = 'sales' AND b.company.coSales LIKE %:value%) OR " +
            "(:type = 'score' AND cast(b.company.coScore as string) LIKE %:value%) OR " +
            "(:type = 'managerName' AND b.company.coManagerName LIKE %:value%) OR " +
            "(:type = 'managerTel' AND b.company.coManagerTel LIKE %:value%)")
    Page<BlockDto> findByTypeAndValuecompanyContaining(@Param("type") String type, @Param("value") String value, Pageable pageable);
    
    @Query("SELECT new com.sist.jobgem.dto.BlockDto(b) FROM Block b " +
           "join b.jobseeker j join b.company c " +
           "on b.joIdx = j.id and b.coIdx = c.id")
    Page<BlockDto> blackjobcompany(Pageable pageable);
}