package com.example.csdevmobile_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.csdevmobile_1.Databases.LocalDatabase;
import com.example.csdevmobile_1.Model.Akun;

public class LoginActivity2 extends AppCompatActivity {

    LocalDatabase localDatabase;
    EditText username,password;
    Button login;
    TextView daftar;
    Akun akun = new Akun();
    Akun login_akun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        localDatabase = new LocalDatabase(this);
        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        login = findViewById(R.id.btn_login);
        daftar = findViewById(R.id.tv_buat_disini);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                akun.setUsername(username.getText().toString());
                akun.setPassword(username.getText().toString());
                try {
                    login_akun = localDatabase.getAkun(akun.getUsername());
                    if(login_akun != null){
                        if (login_akun.getPassword().equals(akun.getPassword())){
                            Toast.makeText(getBaseContext(),"login berhasil",Toast.LENGTH_LONG)
                                    .show();
                            startActivity(new Intent(LoginActivity2.this,
                                    MainActivity.class));
                        }else{
                            Toast.makeText(getBaseContext(),"username atau password salah",
                                    Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(getBaseContext(),"username atau password salah",
                                Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"Login gagal",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity2.this,SignUpActivity.class));
            }
        });
    }
}
