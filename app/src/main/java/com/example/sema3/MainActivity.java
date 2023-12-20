package com.example.sema3;

import android.os.Bundle;

import com.example.sema3.Fragment.AddFragment;
import com.example.sema3.Fragment.CommunityFragment;
import com.example.sema3.Fragment.HomeFragment;
import com.example.sema3.Fragment.ShopFragment;
import com.example.sema3.Fragment.UsageFragment;
import com.example.sema3.Fragment.UserFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.sema3.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.iammert.library.readablebottombar.ReadableBottomBar;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding activityMainBinding;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = FirebaseFirestore.getInstance();

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

    private void addDataToFirestore(String userId, Number V, Number I, Number T) {


        CollectionReference dbUser = db.collection("Users");

        DocumentReference userDocRef = dbUser.document(userId);


        // adding our data to our courses object class.
        VIT vit = new VIT(V, I, T);

        // below method is use to add data to Firebase Firestore.
        userDocRef.set(vit).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                // Data addition is successful
                // Display a success toast message.
                Toast.makeText(MainActivity.this, "Your VIT has been added to Firebase Firestore", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Data addition process failed
                // Display a toast message when data addition fails.
                Toast.makeText(MainActivity.this, "Fail to add VIT \n" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void readVITFromFirestore(String userId) {
        CollectionReference dbUser = db.collection("Users");
        DocumentReference userDocRef = dbUser.document(userId);

        userDocRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    // The document exists, retrieve the VIT data
                    VIT vit = documentSnapshot.toObject(VIT.class);

                    if (vit != null) {
                        Number vValue = vit.getV();
                        Number iValue = vit.getI();
                        Number tValue = vit.getT();

                        // Do something with the VIT data
                        // For example, display it in a TextView
                    } else {
                        // Handle the case where the VIT object is null
                        Toast.makeText(MainActivity.this, "No VIT data found for the user", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Handle the case where the document does not exist
                    Toast.makeText(MainActivity.this, "No document found for the user", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Handle failures in reading data
                Toast.makeText(MainActivity.this, "Failed to read VIT data\n" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }


}