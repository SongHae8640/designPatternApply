package com.designpattern.apply.factory.domain.comment;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDto {
    private String writerName;

    private String password;

    private String content;

    private String commentType;

    private Long typesId;
}