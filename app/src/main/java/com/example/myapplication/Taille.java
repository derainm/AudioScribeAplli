package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class Taille extends AppCompatActivity {
    public final static int UNITE = 2;

    // static  int c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taille);


        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        final TextView seekBarValue = (TextView) findViewById(R.id.seekbarvalue);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                seekBarValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }


        });

    }


    public void goTo(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.buttonMain:
                //i = new Intent(Taille.this, MainActivity.class);
                /**/
                i = new Intent(Taille.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                TextView txt = (TextView) findViewById(R.id.seekbarvalue);
                String s = txt.getText().toString();
                i.putExtra("Ceci_est_ma_valeur", s);

                /**/
                startActivity(i);
                break;
            case R.id.buttonUnite:
                i = new Intent(Taille.this, Unite.class);
                i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                TextView txt_ = (TextView) findViewById(R.id.seekbarvalue);
                String s_ = txt_.getText().toString();
                i.putExtra("Ceci_est_mon_unit", s_);
                startActivity(i);
                break;
        }
    }
}


