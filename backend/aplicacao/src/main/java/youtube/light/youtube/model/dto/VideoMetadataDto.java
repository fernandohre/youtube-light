package youtube.light.youtube.model.dto;

import youtube.light.youtube.model.VideoMetadata;
import java.util.List;
import java.util.stream.Collectors;

public class VideoMetadataDto {
    private String linkDownload;
    private String linkThumbnail;
    private String description;
    private String userId;

    public VideoMetadataDto(String linkDownload, String linkThumbnail, String description) {
        this.linkDownload = linkDownload;
        this.linkThumbnail = linkThumbnail;
        this.description = description;
    }

    public VideoMetadataDto(String linkDownload, String linkThumbnail, String description, String userId) {
        this.linkDownload = linkDownload;
        this.linkThumbnail = linkThumbnail;
        this.description = description;
        this.userId = userId;
    }

    public VideoMetadataDto(VideoMetadata video) {

        this.linkDownload = video.getLinkDownload();

        this.linkThumbnail = video.getLinkThumbnail();

        this.description = video.getDescription();

        this.userId = video.getUserId();
    }

    public static List<VideoMetadataDto> converter(List<VideoMetadata> videos) {

        return videos.stream().map(VideoMetadataDto::new).collect(Collectors.toList());

    }

    public static VideoMetadata converter(VideoMetadataDto video) {
        return new VideoMetadata(video.getLinkDownload(), video.getLinkThumbnail(), video.getDescription(),
                video.getUserId());
    }

    public String getLinkDownload() {
        return linkDownload;
    }

    public String getDescription() {
        return description;
    }

    public String getLinkThumbnail() {
        return linkThumbnail == null ? "" : linkThumbnail;
    }

    public String getUserId() {
        return userId;
    }
}
