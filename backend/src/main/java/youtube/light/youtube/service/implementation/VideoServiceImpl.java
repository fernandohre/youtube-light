package youtube.light.youtube.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import youtube.light.youtube.model.dto.VideoMetadataDto;
import youtube.light.youtube.service.VideoService;
@Service
public class VideoServiceImpl implements VideoService {

    @Override
    public List<VideoMetadataDto> getAllVideos() {
        List<VideoMetadataDto> list = new ArrayList<VideoMetadataDto>();
        list.add(new VideoMetadataDto("https://www.youtube.com/watch?v=liKqqPUXYEY", 
                                      "https://i.ytimg.com/vi/P92SBaN42mQ/hqdefault.jpg?sqp=-oaymwEbCKgBEF5IVfKriqkDDggBFQAAiEIYAXABwAEG&amp;rs=AOn4CLAyoH__f2nFMZk0xBu6HCHTSyu80w", 
                                      "Arquitetura de Software - Passo a passo"));
        return list;
    }

    @Override
    public VideoMetadataDto getVideo(String id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
