package com.mrshashankbisht.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Fragment fragment_2, fragment_3;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn = findViewById(R.id.main_button);

        fragmentManager = getSupportFragmentManager();
        fragment_2 = fragmentManager.findFragmentById(R.id.fragment_2);
        if(fragment_2 == null){
            fragment_2 = new Fragment_2();
        }

        fragment_3 = fragmentManager.findFragmentById(R.id.fragment_3);
        if(fragment_3 == null){
            fragment_3 = new Fragment_3();
        }

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_2_container, fragment_3);

        fragmentTransaction.commit();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f1 = fragmentManager.findFragmentById(R.id.fragment_1);
                if(f1 == null){
                    f1 = new Fragment_1();
                }
                fragmentManager.beginTransaction().replace(R.id.fragment_2_container, f1).commit();
            }
        });
    }
}