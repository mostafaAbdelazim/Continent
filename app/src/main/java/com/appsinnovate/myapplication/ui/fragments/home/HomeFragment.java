package com.appsinnovate.myapplication.ui.fragments.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import com.appsinnovate.myapplication.R;
import com.appsinnovate.myapplication.adapter.HomeAdapter;
import com.appsinnovate.myapplication.databinding.HomeFragmentBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        HomeFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false);
        binding.setHomeViewModel(mViewModel);
        binding.setLifecycleOwner(this);

        mViewModel.liveCountries.observe(getViewLifecycleOwner(), countriesItems -> {
            if (countriesItems != null) {
                GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
                manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        if (countriesItems.get(position).getId() == 0) {
                            return 2;
                        } else {
                            return 1;
                        }
                    }
                });
                Log.e("test", "bindingAdapter");
                binding.recyclerView.setLayoutManager(manager);
                binding.recyclerView.setAdapter(new HomeAdapter(countriesItems, getContext()));
            }
        });
        return binding.getRoot();
    }
}
