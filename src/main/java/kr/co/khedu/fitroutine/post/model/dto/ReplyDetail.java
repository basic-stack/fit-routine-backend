package kr.co.khedu.fitroutine.post.model.dto;

import jakarta.annotation.Nullable;
import lombok.Data;
import java.sql.Date;

@Data
// 컨벤션에 맞추려 했으나 실패해서 임시로 Data 사용
public final class ReplyDetail {
    private long replyId;
    private long blogId;
    private String gender;
    private String nickname;
    private String content;
    private Date createdAt;
    private @Nullable Long parentId;
}
