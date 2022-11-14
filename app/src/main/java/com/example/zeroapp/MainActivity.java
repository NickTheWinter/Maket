package com.example.zeroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText EmailOrPhone;
    EditText PasswordBox;
    CheckBox Remember;
    Button LoginButton;
    View Stick;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EmailOrPhone = findViewById(R.id.EmailOrPhone);
        PasswordBox = findViewById(R.id.Password);
        Remember = findViewById(R.id.CheckBox);
        Stick = findViewById(R.id.stick);
        LoginButton = findViewById(R.id.Login);
        InitListners();
    }
    private void InitListners(){

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
        PasswordBox.addTextChangedListener(new TextWatcher() {
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
        if(EmailOrPhone.getText().toString() != ""&&
           PasswordBox.getText().toString() != ""&&
           Remember.isChecked() == true){
            LoginButton.setBackground(getResources().getDrawable(R.drawable.roundedittext700));
            LoginButton.setTextColor(getResources().getColor(R.color.white));
            return true;
        }
        else{
            LoginButton.setBackground(getResources().getDrawable(R.drawable.roundedittext100));
            LoginButton.setTextColor(getResources().getColor(R.color.pink_700));
            return false;
        }
    }
    public void Login(View v){
        if(CheckingForComplete()){
            Toast.makeText(this, "You have entered you're account", Toast.LENGTH_SHORT).show();
        }
    }
    public void changeVisibility(View v){
        if(PasswordBox.getInputType() == InputType.TYPE_TEXT_VARIATION_PASSWORD){
            PasswordBox.setInputType(InputType.TYPE_CLASS_TEXT);
            Stick.setVisibility(View.INVISIBLE);
        }
        else{
            PasswordBox.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
            Stick.setVisibility(View.VISIBLE);
        }
    }
    public void toRegActivity(View v){
        intent = new Intent(this,RegActivity.class);
        startActivity(intent);
    }
}