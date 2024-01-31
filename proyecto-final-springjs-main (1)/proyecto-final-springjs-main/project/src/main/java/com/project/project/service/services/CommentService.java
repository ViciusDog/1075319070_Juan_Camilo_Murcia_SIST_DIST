package com.project.project.service.services;

import com.project.project.model.Comment;
import com.project.project.service.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public void addUpdate(Comment comment) {
        commentRepository.save(comment);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Comment findById(Integer id) {
        Optional<Comment> user = commentRepository.findById(id);
        return user.orElse(null);
    }

    public void deleteById(Integer id) {
        commentRepository.deleteById(id);
    }
}
