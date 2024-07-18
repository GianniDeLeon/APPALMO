package com.almoapp.ui.slideshow.ModProducto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.almoapp.Models.Producto;
import com.almoapp.R;

public class ModProducto extends Fragment {

    private Producto producto;
    private EditText editTextTextNombreProducto, editTextDescripcionProducto, editTextNumberDecimalMontoProducto;
    public ModProducto(Producto producto){
        this.producto = producto;
    }

    public ModProducto(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mod_producto, container, false);
        if (getArguments() != null) {
            this.producto = getArguments().getParcelable("producto");
            editTextTextNombreProducto = view.findViewById(R.id.editTextTextNombreProducto);
            editTextTextNombreProducto.setText(producto.getNombre());
            editTextDescripcionProducto = view.findViewById(R.id.editTextDescripcionProducto);
            editTextDescripcionProducto.setText(producto.getDescripcion());
            editTextNumberDecimalMontoProducto = view.findViewById(R.id.editTextNumberDecimalMontoProducto);
            editTextNumberDecimalMontoProducto.setText(producto.getMonto());
        }
        return view;
    }
}