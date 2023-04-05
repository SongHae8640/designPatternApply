package com.designpattern.apply.factory.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RepositoryFactory {

    private final TypesDrinkRepository typesDrinkRepository;
    private final TypesBoardRepository typesBoardRepository;

    public TypesRepository getRepository(CommentType commentType) {
        if (commentType == CommentType.DRINK) {
            return typesDrinkRepository;
        } else if (commentType == CommentType.BOARD) {
            return typesBoardRepository;
        }
        throw new IllegalArgumentException("Invalid CommentType: " + commentType);
    }
}
