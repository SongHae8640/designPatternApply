package com.designpattern.apply.factory.domain.comment;

import com.designpattern.apply.factory.domain.board.BoardRepository;
import com.designpattern.apply.factory.domain.drink.DrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final DrinkRepository drinkRepository;
    private final BoardRepository boardRepository;


    public List<Comment> getCommentList(CommentType commentType, Long typesId) {
        if(commentType == CommentType.DRINK) {
            drinkRepository.findById(typesId)
                    .orElseThrow(() -> new NoSuchElementException("존재하지 않는 음료입니다."));
        } else if(commentType == CommentType.BOARD) {
            boardRepository.findById(typesId)
                    .orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시글입니다."));
        }
        return commentRepository.findAllByCommentTypeAndTypesId(commentType, typesId);
    }

    public Comment saveComment(Comment comment) {
        if(comment.getCommentType() == CommentType.DRINK) {
            drinkRepository.findById(comment.getTypesId())
                    .orElseThrow(() -> new NoSuchElementException("존재하지 않는 음료입니다."))
                    .addCommentCount();
        } else if(comment.getCommentType() == CommentType.BOARD) {
            boardRepository.findById(comment.getTypesId())
                    .orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시글입니다."))
                    .addCommentCount();
        }
        return commentRepository.save(comment);
    }
}