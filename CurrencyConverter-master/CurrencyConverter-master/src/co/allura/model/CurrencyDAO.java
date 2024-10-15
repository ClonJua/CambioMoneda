package co.allura.model;

import co.allura.model.persistence.ArchiveGenerator;

import java.util.ArrayList;
import java.util.List;

public class CurrencyDAO {

    private double currencyConverted;
    private SearchCurrency searchCurrency = new SearchCurrency();
    private List<Double> listaMonedas = new ArrayList<>();

    public CurrencyDAO() {

    }
    public double convert(String currencyBase, String target, double quantity) {
        CurrencyRecord currencyRecord = searchCurrency.currency(currencyBase, target);
        if (currencyRecord == null) {
            throw new RuntimeException("La tasa de conversión para " + target + " no fue encontrada.");
        }
        else {
            currencyConverted = quantity * currencyRecord.getConversionRate(target);
            listaMonedas.add(currencyConverted);
            ArchiveGenerator archiveGenerator = new ArchiveGenerator();
            archiveGenerator.saveJSON(currencyRecord);
            return currencyConverted;
        }
    }

    public double getCurrencyConverted() {
        return currencyConverted;
    }

    public void setCurrencyConverted(double currencyConverted) {
        this.currencyConverted = currencyConverted;
    }

    public List<Double> getListaMonedas() {
        return listaMonedas;
    }

    public void setListaMonedas(List<Double> listaMonedas) {
        this.listaMonedas = listaMonedas;
    }
}

