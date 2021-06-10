package youtube.light.youtube.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public interface BlobService {
    ByteArrayOutputStream  downloadFile(String blobitem);
    String storeFile(String filename, InputStream content, long length);
}
