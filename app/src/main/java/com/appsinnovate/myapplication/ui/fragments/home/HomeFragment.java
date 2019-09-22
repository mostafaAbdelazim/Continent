package com.appsinnovate.myapplication.ui.fragments.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import com.appsinnovate.myapplication.R;
import com.appsinnovate.myapplication.adapter.HomeAdapter;
import com.appsinnovate.myapplication.databinding.HomeFragmentBinding;
import com.appsinnovate.myapplication.ui.activties.MainActivity;
import com.google.android.material.appbar.AppBarLayout;

import java.util.Objects;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        customizeToolbar();
        HomeFragmentBinding binding = HomeFragmentBinding.inflate(inflater);
        binding.setHomeViewModel(mViewModel);
        binding.setLifecycleOwner(this);
        HomeAdapter adapter = new HomeAdapter(item ->
                Navigation.findNavController(Objects.requireNonNull(getView()))
                        .navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(item.getId(), item.getName())));
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        binding.recyclerView.setLayoutManager(manager);
        binding.recyclerView.setAdapter(adapter);
        return binding.getRoot();
    }

    private void customizeToolbar() {
        TextView toolbarTitle = ((MainActivity) getActivity()).textView;
        AppBarLayout appBarLayout = ((MainActivity) getActivity()).appbar;
        appBarLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        toolbarTitle.setText(R.string.continents);
        toolbarTitle.setTextColor(Color.WHITE);
        toolbarTitle.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_earth, 0, 0);
    }
}