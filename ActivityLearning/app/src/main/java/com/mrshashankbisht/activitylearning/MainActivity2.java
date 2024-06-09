package com.mrshashankbisht.activitylearning;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public final class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("MainActivity2 : onCreate");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        System.out.println("MainActivity2 : onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        System.out.println("MainActivity2 : onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        System.out.println("MainActivity2 : onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("MainActivity2 : onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("MainActivity2 : onDestroy");
        super.onDestroy();
    }
}