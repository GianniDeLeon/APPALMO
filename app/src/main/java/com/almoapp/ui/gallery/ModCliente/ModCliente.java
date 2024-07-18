package com.almoapp.ui.gallery.ModCliente;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.almoapp.Models.Cliente;
import com.almoapp.R;
import com.almoapp.localDB.Controller.ClientController;

public class ModCliente extends Fragment {
    private EditText editTextTextNombreCliente,editTextDireccionCliente,editTextNumberNit;
    private Button buttonEliminarCliente, buttonGuardarCliente;
    ClientController clientController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mod_cliente, container, false);

        clientController = new ClientController(getContext());

        buttonEliminarCliente = view.findViewById(R.id.buttonEliminarCliente);
        buttonGuardarCliente = view.findViewById(R.id.buttonGuardarCliente);
        editTextTextNombreCliente = view.findViewById(R.id.editTextTextNombreCliente);
        editTextDireccionCliente = view.findViewById(R.id.editTextDireccionCliente);
        editTextNumberNit = view.findViewById(R.id.editTextNumberNit);
        if(getArguments() != null){
            Cliente cliente = getArguments().getParcelable("cliente");

            editTextTextNombreCliente.setText(cliente.getNombre());
            editTextDireccionCliente.setText(cliente.getDireccion());
            editTextNumberNit.setText(cliente.getNit());
            editTextNumberNit.setInputType(InputType.TYPE_NULL);
            editTextNumberNit.setFocusable(false);
            editTextNumberNit.setFocusableInTouchMode(false);
            editTextNumberNit.setClickable(false);
            editTextNumberNit.setCursorVisible(false);

            buttonGuardarCliente.setOnClickListener(v -> actualizarCliente(cliente,v));
            buttonEliminarCliente.setOnClickListener(v -> eliminarCliente(cliente,v));

        }else {
            buttonEliminarCliente.setVisibility(View.GONE);
            buttonGuardarCliente.setOnClickListener(v -> nuevoCliente(v));
        }
        return view;
    }

    private void eliminarCliente(Cliente cliente,View v){
        clientController.deleteCliente(Integer.parseInt(cliente.getNit()));
        goToListaClientes(v);
    }

    private void nuevoCliente(View v){
        Cliente cliente = validarDatos();
        if (cliente != null){
            clientController.insertCliente(Integer.parseInt(cliente.getNit()),cliente.getNombre(),cliente.getDireccion());
            goToListaClientes(v);
        }
    }

    private Cliente validarDatos(){
        if (editTextDireccionCliente.getText().toString().isEmpty()){
            Toast.makeText(getContext(),"La direccion no puede estar vacia",Toast.LENGTH_SHORT).show();
            return null;
        }
        if (editTextTextNombreCliente.getText().toString().isEmpty()){
            Toast.makeText(getContext(),"El nombre no puede estar vacio",Toast.LENGTH_SHORT).show();
            return null;
        }
        if (editTextNumberNit.getText().toString().isEmpty()){
            Toast.makeText(getContext(),"El NIT no puede estar vacio",Toast.LENGTH_SHORT).show();
            return null;
        }
        return new Cliente(editTextTextNombreCliente.getText().toString(),editTextNumberNit.getText().toString(),editTextDireccionCliente.getText().toString());
    }

    private void actualizarCliente(Cliente cliente,View v){
        cliente = validarDatos(cliente);
        if (cliente != null){
            clientController.updateCliente(Integer.parseInt(cliente.getNit()),cliente.getNombre(),cliente.getDireccion());
            goToListaClientes(v);
        }
    }

    private Cliente validarDatos(Cliente cliente) {
        if (editTextDireccionCliente.getText().toString().isEmpty()){
            Toast.makeText(getContext(),"La direccion no puede estar vacia",Toast.LENGTH_SHORT).show();
            return null;
        }
        if (editTextTextNombreCliente.getText().toString().isEmpty()){
            Toast.makeText(getContext(),"El nombre no puede estar vacio",Toast.LENGTH_SHORT).show();
            return null;
        }
        cliente.setNombre(editTextTextNombreCliente.getText().toString());
        cliente.setDireccion(editTextDireccionCliente.getText().toString());
        return cliente;
    }

    private void goToListaClientes(View v){
        NavController navController = Navigation.findNavController(v);
        navController.navigate(R.id.action_modCliente_to_nav_clientes);
    }
}