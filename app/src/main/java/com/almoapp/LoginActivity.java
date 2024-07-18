package com.almoapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextTextPassword, editTextTextEmailAddress;
    private ImageView imageViewShowPass;
    private TextView textViewOlvidoPass;
    private boolean showPassword;
    private String USER="user@gmail.com", PASSWORD="password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        showPassword = false;
        imageViewShowPass = findViewById(R.id.imageViewShowPass);
        imageViewShowPass.setOnClickListener(this::onClick);
        textViewOlvidoPass = findViewById(R.id.textViewOlvidoPass);
        textViewOlvidoPass.setOnClickListener(this::onClick);
        Button buttonIngresar = findViewById(R.id.buttonIngresar);
        buttonIngresar.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imageViewShowPass){
            if (!showPassword){
                editTextTextPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                imageViewShowPass.setImageResource(R.drawable.baseline_key_24);
            }else{
                editTextTextPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                imageViewShowPass.setImageResource(R.drawable.baseline_key_off_24);
            }
            editTextTextPassword.setSelection(editTextTextPassword.getText().length());
            showPassword = !showPassword;
        }else if (v.getId() == R.id.textViewOlvidoPass){
            editTextTextEmailAddress.setText(USER);
            editTextTextPassword.setText(PASSWORD);
            Toast.makeText(this,"autocompletando credenciales",Toast.LENGTH_LONG).show();
        }else if (v.getId() == R.id.buttonIngresar){
            login();
        }
    }

    private void login(){
        if (!editTextTextEmailAddress.getText().toString().isEmpty() && !editTextTextPassword.getText().toString().isEmpty()){
            if (editTextTextPassword.getText().toString().equals(PASSWORD) && editTextTextEmailAddress.getText().toString().equals(USER)){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}