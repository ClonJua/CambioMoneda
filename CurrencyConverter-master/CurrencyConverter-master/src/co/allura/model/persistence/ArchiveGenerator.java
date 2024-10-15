package co.allura.model.persistence;

import co.allura.model.CurrencyRecord;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class ArchiveGenerator {
    public void saveJSON(CurrencyRecord currencyRecord) {
        try {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            FileWriter writer = new FileWriter((currencyRecord.base_code()+"TO"+currencyRecord.target_code()+".json"));
            writer.write(gson.toJson(currencyRecord));
            writer.close();
        }
         catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
