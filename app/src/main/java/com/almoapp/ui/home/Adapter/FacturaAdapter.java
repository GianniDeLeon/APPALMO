package com.almoapp.ui.home.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.almoapp.Models.Factura;
import com.almoapp.R;

import java.util.List;

public class FacturaAdapter extends RecyclerView.Adapter<FacturaAdapter.FacturaViewHolder>{

    private List<Factura> facturaList;

    public FacturaAdapter(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }
    @NonNull
    @Override
    public FacturaAdapter.FacturaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_factura, parent, false);
        return new FacturaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FacturaAdapter.FacturaViewHolder holder, int position) {
        Factura factura = facturaList.get(position);
        holder.textViewNoFactura.setText("Numero de factura: "+factura.getNoFactura());
        holder.textViewDescripcion.setText("Descripcion: "+factura.getDescripcion());
        holder.textViewMonto.setText("Monto total: "+factura.getMonto());
        String estado = (factura.getEstado().equals("1")) ? "Emitida" : "Anulada";
        holder.textViewEstado.setText(estado);
    }

    @Override
    public int getItemCount() {
        return facturaList.size();
    }

    public static class FacturaViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNoFactura, textViewDescripcion, textViewMonto, textViewEstado;

        public FacturaViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNoFactura = itemView.findViewById(R.id.textViewNoFactura);
            textViewDescripcion = itemView.findViewById(R.id.textViewDescripcion);
            textViewMonto = itemView.findViewById(R.id.textViewMonto);
            textViewEstado = itemView.findViewById(R.id.textView4);
        }
    }
}
