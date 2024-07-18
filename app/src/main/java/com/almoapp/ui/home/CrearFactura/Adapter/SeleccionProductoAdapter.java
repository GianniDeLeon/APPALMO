package com.almoapp.ui.home.CrearFactura.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.almoapp.Models.Producto;
import com.almoapp.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeleccionProductoAdapter extends RecyclerView.Adapter<SeleccionProductoAdapter.ProductoViewHolder> {
    private List<Producto> productoList;
    private Map<Integer, Integer> contadorMap;

    public SeleccionProductoAdapter(List<Producto> productoList) {
        this.productoList = productoList;
        contadorMap = new HashMap<>();
        for (int i = 0; i < productoList.size(); i++) {
            contadorMap.put(i, 0);  // Inicializa el contador de cada producto con 0
        }
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_seleccion_producto, parent, false);
        return new ProductoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto = productoList.get(position);
        holder.textViewNombreProducto.setText(producto.getNombre());
        holder.textViewNombreProducto.setOnClickListener(v -> upCount(holder, position));
        holder.textViewDescripcionProducto.setText(producto.getDescripcion());
        holder.textViewDescripcionProducto.setOnClickListener(v -> upCount(holder, position));
        holder.textViewMontoProducto.setText(producto.getMonto()+"");
        holder.textViewMontoProducto.setOnClickListener(v -> upCount(holder, position));
        holder.constraintLayoutDownCount.setOnClickListener(v -> downCount(holder, position));
        holder.constraintLayoutUpCount.setOnClickListener(v -> upCount(holder, position));
        holder.textViewContador.setText(String.valueOf(contadorMap.get(position)));
        setVisible(holder, contadorMap.get(position) > 0);
    }

    private void downCount(ProductoViewHolder holder, int position) {
        int count = contadorMap.get(position) - 1;
        contadorMap.put(position, count);
        holder.textViewContador.setText(String.valueOf(count));
        if (count == 1) {
            setDownImage(holder, true);
        } else if (count == 0) {
            setVisible(holder, false);
        }
    }

    private void upCount(ProductoViewHolder holder, int position) {
        int count = contadorMap.get(position) + 1;
        contadorMap.put(position, count);
        holder.textViewContador.setText(String.valueOf(count));
        if (count == 1) {
            setVisible(holder, true);
            setDownImage(holder, true);
        } else {
            setDownImage(holder, false);
        }
    }

    private void setVisible(ProductoViewHolder holder, boolean visible) {
        int valueVisible = visible ? View.VISIBLE : View.GONE;
        holder.cardViewUp.setVisibility(valueVisible);
        holder.cardViewDown.setVisibility(valueVisible);
        holder.textViewContador.setVisibility(valueVisible);
    }

    private void setDownImage(ProductoViewHolder holder, boolean trash) {
        int resource = trash ? R.drawable.baseline_delete_24 : R.drawable.baseline_keyboard_arrow_down_24;
        holder.imageViewDown.setImageResource(resource);
    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }

    public int getContadorProducto(int position) {
        return contadorMap.get(position);
    }

    public Producto getProducto(int position) {
        return productoList.get(position);
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNombreProducto, textViewDescripcionProducto, textViewMontoProducto, textViewContador;
        public ImageView imageViewUp, imageViewDown;
        public ConstraintLayout constraintLayoutUpCount, constraintLayoutDownCount;
        public CardView cardViewUp, cardViewDown;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombreProducto = itemView.findViewById(R.id.textViewNombreProducto);
            textViewDescripcionProducto = itemView.findViewById(R.id.textViewDescripcionProducto);
            textViewMontoProducto = itemView.findViewById(R.id.textViewMontoProducto);
            textViewContador = itemView.findViewById(R.id.textViewContador);
            imageViewUp = itemView.findViewById(R.id.imageView4);
            imageViewDown = itemView.findViewById(R.id.imageView5);
            constraintLayoutUpCount = itemView.findViewById(R.id.constraintLayoutUpCount);
            constraintLayoutDownCount = itemView.findViewById(R.id.constraintLayoutDownCount);
            cardViewUp = itemView.findViewById(R.id.cardViewUp);
            cardViewDown = itemView.findViewById(R.id.cardViewDown);
        }
    }
}
