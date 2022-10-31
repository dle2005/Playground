package com.example.springbootaws.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @MappedSuperclass
 * ㄴ JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우
 * ㄴ 필드들(createDate, modifiedDate)도 칼럼으로 인식하도록 함
 */

/**
 * @EntityListeners(AuditingEntityListener.class)
 * ㄴ BaseTimeEntity 클래스에 Auditing 기능을 포함시킴
 */

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    /**
     * @CreatedDate
     * ㄴ Entity가 생성되어 저장될 때 시간이 자동 저장
     */
    @CreatedDate
    private LocalDateTime createdDate;

    /**
     * @LastModifiedDate
     * ㄴ 조회한 Entity의 값을 변경할 때 시간이 자동 저장
     */
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
