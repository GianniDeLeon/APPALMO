package com.almoapp.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.almoapp.Models.Cliente;

import java.util.ArrayList;

public class GalleryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MutableLiveData<ArrayList<Cliente>> getClienteList() {
        return clienteList;
    }

    private final MutableLiveData<ArrayList<Cliente>> clienteList;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");

        // Inicializar la lista de facturas
        clienteList = new MutableLiveData<>();

        ArrayList<Cliente> clienteListTmp = new ArrayList<>();
        clienteListTmp.add(new Cliente("Gianni Artemio De Leon Chacon", "101923368", "Ciudad"));
        clienteListTmp.add(new Cliente("Kimberly Shanel Hernandez Mendez", "19281382", "Alotenango"));
        clienteListTmp.add(new Cliente("Juan Pablo Ozuna De Leon", "201503823", "Ciudad"));
        clienteListTmp.add(new Cliente("Gianni Artemio De Leon Chacon", "101923368", "Ciudad"));
        clienteListTmp.add(new Cliente("Kimberly Shanel Hernandez Mendez", "19281382", "Alotenango"));
        clienteListTmp.add(new Cliente("Juan Pablo Ozuna De Leon", "201503823", "Ciudad"));
        clienteListTmp.add(new Cliente("Gianni Artemio De Leon Chacon", "101923368", "Ciudad"));
        clienteListTmp.add(new Cliente("Kimberly Shanel Hernandez Mendez", "19281382", "Alotenango"));
        clienteListTmp.add(new Cliente("Juan Pablo Ozuna De Leon", "201503823", "Ciudad"));
        clienteListTmp.add(new Cliente("Gianni Artemio De Leon Chacon", "101923368", "Ciudad"));
        clienteListTmp.add(new Cliente("Kimberly Shanel Hernandez Mendez", "19281382", "Alotenango"));
        clienteListTmp.add(new Cliente("Juan Pablo Ozuna De Leon", "201503823", "Ciudad"));

        clienteList.setValue(clienteListTmp);

    }

    public LiveData<String> getText() {
        return mText;
    }
}