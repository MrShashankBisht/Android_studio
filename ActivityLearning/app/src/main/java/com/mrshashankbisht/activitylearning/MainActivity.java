package com.mrshashankbisht.activitylearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("onCreate");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn_1 = findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("btn_1 clicked");
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        System.out.println("MainActivity : OnStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        System.out.println("MainActivity: onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        System.out.println("MainActivity : onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("MainActivity : onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("MainActivity : onDestroy");
        super.onDestroy();
    }
}