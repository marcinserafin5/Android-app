package com.example.proejktserafin;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.PrintWriter;

public class NewNote extends AppCompatActivity {
    TextView textnote;
    TextView titlenote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
    }
    public void savenote(View view){
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
        Toast.makeText(getApplicationContext(), "Notatka została zapisana", Toast.LENGTH_LONG).show();
        back();
    }
    public void back(){

        Intent i =new Intent(this,Notatnik.class);
        startActivity(i);
    }
}
