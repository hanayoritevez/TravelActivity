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


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar Bar_1 = (SeekBar)findViewById(R.id.seekBar1);

        Bar_1.setMax(100);
        int max = Bar_1.getMax();
        Bar_1.setProgress(50);


        final SeekBar Bar_2 = (SeekBar)findViewById(R.id.seekBar2);
        Bar_2.setMax(100);
        int max2 = Bar_2.getMax();
        Bar_2.setProgress(50);


        final SeekBar Bar_3 = (SeekBar)findViewById(R.id.seekBar3);
        Bar_3.setMax(100);
        int max3 = Bar_3.getMax();
        Bar_3.setProgress(50);

        final SeekBar Bar_4 = (SeekBar)findViewById(R.id.seekBar4);
        Bar_4.setMax(100);
        int max4 = Bar_4.getMax();
        Bar_4.setProgress(50);


        final SeekBar Bar_5 = (SeekBar)findViewById(R.id.seekBar5);
        Bar_5.setMax(100);
        int max5 = Bar_5.getMax();
        Bar_5.setProgress(50);

        final SeekBar Bar_6 = (SeekBar)findViewById(R.id.seekBar6);
        Bar_6.setMax(100);
        int max6 = Bar_6.getMax();
        Bar_6.setProgress(50);

        final SeekBar Bar_7 = (SeekBar)findViewById(R.id.seekBar7);
        Bar_7.setMax(100);
        int max7 = Bar_7.getMax();
        Bar_7.setProgress(50);

        final SeekBar Bar_8 = (SeekBar)findViewById(R.id.seekBar8);
        Bar_8.setMax(100);
        int max8 = Bar_8.getMax();
        Bar_8.setProgress(50);

        final SeekBar Bar_9 = (SeekBar)findViewById(R.id.seekBar9);
        Bar_9.setMax(100);
        int max9 = Bar_9.getMax();
        Bar_9.setProgress(50);

        final SeekBar Bar_10 = (SeekBar)findViewById(R.id.seekBar10);
        Bar_10.setMax(100);
        int max10 = Bar_10.getMax();
        Bar_10.setProgress(50);



        //Nd4j.ENFORCE_NUMERICAL_STABILITY = true;
//        INDArray result = null;




//        INDArray matrix1 = Nd4j.create(new double[][]{
//                {1.0, 2.0, 3.0, 4.0},
//                {5.0, 6.0, 7.0, 8.0}});
        //INDArray columnVectorA = Nd4j.create(new double[]{10, 20, 30}, new int[]{3, 1});
        //INDArray x0= Nd4j.linspace(-10, 10, 500).reshape(500,1);;



        findViewById(R.id.button_forward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                double K_1 = min(max((double)Bar_1.getProgress(),10.0),90);
                double K_2 = min(max((double)Bar_2.getProgress(),10.0),90);
                double K_3 = min(max((double)Bar_3.getProgress(),10.0),90);
                double K_4 = min(max((double)Bar_4.getProgress(),10.0),90);
                double K_5 = min(max((double)Bar_5.getProgress(),10.0),90);
                double K_6 = min(max((double)Bar_6.getProgress(),10.0),90);
                double K_7 = min(max((double)Bar_7.getProgress(),10.0),90);
                double K_8 = min(max((double)Bar_8.getProgress(),10.0),90);
                double K_9 = min(max((double)Bar_9.getProgress(),10.0),90);
                double K_10 = min(max((double)Bar_10.getProgress(),10.0),90);


                //


//
//

//
                RealMatrix A = MatrixUtils.createRealMatrix(new double[][] {{1.0, (100.- K_2)/(K_2),K_1/(100.-K_1),(100.- K_8)/(K_8),(100.- K_5)/(K_5)},
                        {K_2/(100.-K_2),1.0, (100.- K_3)/(K_3),(100.- K_9)/(K_9),(100.- K_6)/(K_6)},
                        {(100.- K_1)/(K_1), K_3/(100.-K_3) ,1.0,(100.- K_10)/(K_10),(100.- K_7)/(K_7)},
                        {K_8/(100.-K_8),K_9/(100.-K_9),K_10/(100.-K_10),1.0,K_4/(100.-K_4)},
                        {K_5/(100.-K_5),K_6/(100.-K_6),K_7/(100.-K_7),(100.- K_4)/(K_4),1.0}});


                EigenDecomposition ED = new EigenDecomposition(A);

                RealVector ev = ED.getEigenvector(0);

                double[] eigen_values = ED.getRealEigenvalues();

                for(int i=0;i<eigen_values.length;i++){
                    Log.i("shape",String.valueOf(eigen_values[i]));

                }

                double evd = ev.getNorm();

                double[] vector_1= {0.0,0.0,0.0,0.0,0.0};

                vector_1[0] = abs(ev.getEntry(0))/evd;
                vector_1[1] = abs(ev.getEntry(1))/evd;
                vector_1[2] = abs(ev.getEntry(2))/evd;
                vector_1[3] = abs(ev.getEntry(3))/evd;
                vector_1[4] = abs(ev.getEntry(4))/evd;



                Log.i("shape",String.valueOf(ev.getEntry(0)));
                Log.i("shape",String.valueOf(ev.getEntry(1)));
                Log.i("shape",String.valueOf(ev.getEntry(2)));
                Log.i("shape",String.valueOf(ev.getEntry(3)));
                Log.i("shape",String.valueOf(ev.getEntry(4)));













                Intent intent = new Intent(MainActivity.this, MainActivityB.class);


                intent.putExtra("vector_1", vector_1);


                startActivity(intent);


            }
        });
    }
};

