package pl.nicieja.aop.service;


import org.springframework.stereotype.Service;
import pl.nicieja.aop.aspect.MailingAspect;
import pl.nicieja.aop.model.Video;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    List<Video> videoList;

    public VideoService() {
        createListOfVideos();
    }

    public List<Video> getAllVideos() {
        return this.videoList;
    }

    @MailingAspect
    public Boolean addVideo(Video video) {
        return this.videoList.add(video);
    }

    private void createListOfVideos() {
        this.videoList = new ArrayList<>();
        videoList.add(new Video(1L, "Break", "producer 1", 2020L));
        videoList.add(new Video(2L, "Return", "producer 2", 2010L));
        videoList.add(new Video(3L, "Escape", "producer 3", 2020L));
    }
}
