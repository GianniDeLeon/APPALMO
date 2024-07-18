package com.almoapp.ui.gallery;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.almoapp.Models.Cliente;
import com.almoapp.localDB.Controller.ClientController;

import java.util.ArrayList;

public class GalleryViewModel extends ViewModel {


    private ClientController clientController;

    public void setContext(Context context) {
        this.context = context;
    }

    private Context context;

    public MutableLiveData<ArrayList<Cliente>> getClienteList() {
        clientController = new ClientController(context);
        clienteList.setValue(clientController.getAllClientes());
        return clienteList;
    }

    private final MutableLiveData<ArrayList<Cliente>> clienteList;

    public GalleryViewModel() {
        clienteList = new MutableLiveData<>();
    }

}