package com.miguel.a05_loginform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText code, user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        code = findViewById(R.id.editTextCode);
        user = findViewById(R.id.editTextUser);

    }


    public void showName(View view) {
        String n = code.getText().toString();
        String u = user.getText().toString();

        if(u.equals("admin") && n.equals("1234")) {
            Toast.makeText(this, "Ok, it's the correct code!", Toast.LENGTH_SHORT).show();
        } else {
            code.setText("");
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
    }
}
