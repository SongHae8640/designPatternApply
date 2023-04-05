package com.designpattern.apply.factory.domain.comment;

public abstract class TypesRepository {
    CommentType commentType;
    abstract void checkTypesId(Long typesId);
    abstract void addCommentCount(Long typesId);
    CommentType getCommentType() {
        return commentType;
    }
}