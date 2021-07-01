package com.allstate.videorentals.service;

import com.allstate.videorentals.data.CommentRepository;
import com.allstate.videorentals.data.VideoRepository;
import com.allstate.videorentals.domain.Comment;
import com.allstate.videorentals.domain.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public void saveComment(Comment comment) {

        Integer filmId = comment.getFilmId();
        Video v = videoRepository.findById(filmId).get();
        comment.setVideo(v);
        v.getComments().add(comment);
        commentRepository.save(comment);
        videoRepository.save(v);
    }
}
