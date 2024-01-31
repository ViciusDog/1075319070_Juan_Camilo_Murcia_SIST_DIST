package com.project.project.controller;

import com.project.project.model.Comment;
import com.project.project.service.services.CommentService;
import com.project.project.service.services.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person-data/records")
@CrossOrigin("*")
public class CommentController {

    @Autowired CommentService commentService;
    @Autowired
    RegistroService registroService;

    @PostMapping("/{record_id}/create")
    private void create(@PathVariable Integer record_id, @RequestBody Comment comment) {
        comment.setRecord(registroService.findById(record_id));
        commentService.addUpdate(comment);
    }


}
