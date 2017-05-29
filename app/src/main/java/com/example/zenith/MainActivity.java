package com.example.zenith;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity extends Activity {

    private TextView mTextMessage;
    ProgressBar prg;
    EditText editText;
    TextView textView;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_daily:
                    mTextMessage.setText("daily");
                    return true;
                case R.id.navigation_weekly:
                    mTextMessage.setText("weekly");
                    return true;
                case R.id.navigation_venture:
                    mTextMessage.setText("venture");
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);




        prg = (ProgressBar) findViewById(R.id.hpbar);
        prg = (ProgressBar) findViewById(R.id.expbar);

        editText = (EditText)findViewById((R.id.task));
        textView = (TextView) findViewById(R.id.viewtaskbutton);


    }


    public void submitTask(View view){
        String Message = editText.getText().toString();
        String filename = "data";
        try {
            FileOutputStream fileOutputStream = openFileOutput(filename, MODE_PRIVATE);
            fileOutputStream.write(Message.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(),"Task Created", Toast.LENGTH_LONG).show();
        } catch( FileNotFoundException e ){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void viewTask(View view){

        try {
            String Task;
            FileInputStream fileInputStream = openFileInput("data");
            InputStreamReader inputStreamReader= new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            while((Task = bufferedReader.readLine())!=null){
                stringBuffer.append(Task + "\n");
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch( IOException e){
            e.printStackTrace();
        }
    }

}
