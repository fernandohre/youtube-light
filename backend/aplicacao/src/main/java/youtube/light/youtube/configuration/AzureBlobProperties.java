package youtube.light.youtube.configuration;

public class AzureBlobProperties {
    private String connectionstring = "https://devstoreaccount1.blob.core.windows.net/;QueueEndpoint=https://devstoreaccount1.queue.core.windows.net/;FileEndpoint=https://devstoreaccount1.file.core.windows.net/;TableEndpoint=https://devstoreaccount1.table.core.windows.net/;SharedAccessSignature=sv=2019-10-10&ss=bfqt&srt=sco&sp=rwdlacupx&se=2020-06-30T18:55:51Z&st=2020-06-30T10:55:51Z&spr=https&sig=YRxcBuMbHd%2BetTTqavSjuOP1aAVwZB7HRk1TfATOXEY%3D";
    private String container = "videos";

    public String getConnectionstring() {
        return connectionstring;
    }
    public String getContainer() {
        return container;
    }
}