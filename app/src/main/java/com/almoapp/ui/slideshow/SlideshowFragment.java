package com.almoapp.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.almoapp.R;
import com.almoapp.databinding.FragmentSlideshowBinding;
import com.almoapp.ui.slideshow.Adapter.ProductoAdapter;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    private ProductoAdapter productoAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        slideshowViewModel.setContext(getContext());

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button buttonNuevoProducto = binding.buttonNuevoProducto;
        buttonNuevoProducto.setOnClickListener(v -> goToNuevoProducto(v));

        RecyclerView recyclerViewProductos = binding.recyclerViewProductos;
        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(getContext()));
        productoAdapter = new ProductoAdapter(slideshowViewModel.getProductoList().getValue());
        recyclerViewProductos.setAdapter(productoAdapter);
        return root;
    }

    private void goToNuevoProducto(View v){
        NavController navController = Navigation.findNavController(v);
        navController.navigate(R.id.action_nav_productos_to_modProducto);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}