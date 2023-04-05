package com.designpattern.apply.factory.domain.drink;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "drink")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
public class Drink {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "DRINK_SEQ_GEN")
    @SequenceGenerator(name = "DRINK_SEQ_GEN",
            sequenceName = "DRINK_SEQ",
            allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "description")
    private String description;

    @Column(name = "comment_count", nullable = false)
    private Long commentCount;

    @PrePersist
    public void prePersist(){
        this.commentCount = 0L;
    }

    public void addCommentCount() {
        this.commentCount++;
    }
}