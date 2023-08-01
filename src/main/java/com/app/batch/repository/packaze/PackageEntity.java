package com.app.batch.repository.packaze;

import com.app.batch.repository.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "package")
public class PackageEntity extends BaseEntity {
    @Id // PK 정의
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 자동생성 정의(PK생성을 DB에 위임한다는 설정)
    private Integer packageSeq;

    private String packageName;
    private Integer count;
    private Integer period;
}
