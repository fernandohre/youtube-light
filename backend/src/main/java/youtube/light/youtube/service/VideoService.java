package youtube.light.youtube.service;

import java.util.List;

import youtube.light.youtube.model.dto.VideoMetadataDto;

public interface VideoService {
    List<VideoMetadataDto> getAllVideos();
    VideoMetadataDto getVideo(String id);
}
