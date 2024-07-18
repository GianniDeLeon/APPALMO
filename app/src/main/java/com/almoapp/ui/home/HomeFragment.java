package com.almoapp.ui.home;

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
import com.almoapp.databinding.FragmentHomeBinding;
import com.almoapp.ui.home.Adapter.FacturaAdapter;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;
    private FacturaAdapter facturaAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = binding.recyclerViewFacturas;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        facturaAdapter = new FacturaAdapter(homeViewModel.getFacturaList().getValue());
        recyclerView.setAdapter(facturaAdapter);

        Button buttonNuevaFactura = binding.buttonNuevaFactura;
        buttonNuevaFactura.setOnClickListener( v -> goToSeleccionCliente(v) );

        return root;
    }

    private void goToSeleccionCliente(View v){
        NavController navController = Navigation.findNavController(v);
        navController.navigate(R.id.action_nav_facturas_to_seleccionCliente);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}