package com.allstate.videorentals.service;

import com.allstate.videorentals.domain.Comment;
import com.allstate.videorentals.domain.Video;

import java.util.List;

public interface VideoService {

    public List<Video> getAllVideos();
    public Video getById(Integer filmId);
    public List<Video> getByGenre(String genre);
    public Integer addFilm(Video video);
    public void addComment(Integer filmId, Comment newComment);

}
