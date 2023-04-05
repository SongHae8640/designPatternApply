package com.designpattern.apply.factory.domain.comment;

public interface TypesRepository {
    void checkTypesId(Long typesId);
    void addCommentCount(Long typesId);
}