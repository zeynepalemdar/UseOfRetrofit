package com.example.useofretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
        //bindin add
        return new Holder(binding);//tasarım inflate dışardaki projeyi içeri aktardık
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        String name = example.getData().getFirstName();
        holder.getAdapterBinding().textView.setText(name);
        String lastName = example.getData().getLastName();
        holder.getAdapterBinding().textView2.setText(lastName);

        holder.getAdapterBinding().imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "SLM", Toast.LENGTH_SHORT).show();
            }
        });

        Glide.with(context)
                .load(example.getData().getAvatar())
                .into(holder.getAdapterBinding().imageView);

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
