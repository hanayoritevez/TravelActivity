package com.example.travelapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity2B extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2b);
        Intent intent = getIntent();

        final double[] vector_1 = intent.getDoubleArrayExtra("vector_1");

        final double[] vector_2 = intent.getDoubleArrayExtra("vector_2");

        final double[] vector_3 = intent.getDoubleArrayExtra("vector_3");

        final double[] vector_4 = {0., 0.,1., 1., 0., 0.};

        final SeekBar Bar_1 = (SeekBar)findViewById(R.id.seekBar1);
        Bar_1.setMax(100);
        Bar_1.setProgress(0);


        final SeekBar Bar_2 = (SeekBar)findViewById(R.id.seekBar2);
        Bar_2.setMax(100);
        Bar_2.setProgress(0);

        final SeekBar Bar_3 = (SeekBar)findViewById(R.id.seekBar3);
        Bar_3.setMax(100);
        Bar_3.setProgress(0);

        final SeekBar Bar_4 = (SeekBar)findViewById(R.id.seekBar4);
        Bar_4.setMax(100);
        Bar_4.setProgress(0);

        final SeekBar Bar_5 = (SeekBar)findViewById(R.id.seekBar5);
        Bar_5.setMax(100);
        Bar_5.setProgress(0);

        final SeekBar Bar_6 = (SeekBar)findViewById(R.id.seekBar6);
        Bar_6.setMax(100);
        Bar_6.setProgress(0);


        findViewById(R.id.button_forward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity2B.this, MainActivity3.class);

                intent.putExtra("vector_4", vector_4);
                intent.putExtra("vector_3", vector_3);
                intent.putExtra("vector_2", vector_2);
                intent.putExtra("vector_1", vector_1);

                startActivity(intent);


            }
        });
    }
}
