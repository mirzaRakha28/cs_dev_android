package com.example.csdevmobile_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public Orang orang1 = new Orang ("ganteng","theo");
    EditText username1 = findViewById(R.id.username);
    EditText password1 = findViewById(R.id.password);
    Button button = findViewById(R.id.button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username1.getText().equals(orang1.username)){
                    if(password1.getText().equals(orang1.password)){
                        Toast.makeText(LoginActivity.this, "Login Succes",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

