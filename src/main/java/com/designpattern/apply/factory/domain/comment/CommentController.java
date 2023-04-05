package com.designpattern.apply.factory.domain.comment;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final Map<CommentType, CommentService> commentServiceMap;

    public CommentController(List<CommentService> commentServiceList) {
        this.commentServiceMap = commentServiceList.stream()
                .collect(Collectors.toMap(CommentService::getCommentType, commentService -> commentService));
    }

    @GetMapping
    public List<Comment> getCommentList(@RequestParam String commentType, @RequestParam Long typesId) {
        return commentServiceMap.get(CommentType.of(commentType))
                .getCommentList(CommentType.of(commentType), typesId);
    }

    @PostMapping
    public Comment saveComment(@RequestBody CommentDto commentDto) {
        return commentServiceMap.get(CommentType.of(commentDto.getCommentType()))
                .saveComment(Comment.builder()
                        .commentType(CommentType.of(commentDto.getCommentType()))
                        .typesId(commentDto.getTypesId())
                        .writerName(commentDto.getWriterName())
                        .password(commentDto.getPassword())
                        .content(commentDto.getContent())
                        .build()
                );
    }
}