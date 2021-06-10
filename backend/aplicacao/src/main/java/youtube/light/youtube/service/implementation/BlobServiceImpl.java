package youtube.light.youtube.service.implementation;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import youtube.light.youtube.configuration.AzureBlobProperties;
import youtube.light.youtube.service.BlobService;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlobServiceImpl implements BlobService {

    private final AzureBlobProperties azureBlobProperties = new AzureBlobProperties();
    
    private BlobContainerClient containerClient() {
        BlobServiceClient serviceClient = new BlobServiceClientBuilder()
                .connectionString(azureBlobProperties.getConnectionstring()).buildClient();
        BlobContainerClient container = serviceClient.getBlobContainerClient(azureBlobProperties.getContainer());

        if (!container.exists()) container.create();

        return container;
    }

    @Override
    public ByteArrayOutputStream downloadFile(String blobitem) {
        BlobContainerClient containerClient = containerClient();
        BlobClient blobClient = containerClient.getBlobClient(blobitem);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        blobClient.download(os);
        return os;
    }

    @Override
    public String storeFile(String filename, InputStream content, long length) {
        
        BlobClient client = containerClient().getBlobClient(filename);
        String urlVideo = client.getBlobUrl();

        client.upload(content, length, true);

        return urlVideo;
    }
    
}
