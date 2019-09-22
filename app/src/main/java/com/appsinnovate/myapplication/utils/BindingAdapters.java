package com.appsinnovate.myapplication.utils;

import android.util.Log;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appsinnovate.myapplication.adapter.HomeAdapter;
import com.appsinnovate.myapplication.model.pack.CountriesItem;

import java.util.List;

public class BindingAdapters {
    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView view, List<CountriesItem> data) {
        GridLayoutManager manager = new GridLayoutManager(view.getContext(), 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (data.get(position).getId() == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        Log.e("test", "bindingAdapter");
        view.setLayoutManager(manager);
        view.setAdapter(new HomeAdapter(data, view.getContext()));
    }
}


