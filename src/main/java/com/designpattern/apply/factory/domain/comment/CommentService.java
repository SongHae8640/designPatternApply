package com.designpattern.apply.factory.domain.comment;

import java.util.List;

public abstract class CommentService {

    CommentRepository commentRepository;
    CommentType commentType;


    public List<Comment> getCommentList(CommentType commentType, Long typesId) {
        getTypesRepository()
                .checkTypesId(typesId);
        return commentRepository.findAllByCommentTypeAndTypesId(commentType, typesId);
    }

    public Comment saveComment(Comment comment) {
        getTypesRepository()
                .addCommentCount(comment.getTypesId());
        return commentRepository.save(comment);
    }

    public CommentType getCommentType() {
        return commentType;
    }

    abstract public TypesRepository getTypesRepository();
}