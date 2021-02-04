package com.example.mynicestart;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 *
 * Crea un Activity con una animacion sobre el Logo/titulo de nuestra aplicacion y carga la pagina del login
 * @author miguel
 * @see LoginActivity
 */
public class SplashScreenActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView myImageFondo = (ImageView) findViewById(R.id.imagefondo);
        TextView titulo = findViewById(R.id.suitUp);
        Animation animIn = AnimationUtils.loadAnimation(this, R.anim.alpha);
        Animation animOut = AnimationUtils.loadAnimation(this, R.anim.imagen);
        //Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        //Animation traslado = AnimationUtils.loadAnimation(this, R.anim.traslation);
        titulo.startAnimation(animIn);
        //myImageFondo.startAnimation(traslado);



        Glide.with(this)
                .load(R.drawable.fondo2)
                .centerCrop().transition(DrawableTransitionOptions.withCrossFade(500))
                .placeholder(new ColorDrawable(this.getResources().getColor((R.color.teal_500))))
                .into(myImageFondo);


        openApp(true);


    }

    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity
                        .this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3500);
    }
}