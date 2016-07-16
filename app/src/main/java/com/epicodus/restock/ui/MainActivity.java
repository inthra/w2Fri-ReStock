package com.epicodus.restock.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.restock.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.tvHeader) TextView mAppNameHeader;
    @Bind(R.id.etEmail) EditText mEmail;
    @Bind(R.id.etPassword) EditText mPassword;
    @Bind(R.id.bSignIn) Button mSignInButton;
    @Bind(R.id.bRegisterHere) Button mRegisterHere;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ProgressDialog mAuthProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface pacificoFont = Typeface.createFromAsset(getAssets(), "fonts/pacifico.ttf");
        mAppNameHeader.setTypeface(pacificoFont);

        mAuth = FirebaseAuth.getInstance();

        createAuthProgressDialog();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(MainActivity.this, RolesActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };

        mSignInButton.setOnClickListener(this);
        mRegisterHere.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
        public void onClick(View v) {
        if(v == mSignInButton) {
            loginWithPassword();
        }

        if(v == mRegisterHere) {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void createAuthProgressDialog() {
        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle("Loading...");
        mAuthProgressDialog.setMessage("Authenticating with Firebase...");
        mAuthProgressDialog.setCancelable(false);
    }

    private void loginWithPassword() {
        String emailInput = mEmail.getText().toString().trim();
        String passwordInput = mPassword.getText().toString().trim();
        if (emailInput.equals("")) {
            mEmail.setError("Please enter your email");
            return;
        }
        if (passwordInput.equals("")) {
            mPassword.setError("Please enter your password");
            return;
        }

        mAuthProgressDialog.show();

        mAuth.signInWithEmailAndPassword(emailInput, passwordInput).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                mAuthProgressDialog.dismiss();

                if (!task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
