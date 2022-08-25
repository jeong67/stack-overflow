package com.codestates.preproject.stackoverflow.photo;

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
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photoId;

    @Column
    @Lob
    private String photo;

    @Column
    private String photoName;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime modifiedDate;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
