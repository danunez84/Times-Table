package com.danunez.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    public ArrayList<String> populateArrayList(int times){
        ArrayList<String> populated = new ArrayList<>();
        for (int i =1 ; i < 11 ; i++){
            populated.add("" + i + " * " + times + " = "  + i * times);
        }
        return populated;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView myListView =  (ListView) findViewById(R.id.mylistView);
        final ArrayList<String> myList = populateArrayList(1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, myList);
        myListView.setAdapter(adapter);

        SeekBar mySeekBar = (SeekBar) findViewById(R.id.mySeekBar);
        int seekBarValue= mySeekBar.getProgress();
        mySeekBar.setMax(49);


        //int valueSelected =1;

        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int min = 1;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                myListView.setAdapter(new ArrayAdapter<String>(getApplicationContext() , android.R.layout.simple_list_item_1,
                        android.R.id.text1, populateArrayList(progress + min)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}
