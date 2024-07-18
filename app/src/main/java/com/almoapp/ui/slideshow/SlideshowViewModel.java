package com.almoapp.ui.slideshow;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.almoapp.Models.Factura;
import com.almoapp.Models.Producto;
import com.almoapp.localDB.Controller.ProductoController;

import java.util.ArrayList;

public class SlideshowViewModel extends ViewModel {


    public MutableLiveData<ArrayList> getProductoList() {
        productoController = new ProductoController(this.context);
        productoList.setValue(productoController.getAllProductos());
        return productoList;
    }

    private ProductoController productoController;
    public void setContext(Context context) {
        this.context = context;
    }

    private Context context;

    private final MutableLiveData<ArrayList> productoList;

    public SlideshowViewModel() {
        productoList = new MutableLiveData<>();
    }

}