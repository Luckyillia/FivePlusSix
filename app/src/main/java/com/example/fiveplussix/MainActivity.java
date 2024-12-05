package com.example.fiveplussix;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passEditText;
    private EditText pass2EditText;
    private TextView countextView;
    private TextView message;
    private int count;
    private String msg;
    private String email;
    private String pass;
    private String pass2;
    private String lastEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countextView = findViewById(R.id.count);
        message = findViewById(R.id.message);

        Button polub = findViewById(R.id.polub);
        Button usun = findViewById(R.id.usun);
        Button save = findViewById(R.id.save);
        Button view = findViewById(R.id.view);

        emailEditText = findViewById(R.id.email);
        passEditText = findViewById(R.id.pass);
        pass2EditText = findViewById(R.id.pass2);

        polub.setOnClickListener(view1 -> {
            count++;
            countextView.setText(count+" polubien");
        });
        usun.setOnClickListener(view1 -> {
            if(count != 0) {
                count--;
                countextView.setText(count + " polubien");
            }
        });
        save.setOnClickListener(view1 -> {
            msg = "";
            email = emailEditText.getText().toString().trim();
            pass = passEditText.getText().toString().trim();
            pass2 = pass2EditText.getText().toString().trim();
            if(!email.contains("@")){
                message.setText("Nieprawidlowy adres Email\n");
            } else if (!pass.equals(pass2)) {
                message.setText("Hasla sie roznia\n");
            }else{
                lastEmail = email;
                message.setText(lastEmail);
            }
        });
        view.setOnClickListener(view1 -> {
            message.setText(lastEmail);
        });
    }
}