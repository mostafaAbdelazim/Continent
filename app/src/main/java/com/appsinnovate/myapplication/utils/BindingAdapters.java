package com.appsinnovate.myapplication.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.appsinnovate.myapplication.R;
import com.appsinnovate.myapplication.adapter.DetailsAdapter;
import com.appsinnovate.myapplication.adapter.HomeAdapter;
import com.appsinnovate.myapplication.model.get_continent_byId.Country;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class BindingAdapters {
    @BindingAdapter("listData")
    public static void listData(RecyclerView view, List<Country> data) {
        if (data != null) {
            GridLayoutManager manager = (GridLayoutManager) view.getLayoutManager();
            HomeAdapter adapter = (HomeAdapter) view.getAdapter();
            view.setHasFixedSize(true);
            if (manager != null) {
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
            }
            if (adapter != null) {
                adapter.submitList(data);
            }
        }
    }

    @BindingAdapter("horizontalList")
    public static void setHorizontalData(RecyclerView view, List<String> data) {
        if (data != null) {
            LinearLayoutManager manager = new LinearLayoutManager(view.getContext(), RecyclerView.HORIZONTAL, false);
            view.setLayoutManager(manager);
            view.setHasFixedSize(true);
            view.setAdapter(new DetailsAdapter(data));
        }
    }

    @BindingAdapter("imageURL")
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.ic_default)
                        .error(R.drawable.ic_broken_image))
                .into(imageView);
    }
}