package com.app.batch.repository.pass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PassRepository extends JpaRepository<PassEntity, Integer> {
    @Transactional
    @Modifying
    @Query(value =  "UPDATE PassEntity p" +
                    "SET p.remainingCount = :remainingcount," +
                        "p.moditiedAt = CURRENT_TIMESTAMP" +
                    "WHERE p.passSeq = :passSeq")
    int updateRemainingCount(Integer passSeq, Integer remainingCount);
}
