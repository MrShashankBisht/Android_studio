package com.mrshashankbisht.firstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;;
    TextView tv;
    LinearLayout layout;

    Runnable rn = new Runnable() {
        @Override
        public void run() {
            try {
                System.out.println("Thread is started");
                Thread.sleep(5000);
                System.out.println("Thread is ended");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    };

    Thread myThread;


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

        btn = findViewById(R.id.btn_1);
        tv = findViewById(R.id.tv);
        layout = findViewById(R.id.layout);
        myThread = new Thread(rn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThread.run();
                tv.setText("Hello Chander kese ho!!");
                Toast.makeText(MainActivity.this, "Hello Chander kese ho!!", Toast.LENGTH_SHORT).show();
            }
        });

        for (int i = 0; i<= 10; i++){
            TextView textView = new TextView(this);
            textView.setText("Simple Text");
            System.out.println();
            layout.addView(textView);
        }
    }
}