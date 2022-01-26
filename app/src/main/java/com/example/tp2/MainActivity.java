package com.example.tp2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Jeu partie = new Jeu();
    Button b0;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        partie.initialise();
    }

    public void newGame(View v) {
        partie.initialise();
        ((TextView)findViewById(R.id.textView2)).setText(R.string.welcome);
        Button boutons[] = {b0, b1, b2, b3, b4, b5, b6, b7, b8};
        for (int i = 0; i < 9; i++) {
            boutons[i].setText("");
            boutons[i].setBackgroundColor(Color.parseColor("#BABABA"));
        }
    }

    public void reponse(View v, int b) {
        if (!partie.victoire() && !partie.isPartieNulle()) {
            Button bouton = ((Button)v);

            // reception de la sélection du joueur
            if (bouton.getText() == "") {
                partie.setX(b);
                bouton.setText("x");

                // logique pour la réponse de l'ordinateur
                if ( partie.tour < 5 ) {
                    int block = partie.getO();
                    int repID = getResources().getIdentifier("b" + block,
                            "id", getPackageName());
                    ((Button) findViewById(repID)).setText("o");
                }
            }
            // si case est déjà jouée
            else
                Toast.makeText(this, R.string.picked, Toast.LENGTH_LONG).show();

            if (partie.victoire() && !partie.isPartieNulle()) {
                // logique de victoire
                ((TextView) findViewById(R.id.textView2)).setText(R.string.oWins);
                int lumiere1 = partie.lumiere1();
                int lum1 = getResources().getIdentifier("b" + lumiere1, "id", getPackageName());
                ((Button)findViewById(lum1)).setBackgroundColor(Color.BLUE);
                int lumiere2 = partie.lumiere2();
                int lum2 = getResources().getIdentifier("b" + lumiere2, "id", getPackageName());
                ((Button)findViewById(lum2)).setBackgroundColor(Color.BLUE);
                int lumiere3 = partie.lumiere3();
                int lum3 = getResources().getIdentifier("b" + lumiere3, "id", getPackageName());
                ((Button)findViewById(lum3)).setBackgroundColor(Color.BLUE);
            }
            if (partie.isPartieNulle()) {
                // logique de nulle
                ((TextView) findViewById(R.id.textView2)).setText(R.string.tie);
            }
        } else {
            // logique post-partie
            Toast.makeText(this, R.string.end, Toast.LENGTH_LONG).show();
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b0:
                reponse(findViewById(R.id.b0), 0);
                break;
            case R.id.b1:
                reponse(findViewById(R.id.b1), 1);
                break;
            case R.id.b2:
                reponse(findViewById(R.id.b2), 2);
                break;
            case R.id.b3:
                reponse(findViewById(R.id.b3), 3);
                break;
            case R.id.b4:
                reponse(findViewById(R.id.b4), 4);
                break;
            case R.id.b5:
                reponse(findViewById(R.id.b5), 5);
                break;
            case R.id.b6:
                reponse(findViewById(R.id.b6), 6);
                break;
            case R.id.b7:
                reponse(findViewById(R.id.b7), 7);
                break;
            case R.id.b8:
                reponse(findViewById(R.id.b8), 8);
                break;
            default:
                Toast.makeText(this, R.string.error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("tour", partie.tour);
        outState.putCharArray("grille", partie.grille);
        outState.putString("b0", b0.getText().toString());
        outState.putString("b1", b1.getText().toString());
        outState.putString("b2", b2.getText().toString());
        outState.putString("b3", b3.getText().toString());
        outState.putString("b4", b4.getText().toString());
        outState.putString("b5", b5.getText().toString());
        outState.putString("b6", b6.getText().toString());
        outState.putString("b7", b7.getText().toString());
        outState.putString("b8", b8.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle inState) {
        super.onRestoreInstanceState(inState);

        partie.tour = inState.getInt("tour");
        partie.grille = inState.getCharArray("grille");

        if ( partie.victoire() ) {
            ((TextView) findViewById(R.id.textView2)).setText(R.string.oWins);
            int lumiere1 = partie.lumiere1();
            int lum1 = getResources().getIdentifier("b" + lumiere1, "id", getPackageName());
            ((Button)findViewById(lum1)).setBackgroundColor(Color.BLUE);
            int lumiere2 = partie.lumiere2();
            int lum2 = getResources().getIdentifier("b" + lumiere2, "id", getPackageName());
            ((Button)findViewById(lum2)).setBackgroundColor(Color.BLUE);
            int lumiere3 = partie.lumiere3();
            int lum3 = getResources().getIdentifier("b" + lumiere3, "id", getPackageName());
            ((Button)findViewById(lum3)).setBackgroundColor(Color.BLUE);
        } else if ( partie.isPartieNulle() )
            ((TextView) findViewById(R.id.textView2)).setText(R.string.tie);
        else
            ((TextView) findViewById(R.id.textView2)).setText(R.string.welcome);

        b0.setText(inState.getString("b0"));
        b1.setText(inState.getString("b1"));
        b2.setText(inState.getString("b2"));
        b3.setText(inState.getString("b3"));
        b4.setText(inState.getString("b4"));
        b5.setText(inState.getString("b5"));
        b6.setText(inState.getString("b6"));
        b7.setText(inState.getString("b7"));
        b8.setText(inState.getString("b8"));
    }
}