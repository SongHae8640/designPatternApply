package com.designpattern.apply.factory.domain.comment;

import com.designpattern.apply.factory.domain.drink.DrinkRepository;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class TypesDrinkRepository extends TypesRepository {
    private final DrinkRepository drinkRepository;

    public TypesDrinkRepository(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
        this.commentType = CommentType.DRINK;
    }

    @Override
    public void checkTypesId(Long typesId) {
        drinkRepository.findById(typesId)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 음료입니다."));
    }

    @Override
    public void addCommentCount(Long typesId) {
        drinkRepository.findById(typesId)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 음료입니다."))
                .addCommentCount();
    }
}

