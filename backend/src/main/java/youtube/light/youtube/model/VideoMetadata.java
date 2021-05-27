package youtube.light.youtube.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * VideoMetadata
 */
@Document
public class VideoMetadata {
    @Id
    private String id;
    private String description;
    private String linkThumbnail;
    private String linkDownload;
    private String userId;

    public VideoMetadata() {
    }

    public String getId() {
        return id;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getLinkDownload() {
        return linkDownload;
    }
    public void setLinkDownload(String linkDownload) {
        this.linkDownload = linkDownload;
    }
    public String getLinkThumbnail() {
        return linkThumbnail;
    }
    public void setLinkThumbnail(String linkThumbnail) {
        this.linkThumbnail = linkThumbnail;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setId(String id) {
        this.id = id;
    }

    
}