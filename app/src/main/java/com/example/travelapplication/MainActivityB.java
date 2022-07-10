package com.example.travelapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;


import org.apache.commons.math3.linear.RealVector;
import org.nd4j.linalg.eigen.Eigen;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;


public class MainActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainb);

        Intent intent = getIntent();

        final double[] vector_1 = intent.getDoubleArrayExtra("vector_1");

        final SeekBar Bar_1 = (SeekBar) findViewById(R.id.seekBar1);

        Bar_1.setMax(100);
        int max = Bar_1.getMax();
        Bar_1.setProgress(50);


        final SeekBar Bar_2 = (SeekBar) findViewById(R.id.seekBar2);
        Bar_2.setMax(100);
        int max2 = Bar_2.getMax();
        Bar_2.setProgress(50);


        final SeekBar Bar_3 = (SeekBar) findViewById(R.id.seekBar3);
        Bar_3.setMax(100);
        int max3 = Bar_3.getMax();
        Bar_3.setProgress(50);

        final SeekBar Bar_4 = (SeekBar) findViewById(R.id.seekBar4);
        Bar_4.setMax(100);
        int max4 = Bar_4.getMax();
        Bar_4.setProgress(50);


        final SeekBar Bar_5 = (SeekBar) findViewById(R.id.seekBar5);
        Bar_5.setMax(100);
        int max5 = Bar_5.getMax();
        Bar_5.setProgress(50);

        final SeekBar Bar_6 = (SeekBar) findViewById(R.id.seekBar6);
        Bar_6.setMax(100);
        int max6 = Bar_6.getMax();
        Bar_6.setProgress(50);


        findViewById(R.id.button_forward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                double K_1 = min(max((double) Bar_1.getProgress(), 10.0), 90);
                double K_2 = min(max((double) Bar_2.getProgress(), 10.0), 90);
                double K_3 = min(max((double) Bar_3.getProgress(), 10.0), 90);
                double K_4 = min(max((double) Bar_4.getProgress(), 10.0), 90);
                double K_5 = min(max((double) Bar_5.getProgress(), 10.0), 90);
                double K_6 = min(max((double) Bar_6.getProgress(), 10.0), 90);


//
//

//
                RealMatrix A = MatrixUtils.createRealMatrix(new double[][]{{1.0               ,(100. - K_1) / K_1 ,(100. - K_6) / K_6   ,K_4 / (100. - K_4)},
                                                                           { K_1 / (100. -K_1), 1.0               , (100. - K_2) / (K_2),(100. - K_5) / K_5},
                                                                           { K_6 / (100. -K_6), K_2 / (100. - K_2), 1.0                 ,(100. - K_3) / K_3},
                                                                           { (100.-K_4) / K_4 , K_5 / (100. - K_5), K_3 / (100. - K_3)  ,1.0}});


                EigenDecomposition ED = new EigenDecomposition(A);

                RealVector ev = ED.getEigenvector(0);

                double[] eigen_values = ED.getRealEigenvalues();

                for (int i = 0; i < eigen_values.length; i++) {
                    Log.i("shape", String.valueOf(eigen_values[i]));

                }

                double evd = ev.getNorm();

                double[] vector_2 = {0.0, 0.0, 0.0, 0.0};

                vector_2[0] = abs(ev.getEntry(0)) / evd;
                vector_2[1] = abs(ev.getEntry(1)) / evd;
                vector_2[2] = abs(ev.getEntry(2)) / evd;
                vector_2[3] = abs(ev.getEntry(3)) / evd;


                Log.i("shape", String.valueOf(ev.getEntry(0)));
                Log.i("shape", String.valueOf(ev.getEntry(1)));
                Log.i("shape", String.valueOf(ev.getEntry(2)));
                Log.i("shape", String.valueOf(ev.getEntry(3)));


                Intent intent = new Intent(MainActivityB.this, MainActivity2.class);

                intent.putExtra("vector_1", vector_1);
                intent.putExtra("vector_2", vector_2);


                startActivity(intent);


            }


        });
        findViewById(R.id.button_backward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
};

