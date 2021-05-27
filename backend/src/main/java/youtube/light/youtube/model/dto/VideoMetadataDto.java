package youtube.light.youtube.model.dto;

public class VideoMetadataDto {
    private String linkDownload;
    private String linkThumbnail;
    private String description;

    public VideoMetadataDto(String linkDownload, String linkThumbnail, String description) {
        this.linkDownload = linkDownload;
        this.linkThumbnail = linkThumbnail;
        this.description = description;
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
