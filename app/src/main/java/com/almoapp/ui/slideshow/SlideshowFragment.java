package com.almoapp.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.almoapp.databinding.FragmentSlideshowBinding;
import com.almoapp.ui.slideshow.Adapter.ProductoAdapter;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    private ProductoAdapter productoAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerViewProductos = binding.recyclerViewProductos;
        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(getContext()));
        productoAdapter = new ProductoAdapter(slideshowViewModel.getProductoList().getValue());
        recyclerViewProductos.setAdapter(productoAdapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}