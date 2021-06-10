package youtube.light.youtube.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import youtube.light.youtube.model.dto.VideoMetadataDto;

public interface VideoService {

    List<VideoMetadataDto> getAllVideos();
    VideoMetadataDto getVideo(String id);
    VideoMetadataDto uploadVideo(MultipartFile file, String description);

    byte[] download(String blobName);
}
