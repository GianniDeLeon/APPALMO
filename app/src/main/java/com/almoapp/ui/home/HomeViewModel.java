package com.almoapp.ui.home;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.almoapp.Models.Factura;
import com.almoapp.localDB.Controller.FacturaController;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {


    public MutableLiveData<ArrayList> getFacturaList() {
        facturaController = new FacturaController(context);
        facturaList.setValue(facturaController.getAllFacturas());
        return facturaList;
    }

    private final MutableLiveData<ArrayList> facturaList;

    public void setContext(Context context) {
        this.context = context;
    }

    private Context context;
    private FacturaController facturaController;

    public HomeViewModel() {

        // Inicializar la lista de facturas
        facturaList = new MutableLiveData<>();
    }

}