package youtube.light.youtube.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import youtube.light.youtube.model.VideoMetadata;
/**
 * VideoRepository
 */
public interface VideoRepository extends MongoRepository<VideoMetadata, String> {

    
}