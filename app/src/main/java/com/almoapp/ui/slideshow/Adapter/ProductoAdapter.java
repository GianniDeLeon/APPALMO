package com.almoapp.ui.slideshow.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.almoapp.Models.Producto;
import com.almoapp.R;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {

    private List<Producto> productoList;

    public ProductoAdapter(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_producto, parent, false);
        return new ProductoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto = productoList.get(position);
        holder.textViewNombreProducto.setText(producto.getNombre());
        holder.textViewDescripcionProducto.setText(producto.getDescripcion());
        holder.textViewMontoProducto.setText(producto.getMonto());
    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNombreProducto, textViewDescripcionProducto, textViewMontoProducto;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombreProducto = itemView.findViewById(R.id.textViewNombreProducto);
            textViewDescripcionProducto = itemView.findViewById(R.id.textViewDescripcionProducto);
            textViewMontoProducto = itemView.findViewById(R.id.textViewMontoProducto);
        }
    }
}
