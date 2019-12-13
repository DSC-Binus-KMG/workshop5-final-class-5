package com.example.workshopdsc;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Button button = findViewById(R.id.button);
        View.OnClickListener btnClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText usernameText = findViewById(R.id.username);
                EditText passwordText = findViewById(R.id.password);
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();
                if(username.equals("admin") && password.equals("admin")){
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//                    intent.setAction(Intent.ACTION_SEND);
                    intent.putExtra("username", username);
//                    intent.setType("text/plain");
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Username or Password is wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        };
        button.setOnClickListener(btnClick);

    }
}
