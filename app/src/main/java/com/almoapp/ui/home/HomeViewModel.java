package com.almoapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.almoapp.Models.Factura;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MutableLiveData<ArrayList> getFacturaList() {
        return facturaList;
    }

    private final MutableLiveData<ArrayList> facturaList;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

        // Inicializar la lista de facturas
        facturaList = new MutableLiveData<>();

        ArrayList<Factura> facturaListtmp = new ArrayList<>();
        facturaListtmp.add(new Factura("Factura #23892", "Descripcion: esto es una descripcion de factura", "Q2,003.55", "Estado: Anulada"));
        facturaListtmp.add(new Factura("Factura #29876", "Descripcion: esto es una descripcion de factura", "Q23,589.55", "Estado: Emitida"));
        facturaListtmp.add(new Factura("Factura #20918", "Descripcion: esto es una descripcion de factura", "Q9,123.55", "Estado: Anulada"));

        facturaList.setValue(facturaListtmp);
        // Añade más items a la lista según sea necesario
    }

    public LiveData<String> getText() {
        return mText;
    }
}