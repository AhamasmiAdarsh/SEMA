package com.example.sema3;

import android.os.Bundle;

import com.example.sema3.Fragment.AddFragment;
import com.example.sema3.Fragment.CommunityFragment;
import com.example.sema3.Fragment.HomeFragment;
import com.example.sema3.Fragment.ShopFragment;
import com.example.sema3.Fragment.UsageFragment;
import com.example.sema3.Fragment.UserFragment;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.sema3.databinding.ActivityMainBinding;
import com.iammert.library.readablebottombar.ReadableBottomBar;

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
                        break;
                    case 1 :
                        transaction.replace(R.id.container, new UsageFragment());
                        break;
                    case 2 :
                        transaction.replace(R.id.container, new AddFragment());
                        break;
                    case 3 :
                        transaction.replace(R.id.container, new CommunityFragment());
                        break;
                    case 4 :
                        transaction.replace(R.id.container, new UserFragment());

                        break;

                }
                transaction.commit();
            }
        });
    }

}