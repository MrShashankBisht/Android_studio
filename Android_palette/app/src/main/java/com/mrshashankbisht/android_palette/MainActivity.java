package com.mrshashankbisht.android_palette;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText, ageEditText, phoneNumberEditText, emailEditText;
    Button submitButton;

    ArrayList<User> userArrayList = new ArrayList<>();

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

        nameEditText = findViewById(R.id.name_et);
        ageEditText = findViewById(R.id.age_et);
        phoneNumberEditText = findViewById(R.id.phone_et);
        emailEditText = findViewById(R.id.email_et);
        submitButton = findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nameEditText.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(ageEditText.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your age", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(phoneNumberEditText.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your phone number", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(emailEditText.getText().toString().trim().isEmpty() || !isEmailValid(emailEditText.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                    return;
                }
                User user = new User(nameEditText.getText().toString(), phoneNumberEditText.getText().toString(), emailEditText.getText().toString(), Integer.parseInt(ageEditText.getText().toString()));
                userArrayList.add(user);
                nameEditText.setText("");
                ageEditText.setText("");
                phoneNumberEditText.setText("");
                emailEditText.setText("");

                Toast.makeText(MainActivity.this, "Data submitted", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private Boolean isEmailValid(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}