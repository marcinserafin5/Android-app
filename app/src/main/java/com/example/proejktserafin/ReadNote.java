package com.example.proejktserafin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadNote extends AppCompatActivity {
    TextView textnote;
    TextView titlenote;
    File file;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_note);
        EditText title = (EditText) findViewById(R.id.title);
        Bundle przekazanedane = getIntent().getExtras();
        String przekazanytekst = przekazanedane.getString("Nazwa");
        title.setText(przekazanytekst);

        EditText text = (EditText) findViewById(R.id.text);





        file = new File(getFilesDir(), przekazanytekst + ".txt");
        String tekst ="";
        try {
            Scanner in = new Scanner(file);

            while(in.hasNext()){
                tekst += in.nextLine()+"\n";
                Log.d("path",tekst);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        text.setText(tekst);



        }

        public void edit(View view){
            textnote = findViewById(R.id.text);
            titlenote = findViewById(R.id.title);
            CharSequence textnotestr = textnote.getText();
            CharSequence titlenotestr = titlenote.getText();


            try(FileOutputStream outputStream = openFileOutput(titlenotestr +".txt", Context.MODE_PRIVATE)){
                outputStream.write(textnotestr.toString().getBytes());
            } catch (Exception e)
            {
                e.printStackTrace();
            }

            Toast.makeText(getApplicationContext(), "Zmieniono notatke", Toast.LENGTH_LONG).show();
            back();
        }

        public void back(){

            Intent i =new Intent(this,Notatnik.class);
            startActivity(i);
        }

        public void delete(View view){
            file.delete();
            Toast.makeText(getApplicationContext(), "Usunieto notatke", Toast.LENGTH_LONG).show();
            back();

        }

}
