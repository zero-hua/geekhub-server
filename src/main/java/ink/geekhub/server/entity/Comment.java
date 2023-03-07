package ink.geekhub.server.entity;

import lombok.Data;

import java.util.Calendar;

/**
 * @author linghua
 */
@Data
public class Comment {
    private Long id;

    private Long uid;

    private Long aId;

    private String content;

    private Calendar createTime;
}
