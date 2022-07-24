package com.example.useofretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.useofretrofit.alldata.Example;
import com.example.useofretrofit.databinding.AdapterBinding;

public class Adapter extends RecyclerView.Adapter<Holder> {

    private Example example;
    Context context;
    private AdapterBinding binding;

    public Adapter(Example example, Context context) {
        this.example = example;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = AdapterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new Holder(binding);//gorsel olusturma
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        String name = example.getData().getFirstName();
        holder.getAdapterBinding().textView.setText(name);
        String lastName = example.getData().getLastName();
        holder.getAdapterBinding().textView2.setText(lastName);

        Glide.with(context)
                .load(example.getData().getAvatar())
                .into(holder.getAdapterBinding().imageView);

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
