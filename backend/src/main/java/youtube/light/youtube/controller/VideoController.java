package youtube.light.youtube.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping
    public ResponseEntity<Object> uploadVideo(@RequestParam("file") MultipartFile file, 
                                              @RequestParam("description") String description) {
        //TODO: pegar o arquivo e passar para o service
        //No service ele deve gerar o id do video, e os metadadas
        return ResponseEntity.ok(new Object() {
            public final boolean success = true;
            public final String videoName = description;
        });
    }
}
