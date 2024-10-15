package co.allura.controller;

import co.allura.model.CurrencyDAO;
import co.allura.model.CurrencyRecord;
import co.allura.view.View;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CurrencyDAO currencyDAO = new CurrencyDAO();
        View view = new View();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        int opcion = -1;
        while (opcion != 0) {
            view.print("Digite quiere hacer  1. CONVERTIR  2. VERIFICAR  0. SALIR");
            opcion = view.readInt();

            switch (opcion) {
                case 2: {
                    ArrayList<Double> list = new ArrayList<>();
                    list = (ArrayList<Double>) currencyDAO.getListaMonedas();
                    view.printList(list);
                    break;
                }
                case 1: {
                    view.printMessage();
                    view.print("Ingrese su moneda base ");
                    String base = view.readLine().toUpperCase();
                    view.print("Ingrese su moneda deseada ");
                    String target = view.readLine().toUpperCase();
                    double quantity = 0;
                    boolean valido = false;

                    while (!valido) {
                        view.print("Ingrese el valor de la que desea convertir ");
                        quantity = view.readDouble();

                        if (quantity > 0) {
                            valido = true;
                        } else {
                            view.print("Ingrese un número mayor a 0");
                        }
                    }

                    try {
                        double convertido = currencyDAO.convert(base, target, quantity);
                        view.print("Ahora tienes " + target + " " + convertido);
                    } catch (RuntimeException e) {
                        view.print("OCURRIÓ UN ERROR, VUELVE MÁS TARDE");
                    }
                    break;
                }
                case 0: {
                    break;
                }
            }
        }
    }
}