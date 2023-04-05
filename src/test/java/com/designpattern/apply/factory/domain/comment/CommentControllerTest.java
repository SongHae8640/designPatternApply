package com.designpattern.apply.factory.domain.comment;

import com.designpattern.apply.factory.domain.board.Board;
import com.designpattern.apply.factory.domain.board.BoardRepository;
import com.designpattern.apply.factory.domain.drink.Drink;
import com.designpattern.apply.factory.domain.drink.DrinkRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CommentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    DrinkRepository drinkRepository;

    Long savedBoardId;
    Long savedDrinkId;


    @BeforeEach
    void setUp() {
        Board board = boardRepository.save(Board.builder()
                .title("제목")
                .content("내용")
                .build());
        savedBoardId = board.getId();

        Drink drink = drinkRepository.save(Drink.builder()
                .name("코카콜라")
                .description("코카콜라는 맛있다.")
                .build());
        savedDrinkId = drink.getId();

        commentRepository.save(Comment.builder()
                .content("댓글")
                .writerName("tester")
                .password("1234")
                .commentType(CommentType.BOARD)
                .typesId(savedBoardId)
                .build());

        commentRepository.save(Comment.builder()
                .content("댓글")
                .writerName("tester")
                .password("1234")
                .commentType(CommentType.DRINK)
                .typesId(savedDrinkId)
                .build());
    }

    @Test
    void 술_댓글_기본_조회() throws Exception {
        // Given
        String commentType = "drink";
        long typesId = 1L;
        String url = "/api/comments?commentType=" + commentType + "&typesId=" + typesId;

        // When
        ResultActions actions = mockMvc.perform(get(url)

        );


        // Then
        System.out.println("------------------");
        actions.andExpect(status().isOk());
        System.out.println(actions.andReturn().getResponse().getContentAsString());

    }

    @Test
    void 술_댓글_기본_저장() throws Exception {
        // Given
        String url = "/api/comments";
        String commentType = "drink";
        Long typesId = 1L;
        CommentDto commentDto = new  CommentDto();
        commentDto.setCommentType(commentType);
        commentDto.setTypesId(typesId);
        commentDto.setWriterName("테스터");
        commentDto.setContent("테스트 코멘트");
        commentDto.setPassword("1234");



        // When
        ResultActions actions = mockMvc.perform(post(url)
                .content(new ObjectMapper().writeValueAsString(commentDto))
                .contentType(MediaType.APPLICATION_JSON)
        );


        // Then
        System.out.println("------------------");
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value(commentDto.getContent()))
                .andExpect(jsonPath("$.writerName").value(commentDto.getWriterName()))
                .andExpect(result -> {
                    System.out.println("status :: " + result.getResponse().getStatus());
                    System.out.println("body :: " + result.getResponse().getContentAsString());
                });
        assertEquals(1 , drinkRepository.findById(typesId).get().getCommentCount());
    }
}