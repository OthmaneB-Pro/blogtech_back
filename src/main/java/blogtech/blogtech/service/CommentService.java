package blogtech.blogtech.service;

import blogtech.blogtech.entity.Comment;
import blogtech.blogtech.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final ArticleService articleService;

    public void createComment(Comment comment){
        this.commentRepository.save(comment);
    }

    public List<Comment> allComment() {
        return this.commentRepository.findAll();
    }

    public void deleteComment(int id) {
        this.commentRepository.deleteById(id);
    }
}
