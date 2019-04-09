package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public final static int TAILLE = 1;
    public final static int UNITE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**/


        /**/

    }

    @Override
    public void onNewIntent(Intent i)
    {
        String s = i.getStringExtra("Ceci_est_ma_valeur");
        if(s!=null && s!="") {
            float val = Float.parseFloat(s);
            EditText ed = (EditText) findViewById(R.id.editText);
            ed.setTextSize(val);
            ed.setText(s);
            //TextView tx = (TextView) findViewById(R.id.value);
        }
        /*float value = i.getFloatExtra("Ceci_est_mon_unit",0.0f);
            if (value >0.0f) {

                EditText ed = (EditText) findViewById(R.id.editText);
                ed.setTextSize(40.0f);
                ed.setText(""+ value);
            }*/

    }

    public void goTo(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.buttonTaille:
                i = new Intent(MainActivity.this, Taille.class);
                i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivityForResult(i, TAILLE);
                break;
            case R.id.buttonUnite:
                i = new Intent(MainActivity.this, Unite.class);
                i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                EditText txt = (EditText) findViewById(R.id.editText);
                String s = txt.getText().toString();
                i.putExtra("Ceci_est_mon_unit", s);


                startActivityForResult(i, UNITE);
                break;
        }
    }
}
