package com.appsinnovate.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.appsinnovate.myapplication.R;
import com.appsinnovate.myapplication.model.pack.CountriesItem;
import com.bumptech.glide.Glide;

import java.util.List;

public class HomeAdapter extends ListAdapter<CountriesItem, HomeAdapter.HomeViewHolder> {
    public HomeAdapter(List<CountriesItem> countries, Context context) {
        super(HomeAdapter.DIFF_CALLBACK);
        this.countries = countries;
        this.context = context;
    }

    private Context context;
    private List<CountriesItem> countries;
    private static final DiffUtil.ItemCallback<CountriesItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<CountriesItem>() {
                @Override
                public boolean areItemsTheSame(
                        @NonNull CountriesItem oldCountry, @NonNull CountriesItem newCountry) {
                    return oldCountry.getId() == newCountry.getId();
                }

                @Override
                public boolean areContentsTheSame(
                        @NonNull CountriesItem oldCountry, @NonNull CountriesItem newCountry) {
                    return oldCountry.equals(newCountry);
                }
            };

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Log.e("test", "homeAdapter");

        CountriesItem country = countries.get(position);
        holder.textView.setText(country.getName());
        if (country.getFlagImg() != null) {
            Glide.with(context).load(country.getFlagImg()).into(holder.imageView);
        } else {
            holder.imageView.setBackgroundColor(Color.CYAN);
        }
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.flag);
            textView = itemView.findViewById(R.id.name);
        }
    }
}