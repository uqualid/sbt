package gdsctuk.sbbasic.sptingbootstudybasic.entity;

import lombok.*;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    //@OneToMany(mappedBy = "bId", cascade = CascadeType.ALL)
    private Long boardId;

    @Column(length = 40, nullable = false)
    private String boardTitle;

    @Column(length = 10000, nullable = false)
    private String boardContent;

    @Column(length = 20, nullable = false)
    private String boardWriter;

    @CreatedDate
    private LocalDateTime boardWriteTime;

    @LastModifiedDate
    private LocalDateTime boardEditTime;

    private Boolean isDeleted; // Null default - soft delete 판별용



    // 값 주입을 위해 사용; builder
    @Builder
    public Board(Long boardId, String boardTitle, String boardContent, String boardWriter,
                 LocalDateTime boardWriteTime, LocalDateTime boardEditTime) {
        this.boardId = boardId;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardWriter = boardWriter;
        this.boardWriteTime = boardWriteTime;
        this.boardEditTime = boardEditTime;
    }

    public void updateBoard(Long boardId) {
        this.boardId = boardId;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
    }

    public void delete() {
        this.isDeleted = true;
    }

}