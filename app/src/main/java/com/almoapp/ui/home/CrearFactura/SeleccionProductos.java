package com.almoapp.ui.home.CrearFactura;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.almoapp.Models.Cliente;
import com.almoapp.Models.Producto;
import com.almoapp.R;
import com.almoapp.localDB.Controller.FacturaController;
import com.almoapp.localDB.Controller.ProductoController;
import com.almoapp.ui.home.CrearFactura.Adapter.SeleccionProductoAdapter;

import java.util.ArrayList;
import java.util.List;

public class SeleccionProductos extends Fragment {
    private SeleccionProductoAdapter productoAdapter;
    private Cliente cliente;
    private ProductoController productoController;
    private FacturaController facturaController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seleccion_productos, container, false);
        productoController = new ProductoController(getContext());
        facturaController = new FacturaController(getContext());

        if(getArguments() != null){
            cliente = getArguments().getParcelable("cliente");
        }

        RecyclerView recyclerViewSeleccionProducto = view.findViewById(R.id.recyclerViewSeleccionProducto);
        Button buttonSiguiente = view.findViewById(R.id.buttonSiguiente);
        buttonSiguiente.setOnClickListener(v -> recorrerListaProducto(v));

        recyclerViewSeleccionProducto.setLayoutManager(new LinearLayoutManager(getContext()));

        productoAdapter = new SeleccionProductoAdapter(productoController.getAllProductos());
        recyclerViewSeleccionProducto.setAdapter(productoAdapter);
        return view;
    }

    private void recorrerListaProducto(View v){
        double montoTotal = 0;
        String descripcion = "Cliente: " + cliente.getNombre() +
                "\nNIT: " + cliente.getNit() +
                "\nDirección: " + cliente.getDireccion() +
                "\nDetalle de la compra:";
        for (int i = 0; i < productoAdapter.getItemCount(); i++) {
            int contador = productoAdapter.getContadorProducto(i);
            if (contador >= 1){
                Producto producto = productoAdapter.getProducto(i);
                montoTotal = montoTotal + (contador * producto.getMonto());
                descripcion += "\nProducto: " + producto.getNombre() + "\nDescripción: " + producto.getDescripcion() + "\nPrecio unitario: " + producto.getMonto() + "\nUnidades vendidas: " + contador + "\nTotal: " + (producto.getMonto() * contador) ;
            }
        }
        String formattedValue = String.format("%.2f", montoTotal);
        descripcion += "\nTotal de la venta: " + formattedValue;
        System.out.println(descripcion);
        facturaController.insertFactura(descripcion,formattedValue,1);
        goToListaFacturas(v);
    }

    private void goToListaFacturas(View v){
        NavController navController = Navigation.findNavController(v);
        navController.navigate(R.id.action_seleccionProductos_to_nav_facturas);
    }
}