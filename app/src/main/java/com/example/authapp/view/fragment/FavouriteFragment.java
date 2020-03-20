package com.example.authapp.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.authapp.R;
import com.example.authapp.databinding.FragmentFavouriteBinding;
import com.example.authapp.handler.FavouriteHandler;

public class FavouriteFragment extends Fragment implements FavouriteHandler {

    public FavouriteFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentFavouriteBinding fragmentFavouriteBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_favourite,container,false);
        return fragmentFavouriteBinding.getRoot();
    }

    @Override
    public void onFabClicked() {
        Toast.makeText(getActivity(), "Fav Clicked", Toast.LENGTH_SHORT).show();
    }
}
