package com.allstate.videorentals.control;

import com.allstate.videorentals.domain.Comment;
import com.allstate.videorentals.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping()
    public void addComment(@RequestBody Comment newComment) {
        commentService.saveComment(newComment);
    }

}
