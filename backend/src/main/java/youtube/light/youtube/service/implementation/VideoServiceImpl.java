package youtube.light.youtube.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import youtube.light.youtube.model.VideoMetadata;
import youtube.light.youtube.model.dto.VideoMetadataDto;
import youtube.light.youtube.repository.VideoRepository;
import youtube.light.youtube.service.VideoService;
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoRepository videoRepository;

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
    public List<VideoMetadataDto> getAllVideosByUserId(String userId){
        List<VideoMetadata> list = new ArrayList<VideoMetadata>();
        
        // TODO: metho in mongodb to find video by user id.
        videoRepository.findAll().forEach(list::add);

        return VideoMetadataDto.converter(list);
    }
    
}
