package ink.geekhub.server.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Calendar;

/**
 * @author linghua
 */
@Data
// indexName 索引库的名称
@Document(indexName = "geekhub_article", createIndex = true, type = "article")
public class Article {
    @Id
    @Field(type = FieldType.Long)
    private Long id;

    private Long uid;

    private String title;

    private String content;

    private Calendar createTime;

    private Integer likeCount;

    private Integer collectCount;

    private Integer commentCount;
}
