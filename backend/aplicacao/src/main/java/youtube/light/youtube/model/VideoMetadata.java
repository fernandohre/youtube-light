package youtube.light.youtube.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * VideoMetadata
 */
@Document(collection = "VideoMetada")
public class VideoMetadata {
    @Id
    private String id;
    private String description;
    private String linkThumbnail;
    private String linkDownload;
    private String userId;
    
    @PersistenceConstructor
    public VideoMetadata(String id, String linkDownload, String linkThumbnail, String description, String userId) {

        this.id = id;

        this.description = description;

        this.linkDownload = linkDownload;

        this.linkThumbnail = linkThumbnail;

        this.userId = userId;
    }

    public VideoMetadata(String linkDownload, String linkThumbnail, String description, String userId) {
        this.description = description;

        this.linkDownload = linkDownload;

        this.linkThumbnail = linkThumbnail;

        this.userId = userId;
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