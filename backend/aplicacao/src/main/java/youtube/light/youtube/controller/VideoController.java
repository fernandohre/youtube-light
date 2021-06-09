package youtube.light.youtube.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import youtube.light.youtube.model.dto.VideoMetadataDto;
import youtube.light.youtube.service.VideoService;

@RestController
@RequestMapping(path = "/api/videos")
public class VideoController {
    
    private static String MessageEmptyFileVideo = "Arquivo de vídeo vazio.";
    private static String MessageEmptyDesciptionVideo = "Video sem descrição";
    private static String MessageSendedVideoUpload = "Video enviado para upload.";

    @Autowired
    private VideoService videoService;

    @GetMapping("/findAllVideos")
    public ResponseEntity<List<VideoMetadataDto>> getAllVideos() {
        try{

            List<VideoMetadataDto> videos = new ArrayList<VideoMetadataDto>();

            videos = this.videoService.getAllVideos();

            if( videos.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<List<VideoMetadataDto>>(videos, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/findVideo/{id}")
    public ResponseEntity<VideoMetadataDto> getVideo(@PathVariable String id) {

        try {
            VideoMetadataDto video = this.videoService.getVideo(id);

            if ( video == null ) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<VideoMetadataDto>(video, HttpStatus.OK);
            }
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<Object> uploadVideo(MultipartFile file, 
                                              String description) {
        if (file.isEmpty()) return GetReponse(false, MessageEmptyFileVideo);
        if (description.isBlank()) return GetReponse(false, MessageEmptyDesciptionVideo);

        try {
            this.videoService.uploadVideo(file, description);
            return GetReponse(true, MessageSendedVideoUpload);
        } catch (Exception e) {
            return GetReponse(false, e.getMessage());
        }
    }

    private ResponseEntity<Object> GetReponse(boolean successful, String msg) {
        return ResponseEntity.ok(new Object() {
            public final boolean success = successful;
            public final String message = msg;
        });
    }
}
