package com.example.useofretrofit;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useofretrofit.databinding.AdapterBinding;

public class Holder extends RecyclerView.ViewHolder {

    private AdapterBinding adapterBinding;

    public Holder(@NonNull AdapterBinding binding) {
        super(binding.getRoot());
        this.adapterBinding = binding;
    }

    public AdapterBinding getAdapterBinding(){
        return adapterBinding;
    }
}
