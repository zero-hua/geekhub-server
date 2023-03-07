package ink.geekhub.server.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ink.geekhub.server.entity.Article;
import ink.geekhub.server.service.IArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author linghua
 */
@RestController
@RequestMapping("/api")
public class ArticleController {

    @Resource
    private IArticleService articleService;

    @PostMapping("/article")
    public Boolean saveArticle(Article article) {
        return articleService.save(article);
    }

    @GetMapping("/article/{id}")
    public Article getArticleById(@PathVariable Integer id) {
        Article article = articleService.getById(id);
        return article;
    }

    @GetMapping("/article/new")
    public List<Article> getNewArticle(int current) {
        //每页10条
        Page<Article> page = new Page<>(current, 10);
        return articleService.selectNewArticle(page).getRecords();
    }

    @PutMapping("/article")
    public Boolean updateArticle(@Valid Article article) {
        return articleService.updateById(article);
    }

    @DeleteMapping("/article/{id}")
    public Boolean deleteArticle(@PathVariable Integer id) {
        return articleService.removeById(id);
    }
}
