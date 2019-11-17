package com.example.proejktserafin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;



public class Notatnik extends AppCompatActivity {

    private ListView lista ;
    private ArrayAdapter<String> adapter ;
    ArrayList<String> listaArray;
    TextView textfind;
    static String[] elementy;
;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notatnik);
        lista = (ListView) findViewById(R.id.listView1);

        String[] elementy = fileList();

        if(elementy != null) {

            for (int i = 0; i <elementy.length ; i++) {
                elementy[i]=elementy[i].replace(".txt", "");
                Log.d("NOTATNIK",elementy[i]);

            }

            listaArray = new ArrayList<String>();
            listaArray.addAll(Arrays.asList(elementy));

            adapter = new ArrayAdapter<String>(this, R.layout.row, elementy);


            lista.setAdapter(adapter);






        }
    }
    public void gotonewnote(View view){

        Intent i =new Intent(this,NewNote.class);
        startActivity(i);
    }

    public void search(View view){
        List<String> results;
        lista = (ListView) findViewById(R.id.listView1);
        textfind = findViewById(R.id.find);
        CharSequence textfindstr = textfind.getText();

        results =listaArray.stream()
                .filter(n -> n.contains(textfindstr))
                .collect(Collectors.<String>toList());


        adapter = new ArrayAdapter<String>(this, R.layout.row, results);
        lista.setAdapter(adapter);
        if(results.isEmpty()){
            Toast.makeText(getApplicationContext(), "Nie znaleziono notatek", Toast.LENGTH_LONG).show();
        }

    }

    public void readNote(View view){
       TextView filename;

        filename=view.findViewById(R.id.Row);

        String filenameString = filename.getText().toString();
        Log.d("dara",filenameString);

        Bundle kosz = new Bundle();
        kosz.putString("Nazwa",filenameString);
        Intent i = new Intent(this, ReadNote.class);

        i.putExtras(kosz);
        startActivity(i);

    }
}
