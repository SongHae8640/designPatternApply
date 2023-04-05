package com.designpattern.apply.factory.domain.comment;

import com.designpattern.apply.factory.domain.drink.DrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class TypesDrinkRepository implements TypesRepository {
    private final DrinkRepository drinkRepository;

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

