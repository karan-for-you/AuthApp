package com.example.authapp.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.authapp.R;
import com.example.authapp.databinding.FragmentRegularBinding;
import com.example.authapp.view.adapter.UsersAdapter;
import com.example.authapp.viewmodel.RegularViewModel;

import java.util.ArrayList;
import java.util.List;

public class RegularFragment extends Fragment {

    private RecyclerView rvUser;
    private List<String> userList = new ArrayList<>();
    private RegularViewModel viewModel;
    private UsersAdapter usersAdapter;

    public RegularFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentRegularBinding fragmentRegularBinding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_regular, container, false);
        return fragmentRegularBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rvUser = view.findViewById(R.id.rvRegularUsers);
        viewModel = new ViewModelProvider(getActivity()).get(RegularViewModel.class);
        initViews();
        setupObserver();
    }

    private void setupObserver(){
        viewModel.getMeLiveData("Prefixed User").observe(getViewLifecycleOwner(),
                new Observer<List<String>>() {
                    @Override
                    public void onChanged(List<String> strings) {
                        usersAdapter.addAllUsers(strings);
                    }
                });
    }

    private void initViews(){
        rvUser.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.HORIZONTAL));
        rvUser.setLayoutManager(new LinearLayoutManager(getContext()));
        usersAdapter = new UsersAdapter(getContext(),userList);
        rvUser.setAdapter(usersAdapter);
    }
}
