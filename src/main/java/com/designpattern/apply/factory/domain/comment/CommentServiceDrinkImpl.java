package com.designpattern.apply.factory.domain.comment;

import org.springframework.stereotype.Service;

@Service
public class CommentServiceDrinkImpl extends CommentService {

    private final TypesDrinkRepository typesDrinkRepository;

    public CommentServiceDrinkImpl(CommentRepository commentRepository, TypesDrinkRepository typesDrinkRepository) {
        this.commentRepository = commentRepository;
        this.commentType = CommentType.DRINK;
        this.typesDrinkRepository = typesDrinkRepository;
    }

    @Override
    public TypesRepository getTypesRepository() {
        return this.typesDrinkRepository;
    }
}