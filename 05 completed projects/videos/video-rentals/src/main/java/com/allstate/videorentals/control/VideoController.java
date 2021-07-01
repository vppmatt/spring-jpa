package com.allstate.videorentals.control;

import com.allstate.videorentals.domain.Comment;
import com.allstate.videorentals.domain.Video;
import com.allstate.videorentals.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/video")
public class VideoController {

    @Autowired
    private VideoService service;


    @GetMapping("/health")
    public String health() {
        return "ok";
    }

//    @GetMapping()
//    public List<Video> getAll() {
//        return service.getAllVideos();
//    }
//
//    @GetMapping
//    public List<Video> getByGenre(@RequestParam(value = "genre") String genre) {
//        return service.getByGenre(genre);
//    }
//

    @GetMapping()
    public List<Video> getAll(@RequestParam(value="genre", required = false) String genre) {
        if (genre != null) {
            System.out.println("running find by genre");
            return service.getByGenre(genre);
        } else {
            System.out.println("running find all");
            return service.getAllVideos();
        }
    }

    @PostMapping()
    public Integer addNewFilm(@RequestBody Video newVideo) {
        return service.addFilm(newVideo);
    }

    @GetMapping(value="/{id}")
    public Video getByFilmId(@PathVariable("id")  Integer filmId) {
        return service.getById(filmId);
    }

    @PostMapping("/{id}/comment")
    public void addComment(@PathVariable("id") Integer filmId, @RequestBody Comment newComment) {
        service.addComment(filmId, newComment);
    }

}
