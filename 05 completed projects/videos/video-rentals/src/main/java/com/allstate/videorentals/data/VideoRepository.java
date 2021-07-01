package com.allstate.videorentals.data;

import com.allstate.videorentals.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video,Integer> {

    public List<Video> findAllByGenre(String genre);
    public List<Video> findAllByGenreAndTitle(String genre, String title);

}
