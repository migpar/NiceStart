package com.example.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

/**
 * Esta clase nos permite logearnos con nuestra cuenta, con nuestro nick y contraseña, o irnos a la pantalla de registro.
 * Accedemos e esta pantalla automaticamente tras la SplashScreen
 * @author miguel
 * @see RegisterActivity
 * @see MainActivity
 * @see SplashScreenActivity
 */
public class LoginActivity extends AppCompatActivity {
    protected TextView mSignUpTextview;
    protected Button mLoginButton;
    protected Button mRegisterButton;
    protected TextInputLayout mUsername;
    protected ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mRegisterButton = (Button) findViewById(R.id.buttonRegister);
        mLoginButton = (Button) findViewById(R.id.buttonLogin);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity
                        .this, RegisterActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity
                        .this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);
            }
        });
    }

}