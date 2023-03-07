package ink.geekhub.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import ink.geekhub.server.entity.Article;

/**
 * @author linghua
 */
public interface IArticleService extends IService<Article> {

    /**
     * @param page
     * @return
     */
    IPage<Article> selectNewArticle(Page<Article> page);
}
