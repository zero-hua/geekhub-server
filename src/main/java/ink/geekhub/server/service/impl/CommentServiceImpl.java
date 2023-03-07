package ink.geekhub.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ink.geekhub.server.entity.Comment;
import ink.geekhub.server.mapper.CommentMapper;
import ink.geekhub.server.service.ICommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {
}
