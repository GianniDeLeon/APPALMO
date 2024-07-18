package com.almoapp.ui.slideshow.ModProducto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.almoapp.Models.Cliente;
import com.almoapp.Models.Producto;
import com.almoapp.R;
import com.almoapp.localDB.Controller.ProductoController;

public class ModProducto extends Fragment {

    private Producto producto;
    private EditText editTextTextNombreProducto, editTextDescripcionProducto, editTextNumberDecimalMontoProducto;
    private Button buttonEliminarProducto, buttonGuardarProducto;
    private ProductoController productoController;
    public ModProducto(Producto producto){
        this.producto = producto;
    }

    public ModProducto(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mod_producto, container, false);
        productoController = new ProductoController(getContext());
        editTextTextNombreProducto = view.findViewById(R.id.editTextTextNombreProducto);
        editTextDescripcionProducto = view.findViewById(R.id.editTextDescripcionProducto);
        editTextNumberDecimalMontoProducto = view.findViewById(R.id.editTextNumberDecimalMontoProducto);
        buttonGuardarProducto = view.findViewById(R.id.buttonGuardarProducto);
        buttonEliminarProducto = view.findViewById(R.id.buttonEliminarProducto);

        if (getArguments() != null) {
            this.producto = getArguments().getParcelable("producto");
            editTextTextNombreProducto.setText(producto.getNombre());
            editTextDescripcionProducto.setText(producto.getDescripcion());
            editTextNumberDecimalMontoProducto.setText(producto.getMonto());

            buttonGuardarProducto.setOnClickListener(v -> actualizarProducto(producto,v));
            buttonEliminarProducto.setOnClickListener(v -> eliminarCliente(producto,v));
        }else{
            buttonEliminarProducto.setVisibility(View.GONE);
            buttonGuardarProducto.setOnClickListener(v -> nuevoProducto(v));
        }
        return view;
    }

    private void eliminarCliente(Producto producto,View v){
        productoController.deleteProducto(producto.getSku());
        goToListaProductos(v);
    }

    private void nuevoProducto(View v){
        Producto producto = validarDatos();
        if (producto != null){
            productoController.insertProducto(producto.getNombre(),producto.getDescripcion(),Double.parseDouble(producto.getMonto()));
            goToListaProductos(v);
        }
    }

    private void actualizarProducto(Producto producto, View v){
        producto = validarDatos(producto);
        if (producto != null){
            productoController.updateProducto(producto.getSku(),producto.getNombre(),producto.getDescripcion(),Double.parseDouble(producto.getMonto()));
            goToListaProductos(v);
        }
    }

    private Producto validarDatos(Producto producto){
        if (editTextDescripcionProducto.getText().toString().isEmpty()){
            Toast.makeText(getContext(),"La descripcion no puede estar vacia",Toast.LENGTH_SHORT).show();
            return null;
        }
        if (editTextTextNombreProducto.getText().toString().isEmpty()){
            Toast.makeText(getContext(),"El nombre no puede estar vacio",Toast.LENGTH_SHORT).show();
            return null;
        }
        if (editTextNumberDecimalMontoProducto.getText().toString().isEmpty()){
            Toast.makeText(getContext(),"El monto no puede estar vacio",Toast.LENGTH_SHORT).show();
            return null;
        }
        producto.setNombre(editTextTextNombreProducto.getText().toString());
        producto.setDescripcion(editTextDescripcionProducto.getText().toString());
        producto.setMonto(editTextNumberDecimalMontoProducto.getText().toString());
        return producto;
    }

    private Producto validarDatos(){
        if (editTextDescripcionProducto.getText().toString().isEmpty()){
            Toast.makeText(getContext(),"La descripcion no puede estar vacia",Toast.LENGTH_SHORT).show();
            return null;
        }
        if (editTextTextNombreProducto.getText().toString().isEmpty()){
            Toast.makeText(getContext(),"El nombre no puede estar vacio",Toast.LENGTH_SHORT).show();
            return null;
        }
        if (editTextNumberDecimalMontoProducto.getText().toString().isEmpty()){
            Toast.makeText(getContext(),"El monto no puede estar vacio",Toast.LENGTH_SHORT).show();
            return null;
        }
        return new Producto(editTextTextNombreProducto.getText().toString(),editTextDescripcionProducto.getText().toString(),editTextNumberDecimalMontoProducto.getText().toString());
    }

    private void goToListaProductos(View v){
        NavController navController = Navigation.findNavController(v);
        navController.navigate(R.id.action_modProducto_to_nav_productos);
    }
}