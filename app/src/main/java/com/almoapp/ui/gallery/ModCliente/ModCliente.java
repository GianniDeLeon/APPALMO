package com.almoapp.ui.gallery.ModCliente;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.almoapp.Models.Cliente;
import com.almoapp.R;
public class ModCliente extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mod_cliente, container, false);
        if(getArguments() != null){
            Cliente cliente = getArguments().getParcelable("cliente");
            EditText editTextTextNombreCliente = view.findViewById(R.id.editTextTextNombreCliente);
            editTextTextNombreCliente.setText(cliente.getNombre());
            EditText editTextDireccionCliente = view.findViewById(R.id.editTextDireccionCliente);
            editTextDireccionCliente.setText(cliente.getDireccion());
            EditText editTextNumberNit = view.findViewById(R.id.editTextNumberNit);
            editTextNumberNit.setText(cliente.getNit());
        }
        return view;
    }
}