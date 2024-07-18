package com.almoapp.ui.gallery.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.almoapp.Models.Cliente;
import com.almoapp.R;

import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ClienteViewHolder> {

    private List<Cliente> clienteList;

    public ClienteAdapter(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @NonNull
    @Override
    public ClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cliente, parent, false); // Asegúrate de cambiar el nombre del layout también
        return new ClienteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteViewHolder holder, int position) {
        Cliente cliente = clienteList.get(position);
        holder.textViewNombre.setText(cliente.getNombre());
        holder.textViewNit.setText(cliente.getNit());
        holder.textViewDireccion.setText(cliente.getDireccion());
    }

    @Override
    public int getItemCount() {
        return clienteList.size();
    }

    public static class ClienteViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNombre, textViewNit, textViewDireccion;

        public ClienteViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
            textViewNit = itemView.findViewById(R.id.textViewNit);
            textViewDireccion = itemView.findViewById(R.id.textViewDireccion);
        }
    }
}
