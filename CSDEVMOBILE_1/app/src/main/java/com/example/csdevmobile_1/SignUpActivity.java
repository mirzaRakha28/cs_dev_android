package com.example.csdevmobile_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.csdevmobile_1.Databases.LocalDatabase;
import com.example.csdevmobile_1.Model.Akun;

public class SignUpActivity extends AppCompatActivity {

    LocalDatabase localDatabase;
    EditText name, username, password;
    Button daftar;
    TextView login;
    private Akun akun = new Akun();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        localDatabase = new LocalDatabase(this);
        name = findViewById(R.id.et_nama);
        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        daftar = findViewById(R.id.et_daftar);
        login = findViewById(R.id.tv_buat_disini);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                akun.setNama(name.getText().toString());
                akun.setUsername(name.getText().toString());
                akun.setPassword(name.getText().toString());
                try{
                    localDatabase.insertAkun(akun);
                    Toast.makeText(getBaseContext(),"berhasil terdaftar",Toast.LENGTH_LONG)
                            .show();
                    startActivity(new Intent(SignUpActivity.this,LoginActivity2.class));
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"pendaftaran gagal",Toast.LENGTH_LONG)
                            .show();
                }

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity2.class));
            }
        });
    }
}
