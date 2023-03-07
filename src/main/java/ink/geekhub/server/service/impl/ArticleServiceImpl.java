package ink.geekhub.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ink.geekhub.server.entity.Article;
import ink.geekhub.server.mapper.ArticleMapper;
import ink.geekhub.server.service.IArticleService;
import org.springframework.stereotype.Service;

/**
 * @author linghua
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Override
    public IPage<Article> selectNewArticle(Page<Article> page) {
        return this.baseMapper.selectNewArticle(page);
    }
}
