package com.designpattern.apply.factory.domain.comment;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Builder
public class Comment{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "COMMENT_SEQ_GEN")
    @SequenceGenerator(name = "COMMENT_SEQ_GEN",
            sequenceName = "COMMENT_SEQ",
            allocationSize = 1)
    private Long id;

    @Column(name = "comment_type")
    @Enumerated(EnumType.STRING)
    private CommentType commentType;

    @Column(name = "types_id", nullable = false)
    private Long typesId;

    @Column(name = "writer_name", nullable = false)
    private String writerName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "content", nullable = false)
    private String content;
}