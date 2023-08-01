package com.app.batch.repository.packaze;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface PackageRepository extends JpaRepository<PackageEntity, Integer> {
    List<PackageEntity> findByCreatedAtAfter(LocalDateTime dateTime, Pageable pageable);

    @Transactional // insert, update, delete 실행에 필요한 어노테이션, 미선언시 익셉션 발생
    @Modifying // insert, update, delete 실행에 필요한 어노테이션, 미선언시 에러 발생
    @Query(value = "UPDATE PackageEntity  p" +
            "       SET p.count = :count," +
            "           p.period = :period" +
            "       WHERE p.packageSeq = :packageSeq")
    int updateCountAndPeriod(Integer packageSeq, Integer count, Integer period);
}
