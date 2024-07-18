package com.almoapp.ui.home.ModFactura;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.almoapp.Models.Cliente;
import com.almoapp.Models.Factura;
import com.almoapp.R;
import com.almoapp.localDB.Controller.FacturaController;

public class ModFactura extends Fragment {

    private FacturaController facturaController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        facturaController = new FacturaController(getContext());

        View view = inflater.inflate(R.layout.fragment_mod_factura, container, false);
        TextView textViewNoFactura = view.findViewById(R.id.textViewNoFactura);
        TextView textViewDescripcion = view.findViewById(R.id.textViewDescripcion);
        TextView textViewMonto = view.findViewById(R.id.textViewMonto);
        TextView textViewEstado = view.findViewById(R.id.textView4);
        Button buttonAnularFactura = view.findViewById(R.id.buttonAnularFactura);


        if(getArguments() != null){
            Factura factura = getArguments().getParcelable("factura");
            textViewNoFactura.setText("Numero de Factura: "+factura.getNoFactura());
            textViewDescripcion.setText("Descripcion: "+factura.getDescripcion());
            textViewMonto.setText("Monto: "+factura.getMonto());
            String estado = (factura.getEstado().equals("1")) ? "Emitida" : "Anulada";
            textViewEstado.setText(estado);
            if (estado.equals("Anulada")){
                buttonAnularFactura.setVisibility(View.GONE);
            }else {
                buttonAnularFactura.setOnClickListener(v -> anularFactura(factura,v));
            }
        }

        return view;
    }

    private void anularFactura(Factura factura,View v){
        facturaController.updateFactura(Integer.parseInt(factura.getNoFactura()),factura.getDescripcion(),factura.getMonto(),0);
        goToListaFactura(v);
    }

    private void goToListaFactura(View v){
        NavController navController = Navigation.findNavController(v);
        navController.navigate(R.id.action_modFactura_to_nav_facturas);
    }
}