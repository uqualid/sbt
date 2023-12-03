package gdsctuk.sbbasic.sptingbootstudybasic.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long commentId;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "boardId")
    @Column(updatable = false) //nullable = false,
    private Long bId;

    @Column(length = 20, nullable = false)
    private String commentWriter;

    @Column(length = 10000, nullable = false)
    private String commentContent;

    @CreatedDate
    private LocalDateTime commentWriteTime;

    @LastModifiedDate
    private LocalDateTime commentEditTime;

    private Boolean isDeleted; // Null default - soft delete 판별용

    @Builder

    public Comment(Long commentId, Long bId, String commentWriter, String commentContent,
                   LocalDateTime commentWriteTime, LocalDateTime commentEditTime) {
        this.commentId = commentId;
        this.bId = bId;
        this.commentWriter = commentWriter;
        this.commentContent = commentContent;
        this.commentWriteTime = commentWriteTime;
        this.commentEditTime = commentEditTime;
    }


    public void updateComment(String commentContent) {
        this.commentContent = commentContent;
    }

    public void delete() {
        this.isDeleted = true;
    }
}