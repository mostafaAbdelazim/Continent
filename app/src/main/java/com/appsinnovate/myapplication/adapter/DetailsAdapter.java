package com.appsinnovate.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsinnovate.myapplication.databinding.DetailCellBinding;

import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder> {
    private List<String> imageUrls;

    public DetailsAdapter(List<String> data) {
        this.imageUrls = data;
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        DetailCellBinding binding = DetailCellBinding.inflate(inflater, parent, false);
        return new DetailsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {
        holder.bind(imageUrls.get(position));
    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder {
        DetailCellBinding binding;

        public DetailsViewHolder(DetailCellBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(String imagUrl) {
            binding.setImageString(imagUrl);
            binding.executePendingBindings();
        }
    }
}
