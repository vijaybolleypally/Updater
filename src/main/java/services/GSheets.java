package services;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GSheets extends AbstractGAppService {

    Sheets googleSheets;

    @Override
    public AbstractGoogleJsonClient getService() throws Exception {
        Credential credential = authorize();
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(getApplicationName())
                .build();
    }

    @Override
    public List<String> getScopes() {
        return new ArrayList<>(SheetsScopes.all());
    }

    public GSheets(File jsonKeyFile) throws Exception {
        setJsonKeyFile(jsonKeyFile);
        googleSheets = (Sheets) getService();
    }

    public List<List<Object>> getSheetData(String spreadsheetId, String range) throws IOException {

        ValueRange response = googleSheets.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            System.out.println("No data found.");
        } else {
            System.out.println("DATA :" + values.toString());
        }
        return response.getValues();
    }

    public void setSheetData(String spreadsheetId, String range, List<List<Object>> inputWrite) throws IOException {
        ValueRange body = new ValueRange()
                .setValues(inputWrite);
        UpdateValuesResponse result =
                googleSheets.spreadsheets().values().update(spreadsheetId, range, body)
                        .setValueInputOption("RAW")
                        .execute();
        System.out.printf("%d cells updated.", result.getUpdatedCells());
    }
}
