package youtube.light.youtube.service.implementation;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.InputStreamEditor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import youtube.light.youtube.model.VideoMetadata;
import youtube.light.youtube.model.dto.VideoMetadataDto;
import youtube.light.youtube.repository.VideoRepository;
import youtube.light.youtube.service.BlobService;
import youtube.light.youtube.service.VideoService;
@Service
public class VideoServiceImpl implements VideoService {
    private static String endpointEncoderStoreVideo = "http://localhost:1010/storeVideo";
    @Autowired
    VideoRepository videoRepository;

    @Autowired
    BlobService blobService;

    @Override
    public List<VideoMetadataDto> getAllVideos() {
  
        List<VideoMetadata> list = new ArrayList<VideoMetadata>();
        
        videoRepository.findAll().forEach(list::add);

        return VideoMetadataDto.converter(list);
    }

    @Override
    public VideoMetadataDto getVideo(String id) {

        Optional<VideoMetadata> video = videoRepository.findById(id);
        if( video.isPresent() ) {
            return new VideoMetadataDto(video.get());
        }
        return null;
    }

    @Override
    public VideoMetadataDto uploadVideo(MultipartFile file, String description) {
        InputStream streamVideo = null;
        try {
            streamVideo = file.getInputStream();
            HttpRequest request = HttpRequest.newBuilder()
                                             .uri(new URI(endpointEncoderStoreVideo))
                                             .POST(BodyPublishers.ofByteArray(file.getBytes())).build();
            
            HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            blobService.storeFile(file.getName(), streamVideo, file.getSize());
        }
        return null;
    }
    
}
