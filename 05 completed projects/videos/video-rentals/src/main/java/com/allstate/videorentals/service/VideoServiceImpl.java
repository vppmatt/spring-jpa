package com.allstate.videorentals.service;

import com.allstate.videorentals.data.VideoRepository;
import com.allstate.videorentals.domain.Comment;
import com.allstate.videorentals.domain.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Video getById(Integer filmId) {
        Video video = videoRepository.findById(filmId).get();
        return video;
    }

    @Override
    public List<Video> getAllVideos() {

        //TEMPORARY STEP TO CREATE SOME DATA - FOR FIRST TIME USE ONLY
//        Video video = new Video();
//        video.setTitle("Jaws");
//        video.setGenre("comedy");
//        videoRepository.save(video);
        return videoRepository.findAll();
    }

    @Override
    public List<Video> getByGenre(String genre) {
        return videoRepository.findAllByGenre(genre);
    }

    @Override
    public Integer addFilm(Video video) {
        videoRepository.save(video);
        return video.getFilmId();
    }

    @Override
    public void addComment(Integer filmId, Comment newComment) {

        Video video = videoRepository.findById(filmId).get();
        newComment.setVideo(video);
        video.getComments().add(newComment);
        videoRepository.save(video);
    }
}
