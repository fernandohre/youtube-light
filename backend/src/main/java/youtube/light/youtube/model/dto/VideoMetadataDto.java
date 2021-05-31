package youtube.light.youtube.model.dto;

import youtube.light.youtube.model.VideoMetadata;
import java.util.List;
import java.util.stream.Collectors;

public class VideoMetadataDto {
    private String linkDownload;
    private String linkThumbnail;
    private String description;

    public VideoMetadataDto(VideoMetadata video) {

        this.linkDownload = video.getLinkDownload();

        this.linkThumbnail = video.getLinkThumbnail();

        this.description = video.getDescription();
    }

    public static List<VideoMetadataDto> converter(List<VideoMetadata> videos) {

        return videos.stream().map(VideoMetadataDto::new).collect(Collectors.toList());

    }

    public String getLinkDownload() {

        return linkDownload;

    }
    public String getDescription() {

        return description;

    }
    public String getLinkThumbnail() {

        return linkThumbnail;
        
    }
}
