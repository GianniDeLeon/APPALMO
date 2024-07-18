package com.almoapp.ui.home.CrearFactura;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.almoapp.Models.Producto;
import com.almoapp.R;
import com.almoapp.ui.home.CrearFactura.Adapter.SeleccionProductoAdapter;

import java.util.ArrayList;
import java.util.List;

public class SeleccionProductos extends Fragment {
    private SeleccionProductoAdapter productoAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seleccion_productos, container, false);
        RecyclerView recyclerViewSeleccionProducto = view.findViewById(R.id.recyclerViewSeleccionProducto);
        Button buttonSiguiente = view.findViewById(R.id.buttonSiguiente);
        buttonSiguiente.setOnClickListener(v -> recorrerListaProducto());

        recyclerViewSeleccionProducto.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Producto> productoList;
        productoList = new ArrayList<>();
        productoList.add(new Producto("MacBook Pro M1 16\"", "Procesador M1 Pro, 16GB de RAM, 32 nucleos de alto rendimiento, 32 nucleos de procesamiento grafico", 29990.99));
        productoAdapter = new SeleccionProductoAdapter(productoList);
        recyclerViewSeleccionProducto.setAdapter(productoAdapter);
        return view;
    }

    private void recorrerListaProducto(){
        for (int i = 0; i < productoAdapter.getItemCount(); i++) {
            int contador = productoAdapter.getContadorProducto(i);
            Producto producto = productoAdapter.getProducto(i);
            // Aquí puedes usar el contador y el producto como necesites
            System.out.println("Producto: " + producto.getNombre() + ", cantidad de productos: " + contador + ", costo unitario "+ producto.getMonto() + ", costo total" + (producto.getMonto() * contador));
        }
    }
}