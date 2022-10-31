package com.example.springbootaws.domain.posts;

import com.example.springbootaws.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    /**
     * Entity의 PK는 Long 차입의 Auto_increment를 추천
     * ㄴ FK를 맺을 때 다른 테이블에서 복합키 전부를 갖고 있거나, 중가 테이블을 하나 더 둬야 하는 상황이 발생
     * ㄴ 인덱스에 좋은 영향을 끼치지 못함
     * ㄴ 유니크한 조건이 변경될 경우 PK 전체를 수정해야 하는 일이 발생
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
