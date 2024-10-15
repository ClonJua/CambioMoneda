package co.allura.model;
import java.util.Map;
public record CurrencyRecord(String result,
                             String documentation,
                             String terms_of_use,
                             long time_last_update_unix,
                             String time_last_update_utc,
                             long time_next_update_unix,
                             String time_next_update_utc,
                             String base_code,
                             String target_code,
                             double conversion_rate) {

    public double getConversionRate(String target) {
        return conversion_rate;
    }

}
