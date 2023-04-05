package com.designpattern.apply.factory.domain.comment;

import com.designpattern.apply.factory.domain.board.BoardRepository;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class TypesBoardRepository extends TypesRepository {

    private final BoardRepository boardRepository;

    public TypesBoardRepository(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
        this.commentType = CommentType.BOARD;
    }

    @Override
    public void checkTypesId(Long typesId) {
        boardRepository.findById(typesId)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시글입니다."));
    }

    @Override
    public void addCommentCount(Long typesId) {
        boardRepository.findById(typesId)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시글입니다."))
                .addCommentCount();
    }
}
