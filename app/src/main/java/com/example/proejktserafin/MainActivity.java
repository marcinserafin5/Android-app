package com.example.proejktserafin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   public void gotonote(View view){

        Intent i =new Intent(this,Notatnik.class);
        startActivity(i);
    }
    public void gotoks(View view){

        Intent i =new Intent(this,ksiazka.class);
        startActivity(i);
    }
    public void gotocentr(View view){

        Intent i =new Intent(this,Centrummulti.class);
        startActivity(i);
    }
    public void gotoprzyp(View view){

        Intent i =new Intent(this,Przypominajka.class);
        startActivity(i);
    }
}
