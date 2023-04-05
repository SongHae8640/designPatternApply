package com.designpattern.apply.factory.domain.comment;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum CommentType {
    DRINK("drink"),
    BOARD("board");

    private final String type;

    CommentType(String type) {
        this.type = type;
    }

    public static CommentType of(String type) {
        for (CommentType commentType : values()) {
            if (commentType.type.equals(type)) {
                return commentType;
            }
        }
        throw new IllegalArgumentException("Invalid CommentType: " + type);
    }
}