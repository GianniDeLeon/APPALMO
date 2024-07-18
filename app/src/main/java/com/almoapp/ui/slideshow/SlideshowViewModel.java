package com.almoapp.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.almoapp.Models.Factura;
import com.almoapp.Models.Producto;

import java.util.ArrayList;

public class SlideshowViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MutableLiveData<ArrayList> getProductoList() {
        return productoList;
    }

    private final MutableLiveData<ArrayList> productoList;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");

        // Inicializar la lista de facturas
        productoList = new MutableLiveData<>();

        ArrayList<Producto> productoListTmp = new ArrayList<>();
        productoListTmp.add(new Producto("MacBook Pro M1 16\"", "Procesador M1 Pro, 16GB de RAM, 32 núcleos de alto rendimiento, 32 núcleos de procesamiento gráfico", 29990.44));
        productoListTmp.add(new Producto("MacBook Pro M2 16\"", "Procesador M2 , 16GB de RAM, 32 núcleos de alto rendimiento, 32 núcleos de procesamiento gráfico", 39990.00));
        productoListTmp.add(new Producto("MacBook Pro M3 16\"", "Procesador M3 Pro, 16GB de RAM, 32 núcleos de alto rendimiento, 32 núcleos de procesamiento gráfico", 49990.00));
        productoListTmp.add(new Producto("MacBook Pro M4 16\"", "Procesador M4, 16GB de RAM, 32 núcleos de alto rendimiento, 32 núcleos de procesamiento gráfico", 19990.33));
        productoListTmp.add(new Producto("MacBook Pro M1 16\"", "Procesador M1 MAX, 16GB de RAM, 32 núcleos de alto rendimiento, 32 núcleos de procesamiento gráfico", 9990.04));


        productoList.setValue(productoListTmp);
        // Añade más items a la lista según sea necesario
    }

    public LiveData<String> getText() {
        return mText;
    }
}