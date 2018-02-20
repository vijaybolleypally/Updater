import services.GSheets;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {

        String path = System.getProperty("user.home") + "\\oauth2\\client_secret.json";

        Updater updater = new Updater(path);

        GSheets gSheets = updater.getSheetsService();
        List<List<Object>> writeValues = new ArrayList<>();

        List<Object> dataRow = new ArrayList<>();
        dataRow.add("C");
        dataRow.add("D");
        writeValues.add(dataRow);

        gSheets.getSheetData("1BjmK9mdaHxvUXcsvkm4GZUoiQjEnVbW13DHVZfvm7WI", "A3:B4");
        gSheets.setSheetData("1BjmK9mdaHxvUXcsvkm4GZUoiQjEnVbW13DHVZfvm7WI", "A17:B17", writeValues);

        gSheets.getSheetData("1BjmK9mdaHxvUXcsvkm4GZUoiQjEnVbW13DHVZfvm7WI", "Login!B3:B4");
        gSheets.setSheetData("1BjmK9mdaHxvUXcsvkm4GZUoiQjEnVbW13DHVZfvm7WI", "Home!A17:B17", writeValues);
    }



}
