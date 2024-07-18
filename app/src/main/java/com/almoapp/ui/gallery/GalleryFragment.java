package com.almoapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.almoapp.databinding.FragmentGalleryBinding;
import com.almoapp.ui.gallery.Adapter.ClienteAdapter;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private ClienteAdapter clienteAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        clienteAdapter = new ClienteAdapter(galleryViewModel.getClienteList().getValue());
        RecyclerView recyclerViewClientes = binding.recyclerViewClientes;
        recyclerViewClientes.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewClientes.setAdapter(clienteAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}