package com.designpattern.apply.factory.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByCommentTypeAndTypesId(CommentType commentType, Long typesId);
}