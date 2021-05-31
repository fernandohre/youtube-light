package youtube.light.youtube.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // todos os vídeos no sistema. 
    @GetMapping("/findAllVideos")
    public ResponseEntity<List<VideoMetadataDto>> getAllVideos() {
        try{

            List<VideoMetadataDto> videos = new ArrayList<VideoMetadataDto>();

            videos = this.videoService.getAllVideos();

            if( videos.isEmpty() ){

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            }

            return new ResponseEntity<>(videos, HttpStatus.OK);

        } catch (Exception e) {

            //TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            
        }

       
    }

    // todos os vídeos do usuário. 
    // TODO
    @GetMapping("/findAllVideos/{userId}")
    public ResponseEntity<List<VideoMetadataDto>> getVideosByUser(@PathVariable String userId) {
        // TODO
        try{

            List<VideoMetadataDto> videos = new ArrayList<VideoMetadataDto>();

            videos = this.videoService.getAllVideosByUserId(userId);

            if( videos.isEmpty() ){

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            }

            return new ResponseEntity<>(videos, HttpStatus.OK);

        } catch (Exception e) {

            //TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    }

    // determinado vídeo.
    // TODO
    @GetMapping("/findVideo/{id}")
    public ResponseEntity<VideoMetadataDto> getVideo(@PathVariable String id) {

        try {

            VideoMetadataDto video = this.videoService.getVideo(id);

            if ( video == null ) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(video, HttpStatus.OK);
            }
            
        } catch (Exception e) {

            //TODO: handle exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    // TODO
    @DeleteMapping("/deleteVideo/{id}")
    public ResponseEntity<Object> Video(@PathVariable String id) {
        return ResponseEntity.ok(this.videoService.getVideo(id));
    }

    @PostMapping("/upload")
    public ResponseEntity<Object> uploadVideo(@RequestParam("file") MultipartFile file, 
                                              @RequestParam("description") String description) {
        //TODO: pegar o arquivo e passar para o service
        //No service ele deve gerar o id do video, e os metadados
        // o mongodb já gera um id automaticamente ao inserir no banco.
        return ResponseEntity.ok(new Object() {
            public final boolean success = true;
            public final String videoName = description;
        });
    }
}
