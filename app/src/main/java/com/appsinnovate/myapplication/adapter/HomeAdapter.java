package com.appsinnovate.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.appsinnovate.myapplication.databinding.CellBinding;
import com.appsinnovate.myapplication.databinding.ContinentLayoutBinding;
import com.appsinnovate.myapplication.model.pack.CountriesItem;

public class HomeAdapter extends ListAdapter<CountriesItem, RecyclerView.ViewHolder> {
    private static final DiffUtil.ItemCallback<CountriesItem> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<CountriesItem>() {
                @Override
                public boolean areItemsTheSame(
                        @NonNull CountriesItem oldCountry, @NonNull CountriesItem newCountry) {
                    return oldCountry == newCountry;
                }

                @Override
                public boolean areContentsTheSame(
                        @NonNull CountriesItem oldCountry, @NonNull CountriesItem newCountry) {
                    return oldCountry.getId() == newCountry.getId();
                }
            };
    private OnItemClickListener listener;

    public HomeAdapter(OnItemClickListener listener) {
        super(HomeAdapter.DIFF_CALLBACK);
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        if (getItem(position).getId() == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return ContinentHolder.from(parent);
        } else {
            return HomeViewHolder.from(parent);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CountriesItem country = getItem(position);
        if (holder instanceof ContinentHolder) {
            ((ContinentHolder) holder).bind(country);
        } else if (holder instanceof HomeViewHolder) {
            ((HomeViewHolder) holder).bind(country, listener);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(CountriesItem item);
    }

    static class ContinentHolder extends RecyclerView.ViewHolder {
        ContinentLayoutBinding binding;

        ContinentHolder(ContinentLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        static ContinentHolder from(ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ContinentLayoutBinding binding = ContinentLayoutBinding.inflate(inflater, parent, false);
            return new ContinentHolder(binding);

        }

        void bind(CountriesItem countriesItem) {
            binding.setContinent(countriesItem);
            binding.executePendingBindings();
        }
    }

    static class HomeViewHolder extends RecyclerView.ViewHolder {
        CellBinding binding;

        HomeViewHolder(CellBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        static HomeViewHolder from(ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            CellBinding binding = CellBinding.inflate(inflater, parent, false);
            return new HomeViewHolder(binding);
        }

        void bind(CountriesItem countriesItem, OnItemClickListener onItemClickListener) {
            binding.getRoot().setOnClickListener(v -> onItemClickListener.onItemClick(countriesItem));
            binding.setCountry(countriesItem);
            binding.executePendingBindings();
        }

    }
}


