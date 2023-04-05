package com.designpattern.apply.factory.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public List<Comment> getCommentList(@RequestParam String commentType, @RequestParam Long typesId) {
        return commentService.getCommentList(CommentType.of(commentType), typesId);
    }

    @PostMapping
    public Comment saveComment(@RequestBody CommentDto commentDto) {
        return commentService.saveComment(Comment.builder()
                        .commentType(CommentType.of(commentDto.getCommentType()))
                        .typesId(commentDto.getTypesId())
                        .writerName(commentDto.getWriterName())
                        .password(commentDto.getPassword())
                        .content(commentDto.getContent())
                        .build()
                );
    }
}