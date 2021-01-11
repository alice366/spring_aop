package pl.nicieja.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.nicieja.aop.model.Video;
import pl.nicieja.aop.service.VideoService;

import java.util.List;

@RestController
@RequestMapping(value = "/videos", consumes = "application/json")
public class VideoController {

    private VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping
    public List<Video> getVideos() {
        return this.videoService.getAllVideos();
    }

    @PostMapping
    public boolean addVideo(@RequestBody Video video) {
        return this.videoService.addVideo(video);
    }
}
