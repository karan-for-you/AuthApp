package com.example.authapp.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.authapp.R;
import com.example.authapp.constant.AppConstants;
import com.example.authapp.view.fragment.FavouriteFragment;
import com.example.authapp.view.fragment.RegularFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FilteredUserActivity extends AppCompatActivity {

    BottomNavigationView bnvMenu;
    FragmentManager fragmentManager;
    Fragment activeFragment = new RegularFragment();
    Fragment regularFragment = new RegularFragment();
    Fragment favouriteFragment = new FavouriteFragment();
    BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (item.getItemId() == R.id.menuFavourite) {
                hideShowFragment(favouriteFragment);
                return true;
            } else {
                hideShowFragment(regularFragment);
                return true;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtered_user);
        bnvMenu = findViewById(R.id.bnvMenu);
        fragmentManager = getSupportFragmentManager();
        bnvMenu.setOnNavigationItemSelectedListener(listener);
        initializeFragments();
    }

    private void initializeFragments() {
        fragmentManager.beginTransaction()
                .add(R.id.fragmentHolder, regularFragment, AppConstants.REGULAR_FRAGMENT_VAL)
                .hide(regularFragment).commit();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentHolder, favouriteFragment, AppConstants.FAVOURITE_FRAGMENT_VAL)
                .hide(favouriteFragment).commit();

        bnvMenu.setSelectedItemId(R.id.menuRegular);
    }

    private void hideShowFragment(Fragment currentFragment) {
        if (currentFragment != activeFragment) {
            int[] animArray = {R.anim.slide_in_right, R.anim.slide_out_right};
            if (activeFragment != null && activeFragment.getTag()!=null) {
                int currentValue = Integer.valueOf(currentFragment.getTag());
                int activeValue = Integer.valueOf(activeFragment.getTag());
                if (currentValue > activeValue) {
                    animArray[0] = R.anim.slide_in_right;
                    animArray[1] = R.anim.slide_out_right;
                } else {
                    animArray[0] = R.anim.slide_in_left;
                    animArray[1] = R.anim.slide_new;
                }

            }
            fragmentManager.beginTransaction()
                    .setCustomAnimations(animArray[0], animArray[1])
                    .hide(activeFragment).show(currentFragment).commit();
            activeFragment = currentFragment;
        }
    }
}
