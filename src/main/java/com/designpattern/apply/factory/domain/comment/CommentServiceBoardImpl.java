package com.designpattern.apply.factory.domain.comment;

import org.springframework.stereotype.Service;

@Service
public class CommentServiceBoardImpl extends CommentService {

    private final TypesBoardRepository typesBoardRepository;

    public CommentServiceBoardImpl(CommentRepository commentRepository, TypesBoardRepository typesBoardRepository) {
        this.commentRepository = commentRepository;
        this.commentType = CommentType.BOARD;
        this.typesBoardRepository = typesBoardRepository;
    }

    @Override
    public TypesRepository getTypesRepository() {
        return this.typesBoardRepository;
    }
}