package com.almoapp.ui.home.CrearFactura;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.almoapp.Models.Cliente;
import com.almoapp.R;
import com.almoapp.ui.gallery.Adapter.ClienteAdapter;

import java.util.ArrayList;

public class SeleccionCliente extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seleccion_cliente, container, false);
        RecyclerView recyclerViewSeleccionCliente = view.findViewById(R.id.recyclerViewSeleccionCliente);
        ClienteAdapter clienteAdapter = new ClienteAdapter(getClientes(),true);
        recyclerViewSeleccionCliente.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewSeleccionCliente.setAdapter(clienteAdapter);
        return view;
    }

    private ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> clienteList = new ArrayList<>();
        clienteList.add(new Cliente("Gianni Artemio De Leon Chacon", "101923368", "Ciudad"));
        clienteList.add(new Cliente("Kimberly Shanel Hernandez Mendez", "19281382", "Alotenango"));
        clienteList.add(new Cliente("Juan Pablo Ozuna De Leon", "201503823", "Ciudad"));
        clienteList.add(new Cliente("Gianni Artemio De Leon Chacon", "101923368", "Ciudad"));
        clienteList.add(new Cliente("Kimberly Shanel Hernandez Mendez", "19281382", "Alotenango"));
        clienteList.add(new Cliente("Juan Pablo Ozuna De Leon", "201503823", "Ciudad"));
        clienteList.add(new Cliente("Gianni Artemio De Leon Chacon", "101923368", "Ciudad"));
        clienteList.add(new Cliente("Kimberly Shanel Hernandez Mendez", "19281382", "Alotenango"));
        clienteList.add(new Cliente("Juan Pablo Ozuna De Leon", "201503823", "Ciudad"));
        clienteList.add(new Cliente("Gianni Artemio De Leon Chacon", "101923368", "Ciudad"));
        clienteList.add(new Cliente("Kimberly Shanel Hernandez Mendez", "19281382", "Alotenango"));
        clienteList.add(new Cliente("Juan Pablo Ozuna De Leon", "201503823", "Ciudad"));
        return clienteList;
    }
}