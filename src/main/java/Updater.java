import com.google.api.services.sheets.v4.Sheets;
import services.GSheets;
import services.GoogleApiFactory;

public class Updater {

    GoogleApiFactory factory;

    String serviceJsonKeyFilePath;

    public Updater(String givenServiceJsonKeyFilePath) throws Exception {
        this.factory = GoogleApiFactory.configureWithJsonKey(givenServiceJsonKeyFilePath);
        this.serviceJsonKeyFilePath = givenServiceJsonKeyFilePath;
    }

    public GSheets getSheetsService() throws Exception {
        return factory.getInstance(GSheets.class);
    }
}
