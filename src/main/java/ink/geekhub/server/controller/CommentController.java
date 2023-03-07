package ink.geekhub.server.controller;

import ink.geekhub.server.service.ICommentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linghua
 */
@RestController
@RequestMapping("/api")
public class CommentController {

    private ICommentService commentService;
}
