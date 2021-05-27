package youtube.light.youtube.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import youtube.light.youtube.model.dto.VideoMetadataDto;
import youtube.light.youtube.service.VideoService;

@RestController
@RequestMapping(path = "/api/videos")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping
    public ResponseEntity<List<VideoMetadataDto>> getAllVideos() {
        return ResponseEntity.ok(this.videoService.getAllVideos());
    }
}
