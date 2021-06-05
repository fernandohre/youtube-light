package youtube.light.youtube.configuration;

public class AzureBlobProperties {
    private String connectionstring = "UseDevelopmentStorage=true;";
    private String container = "videos";

    public String getConnectionstring() {
        return connectionstring;
    }
    public String getContainer() {
        return container;
    }
}