package com.william.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText email, password, Cpassword;
    private Button btnRegister;
    private TextView loginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.et_registerEmail);
        password = findViewById(R.id.et_registerPassword);
        btnRegister = findViewById(R.id.btn_register);
        loginText = findViewById(R.id.tv_toLogin);
        Cpassword = findViewById(R.id.ConfirmPassText);


        btnRegister.setOnClickListener(view -> {
            register();
        });

        loginText.setOnClickListener(view -> {
            startActivity(new Intent(RegisterActivity.this, com.william.myapplication.LoginActivity.class));
        });

    }

    private void register() {
        String user = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String cpass = Cpassword.getText().toString().trim();

        if (user.isEmpty()) {
            email.setError("Email cannot be empty!");
        }
        if (pass.isEmpty()) {
            password.setError("Password cannot be empty!");
        }
        if (cpass.isEmpty()) {
            Cpassword.setError("Please Confirm Password");
        }
        if (!user.isEmpty() && !pass.isEmpty() && !cpass.isEmpty()) {
            if (pass.equals(cpass)) {
            mAuth.createUserWithEmailAndPassword(user, pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Data data = new Data(user, pass);

                                FirebaseDatabase
                                        .getInstance()
                                        .getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(data)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Toast.makeText(RegisterActivity.this, "Register Successful", Toast.LENGTH_SHORT)
                                                        .show();
                                            }
                                        });

                                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                            } else {
                                Toast.makeText(RegisterActivity.this, "Register Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT)
                                        .show();
                            }
                        }
                    });
            }
            else {
                Toast.makeText(RegisterActivity.this, "Konfirm Password tidak sesuai", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
