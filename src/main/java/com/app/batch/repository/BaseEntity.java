package com.app.batch.repository;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // BaseEntity를 상속 받는 Entity는 BaseEntity에 선언된 필드들을 컬럼으로 인식한다.
@EntityListeners(AuditingEntityListener.class) // Entity에 이벤트가 발생할 경우 콜백을 실행한다. Entity에 생성 수정이 일어나면 콜백이 실행되어 시간을 만들어준다.
public abstract class BaseEntity {
    @CreatedDate // 엔티티가 생성되어 저장될 때 자동 저장
    @Column(updatable = false, nullable = false) // 업데이트 컬럼에 포함되지 않도록 정의
    private LocalDateTime createdAt;
    @LastModifiedDate // 변경할 때 업데이트 된다는 의미
    private LocalDateTime modifiedAt;
}
