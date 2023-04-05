package com.designpattern.apply.factory.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final RepositoryFactory repositoryFactory;


    public List<Comment> getCommentList(CommentType commentType, Long typesId) {
        repositoryFactory.getRepository(commentType)
                .checkTypesId(typesId);
        return commentRepository.findAllByCommentTypeAndTypesId(commentType, typesId);
    }

    public Comment saveComment(Comment comment) {
        repositoryFactory.getRepository(comment.getCommentType())
                .addCommentCount(comment.getTypesId());
        return commentRepository.save(comment);
    }
}