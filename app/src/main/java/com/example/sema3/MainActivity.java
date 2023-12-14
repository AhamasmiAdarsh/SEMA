package com.example.sema3;

import android.os.Bundle;

import com.example.sema3.Fragment.AddFragment;
import com.example.sema3.Fragment.CommunityFragment;
import com.example.sema3.Fragment.HomeFragment;
import com.example.sema3.Fragment.SearchFragment;
import com.example.sema3.Fragment.UserFragment;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sema3.databinding.ActivityMainBinding;
import com.iammert.library.readablebottombar.ReadableBottomBar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new HomeFragment());
        transaction.commit();

        binding.readableBottomBar.setOnItemSelectListener(new ReadableBottomBar.ItemSelectListener() {
            @Override
            public void onItemSelected(int i) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


                switch (i){
                    case 0 :
                        transaction.replace(R.id.container, new HomeFragment());
                        Toast.makeText(MainActivity.this, "Home Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case 1 :
                        transaction.replace(R.id.container, new SearchFragment());
                        Toast.makeText(MainActivity.this, "Search Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case 2 :
                        transaction.replace(R.id.container, new AddFragment());
                        Toast.makeText(MainActivity.this, "Add Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case 3 :
                        transaction.replace(R.id.container, new CommunityFragment());
                        Toast.makeText(MainActivity.this, "Community Tab Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case 4 :
                        transaction.replace(R.id.container, new UserFragment());
                        Toast.makeText(MainActivity.this, "User Selected", Toast.LENGTH_SHORT).show();
                        break;

                }
                transaction.commit();
            }
        });
    }

}