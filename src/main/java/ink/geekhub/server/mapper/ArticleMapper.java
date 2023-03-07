package ink.geekhub.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ink.geekhub.server.entity.Article;
import ink.geekhub.server.entity.User;
import org.apache.ibatis.annotations.Select;


/**
 * @author linghua
 */
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 查询最新文章
     * @param page 分页对象
     * @return 分页结果
     */
    @Select("select * from article order by id desc limit 40")
    IPage<Article> selectNewArticle(Page<Article> page);
}
