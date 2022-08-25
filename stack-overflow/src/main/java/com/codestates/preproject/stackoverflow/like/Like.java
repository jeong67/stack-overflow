package com.codestates.preproject.stackoverflow.like;


import com.codestates.preproject.stackoverflow.answer.Answer;
import com.codestates.preproject.stackoverflow.question.Question;
import com.codestates.preproject.stackoverflow.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    @AllArgsConstructor
    private enum Type {
        QUESTION('Q'),
        ANSWER('A');
        private char value;
    }


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime modifiedDate;

}
