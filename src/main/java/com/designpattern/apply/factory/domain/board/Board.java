package com.designpattern.apply.factory.domain.board;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "board")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "DISCOVER_SEQ_GEN")
    @SequenceGenerator(name = "DISCOVER_SEQ_GEN",
            sequenceName = "DISCOVER_SEQ",
            allocationSize = 1)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "comment_count", nullable = false)
    private Long commentCount;

    @PrePersist
    public void prePersist(){
        this.commentCount = 0L;
    }

    public void addCommentCount() {
        this.commentCount++;
    }
}