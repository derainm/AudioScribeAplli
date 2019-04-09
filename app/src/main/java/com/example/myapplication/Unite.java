package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Unite extends AppCompatActivity {
    public final static int TAILLE = 1;
    public final static int MAIN = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unite);
        Intent i = getIntent();
        //Intent i = new Intent(Unite.this, MainActivity.class);
       //i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        String s = i.getStringExtra("Ceci_est_mon_unit");
        EditText unitTx = (EditText) findViewById(R.id.editTextUnite);
        unitTx.setText(s);
    }

    @Override
    public void onNewIntent(Intent i)
    {
        String s = i.getStringExtra("Ceci_est_mon_unit");
        //if(s!=null && s!="") {
            EditText unitTx = (EditText) findViewById(R.id.editTextUnite);
            unitTx.setText(s);
        //}

    }
    private boolean isCm = false;
    private boolean isPouces =true;
    private float value;
    public void cm(View v)
    {
        EditText ed = (EditText) findViewById(R.id.editTextUnite);
        String s =  ed.getText().toString();
        RadioButton rb = (RadioButton) findViewById(R.id.rdCm);
        if(isCm && rb.isChecked() && isCm &&s!=null && s!="") {
            float val = Float.parseFloat(s);
            val = val/0.393701f;
            ed.setText(""+val);
            isCm = false;
        }
        //on débloque pouces
        isPouces = true;
    }

    public void pouces(View v)
    {
        EditText ed = (EditText) findViewById(R.id.editTextUnite);
        String s =  ed.getText().toString();
        RadioButton rb = (RadioButton) findViewById(R.id.rdPouces);
        if(isPouces && rb.isChecked() && isPouces &&s!=null && s!="") {
            float val = Float.parseFloat(s);
            val = val*0.393701f;
            ed.setText(""+val);
            isPouces = false;
        }
        //on ébloque cm
        isCm = true;
    }


    public void goTo(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.buttonTaille:
                i = new Intent(Unite.this, Taille.class);
                i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivityForResult(i, TAILLE);
                break;
            case R.id.buttonMain:
                i = new Intent(Unite.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                EditText txt = (EditText) findViewById(R.id.editText);
                String s = txt.getText().toString();
                i.putExtra("Ceci_est_ma_valeur", s);

               //startActivityForResult(i, MAIN);
                startActivity(i);
                break;
        }
    }
}
