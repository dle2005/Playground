package com.example.springbootaws.web.dto;

import com.example.springbootaws.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    /**
     * Entity 클래스를 Req/Res 클래스로 사용해서는 안 됨
     * ㄴ Entity 클래스는 데이터베이스와 맞닿은 핵심 클래스로 Entity 클래스를 기준으로 테이블이 생성, 스키마가 변경
     * ㄴ 화면 변경은 아주 사소한 변경인데, 이를 위해 테이블과 연결된 Entity 클래스 변경은 너무 큰 변경
     * ㄴ 수많은 클래스나 비즈니스 로직들이 Entity 클래스를 기준으로 동작, Dto는 View를 위한 클래스라 자주 변경이 필요
     * ㄴ View Layer와 DB Layer의 역할 분리를 철저하게 하는게 좋음
     */
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
