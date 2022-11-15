package com.example.zeroapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegActivity extends AppCompatActivity {

    Intent intent;
    EditText FullName;
    EditText EmailOrPhone;
    EditText Password;
    EditText PasswordConfirm;
    CheckBox Remember;
    Button RegButton;
    View Stick2;
    View Stick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        FullName = findViewById(R.id.FullName);
        EmailOrPhone = findViewById(R.id.EmailOrPhone);
        Password = findViewById(R.id.Password);
        PasswordConfirm = findViewById(R.id.PasswordConfirm);
        Remember = findViewById(R.id.CheckBox);
        RegButton = findViewById(R.id.Register);
        Stick = findViewById(R.id.stick);
        Stick2 = findViewById(R.id.stick2);
        InitListners();
    }

    private void InitListners() {
        FullName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CheckingForComplete();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        EmailOrPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CheckingForComplete();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CheckingForComplete();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        PasswordConfirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CheckingForComplete();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Remember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckingForComplete();
            }
        });
    }
    private Boolean CheckingForComplete(){
        if(FullName.getText().toString() != "" &&
                EmailOrPhone.getText().toString() != "" &&
                PasswordConfirm.getText().toString() != "" &&
                Password.getText().toString() != ""&&
                Remember.isChecked() == true){
            RegButton.setBackground(getResources().getDrawable(R.drawable.roundedittext700));
            RegButton.setTextColor(getResources().getColor(R.color.white));
            return true;
        }
        else{
            RegButton.setBackground(getResources().getDrawable(R.drawable.roundedittext100));
            RegButton.setTextColor(getResources().getColor(R.color.pink_700));
            return false;
        }
    }

    public void Register(View v){

        intent = new Intent(this,CreatedAccount.class);
        startActivity(intent);
    }

    public void changePasswordVisibility(View v){
        if(Password.getInputType() == InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD){
            Password.setInputType(InputType.TYPE_CLASS_TEXT);
            Stick.setVisibility(View.INVISIBLE);
        }
        else{
            Password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
            Stick.setVisibility(View.VISIBLE);
        }
    }
    public void changePasswordConfirmVisibility(View v){
        if(PasswordConfirm.getInputType() == InputType.TYPE_TEXT_VARIATION_PASSWORD){
            PasswordConfirm.setInputType(InputType.TYPE_CLASS_TEXT);
            Stick2.setVisibility(View.INVISIBLE);
        }
        else{
            PasswordConfirm.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
            Stick2.setVisibility(View.VISIBLE);
        }
    }
    public void toLoginActivity(View v){
        intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
