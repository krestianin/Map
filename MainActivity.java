package com.example.map;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Double.valueOf;

    public class MainActivity extends AppCompatActivity {
        double[] s = new double[1];
        EditText ed1;
        EditText ed2;
        Button b;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            ed1= findViewById(R.id.ed1);
            ed2 = findViewById(R.id.ed2);
            b= findViewById(R.id.button3);
        }


        public void onClick1(View view) {
            Intent g = new Intent(MainActivity.this, Main2Activity.class);

            if (ed1 != null && ed2 != null) {
                double n = valueOf(ed1.getText().toString());
                double m = valueOf(ed2.getText().toString());
                setContentView(R.layout.activity_main2);
                s[0] = n;
                s[1] = m;
                g.putExtra("ed", s);
                startActivity(g);}
        }
    }