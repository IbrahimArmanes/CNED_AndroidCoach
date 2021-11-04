package com.example.coach.vue;


import static java.lang.String.format;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coach.R;
import com.example.coach.controleur.Controle;



public class MainActivity extends AppCompatActivity {
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private TextView lblIMG;
    private ImageView imgSmiley;
    private Button btnCalc;

    private Controle controle;



    private void ecouteCalcul(){

        btnCalc.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                try {
                    Integer poids =  0;
                    Integer taille = 0;
                    Integer age = 0 ;
                    Integer sexe = 0 ;
                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                    if (rdHomme.isChecked()){
                        sexe = 1;
                    }

                    if (poids == 0 | taille == 0 | age == 0){
                        Toast.makeText(MainActivity.this, "Veuillez saisir tout les champs", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        affichResult(poids, taille, age, sexe);
                    }

                }catch(Exception e){}

                }

        });

    }

    private void affichResult(Integer poids, Integer taille, Integer age, Integer sexe){

        controle.creerProfil(poids, taille, age, sexe);
        float img = controle.getImg();
        String msg = controle.getMessage();

        if (msg == "trop faible"){
            imgSmiley.setImageResource(R.drawable.maigre);
            lblIMG.setText(format("%.01f", img) + "IMG trop faible");
            lblIMG.setTextColor(Color.RED);
        }
        else  if ( msg == "normal"){
            imgSmiley.setImageResource(R.drawable.normal);
            lblIMG.setText(format("%.01f", img) + "IMG normal");
            lblIMG.setTextColor(Color.GREEN);
        }
        else if( msg == "trop élevé"){
            imgSmiley.setImageResource(R.drawable.graisse);
            lblIMG.setText(format("%.01f", img) + "IIMG trop élevé");
            lblIMG.setTextColor(Color.RED);
        }

    }

    private void init(){
        txtPoids = (EditText) findViewById(R.id.txtPoids);
        txtTaille = (EditText) findViewById(R.id.txtTaille);
        txtAge = (EditText) findViewById(R.id.txtAge);
        rdHomme = (RadioButton) findViewById(R.id.rdHomme);
        lblIMG = (TextView) findViewById(R.id.lblIMG);
        imgSmiley = (ImageView) findViewById(R.id.imageSmiley);
        btnCalc = (Button) findViewById(R.id.btnCalc);
        controle = Controle.getInstance();
        ecouteCalcul();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
}