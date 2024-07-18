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
import com.almoapp.localDB.Controller.ClientController;
import com.almoapp.ui.gallery.Adapter.ClienteAdapter;

import java.util.ArrayList;

public class SeleccionCliente extends Fragment {

    ClientController clientController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seleccion_cliente, container, false);
        clientController = new ClientController(getContext());
        RecyclerView recyclerViewSeleccionCliente = view.findViewById(R.id.recyclerViewSeleccionCliente);
        ClienteAdapter clienteAdapter = new ClienteAdapter(clientController.getAllClientes(),true);
        recyclerViewSeleccionCliente.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewSeleccionCliente.setAdapter(clienteAdapter);
        return view;
    }
}