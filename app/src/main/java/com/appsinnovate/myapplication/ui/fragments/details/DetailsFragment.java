package com.appsinnovate.myapplication.ui.fragments.details;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.appsinnovate.myapplication.R;
import com.appsinnovate.myapplication.databinding.DetailsFragmentBinding;
import com.appsinnovate.myapplication.ui.activties.MainActivity;
import com.google.android.material.appbar.AppBarLayout;

import java.util.Objects;

public class DetailsFragment extends Fragment {

    private DetailsFragmentArgs args;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        args = DetailsFragmentArgs.fromBundle(Objects.requireNonNull(getArguments()));
        DetailsViewModelFactory factory = new DetailsViewModelFactory(args.getCountryId());
        DetailsViewModel mViewModel = ViewModelProviders.of(this, factory).get(DetailsViewModel.class);
        customizeToolbar();
        DetailsFragmentBinding binding = DetailsFragmentBinding.inflate(inflater);
        binding.setDetailsViewModel(mViewModel);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    private void customizeToolbar() {
        TextView toolbarTitle = ((MainActivity) Objects.requireNonNull(getActivity())).textView;
        AppBarLayout appBarLayout = ((MainActivity) getActivity()).appbar;
        appBarLayout.setBackgroundColor(Color.WHITE);
        toolbarTitle.setText(args.getCountryName());
        toolbarTitle.setTextColor(getResources().getColor(R.color.dark_text_color));
        toolbarTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
}