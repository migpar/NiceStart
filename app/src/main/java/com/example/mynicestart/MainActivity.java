package com.example.mynicestart;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.snackbar.Snackbar;

/**
 * @author miguel
 * @see LoginActivity
 * @see MainActivity2
 */
public class MainActivity extends AppCompatActivity {
    protected Button mainButton;
    protected ImageView perfil;
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        perfil = (ImageView) findViewById(R.id.imagePerfil);


        SwipeRefreshLayout swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        ExpandableCardView card = findViewById(R.id.profile);
        card.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                Toast.makeText(MainActivity.this, isExpanded ? "Expanded!" : "Collapsed!", Toast.LENGTH_SHORT).show();
            }
        });

        Glide.with(this)
                .load(R.drawable.cara).centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .circleCrop().into(perfil);


    }

    // *** MENU APPBAR ***

    //    inflamos el menu del AppBar con los items del recurso xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //    creamos una lista de eventos para los items del menu del AppBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast toast = Toast.makeText(this, "going Settings", Toast.LENGTH_LONG);
            toast.show();

        } else if (id == R.id.camera) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);

            showAlertDialogButtonClicked(MainActivity.this);

        }

        return super.onOptionsItemSelected(item);
    }


    public void openMain2(View view) {
        Intent intent = new Intent(MainActivity
                .this, MainActivity2.class);
        startActivity(intent);
    }

    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {

            //    opción TOAST
            //
            //          Toast toast0 = Toast.makeText(MainContextActivity.this, "going swipeREFRESH", Toast.LENGTH_LONG);
            //          toast0.show();


            //   opción SNACKBAR

//           SUSTITUIR POR CONSTRAINT EN SU CASO
              final ConstraintLayout mLayout = (ConstraintLayout) findViewById(R.id.activity_main_context);
            //final RelativeLayout mLayout = (RelativeLayout) findViewById(R.id.activity_main_context);

            Snackbar snackbar = Snackbar
                    .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });

            snackbar.show();
            swipeLayout.setRefreshing(false);

        }
    };


    // *** DIALOGO MODAL ***

    public void showAlertDialogButtonClicked(MainActivity view) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
//        builder.setTitle("Achtung!");
//        builder.setMessage("Where do you go?");
//        builder.setIcon(R.drawable.ic_action_name_dark);


        // un XML a medida para el diálogo
        builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view, null));

        // add the buttons
        builder.setPositiveButton("Glide", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                dialog.dismiss();

            }
        });

        builder.setNegativeButton("ChatBot", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

                dialog.dismiss();
            }
        });

        builder.setNeutralButton("MotionLayout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...
                Intent intent = new Intent(MainActivity.this, ConstraintSet.Motion.class);
                startActivity(intent);

                dialog.dismiss();
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // ***     DM         ***
}