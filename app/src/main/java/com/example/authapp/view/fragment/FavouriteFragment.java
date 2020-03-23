package com.example.authapp.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.authapp.R;
import com.example.authapp.databinding.FragmentFavouriteBinding;
import com.example.authapp.handler.FavouriteHandler;
import com.example.authapp.viewmodel.FavouriteViewModel;

public class FavouriteFragment extends Fragment implements FavouriteHandler {

    private FragmentFavouriteBinding fragmentFavouriteBinding;
    private FavouriteViewModel favouriteViewModel;

    public FavouriteFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentFavouriteBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_favourite,container,false);
        return fragmentFavouriteBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        favouriteViewModel = new ViewModelProvider(this).get(FavouriteViewModel.class);
        fragmentFavouriteBinding.setHandler(this);
        fragmentFavouriteBinding.setViewModel(favouriteViewModel);
        setupObserver();
    }

    private void setupObserver(){
        favouriteViewModel.getFormStatus().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onFabClicked() {
        favouriteViewModel.validateForm();
    }
}
