package com.designpattern.apply.factory.domain.comment;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class RepositoryFactory {

    private final Map<CommentType, TypesRepository> repositoryMap;

    public RepositoryFactory(List<TypesRepository> typesRepositoryList) {
        this.repositoryMap = typesRepositoryList.stream()
                .collect(java.util.stream.Collectors.toMap(TypesRepository::getCommentType, typesRepository -> typesRepository));
    }

    public TypesRepository getRepository(CommentType commentType) {
        return repositoryMap.get(commentType);
    }
}
