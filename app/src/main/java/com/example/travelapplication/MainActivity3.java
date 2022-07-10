package com.example.travelapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.log10;


public class MainActivity3 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String[] names = {
            "加賀地方（マッチ度: 90%）", "能登地方(マッチ度: 70%)"
    };

    private static final String[] names_en = {
            "kaga", "noto"
    };

    // それぞれの画像ファイルをdarawableに入れます
    // ArrayListにコピーするためintからInteger型にしました
    private static final int[] photos = {
            R.drawable.kaga1, R.drawable.noto1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Intent intent = getIntent();

        final double[] vector_1 = intent.getDoubleArrayExtra("vector_1");
        final double[] vector_2 = intent.getDoubleArrayExtra("vector_2");
        final double[] vector_3 = intent.getDoubleArrayExtra("vector_3");
        final double[] vector_4 = intent.getDoubleArrayExtra("vector_4");



        List<String> xAxisValue = new ArrayList<>();//X-axis data source
        xAxisValue.add("緊張緩和");
        xAxisValue.add("娯楽追及");
        xAxisValue.add("関係強化");
        xAxisValue.add("知識増進");
        xAxisValue.add("自己拡大");


        List<String> xAxisValue2 = new ArrayList<>();//X-axis data source
        xAxisValue2.add("食事");
        xAxisValue2.add("娯楽");
        xAxisValue2.add("観光");
        xAxisValue2.add("宿泊");

        RadarChart radarChart,radarChart2;//radar

        radarChart = findViewById(R.id.RadarChart);
        radarChart.getDescription().setEnabled(false);

        XAxis xAxis = radarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawLabels(false);
        xAxis.setGranularity(1f);
        xAxis.setTextSize(20);
        xAxis.setLabelCount(xAxisValue.size());
        xAxis.setCenterAxisLabels(true);//Set the label to center
        xAxis.setValueFormatter(new

                IndexAxisValueFormatter(xAxisValue));


        YAxis yAxis = radarChart.getYAxis();
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(80f);




        float F1 = (float)(log10(vector_1[0]*100.)/2.0);
        float F2 = (float)(log10(vector_1[1]*100.)/2.0);
        float F3 = (float)(log10(vector_1[2]*100.)/2.0);
        float F4 = (float)(log10(vector_1[3]*100.)/2.0);
        float F5 = (float)(log10(vector_1[4]*100.)/2.0);

        List<RadarEntry> radarEntries = new ArrayList<>();
        radarEntries.add(new

                RadarEntry(F1*100f));
        radarEntries.add(new

                RadarEntry(F2*100f));
        radarEntries.add(new

                RadarEntry(F3*100f));
        radarEntries.add(new

                RadarEntry(F4*100f));
        radarEntries.add(new

                RadarEntry(F5*100f));



        RadarDataSet radarDataSet = new RadarDataSet(radarEntries,"嗜好タイプ");
        // Solid fill area color
        radarDataSet.setFillColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        // Whether to fill the area solidly
        radarDataSet.setDrawFilled(true);
        RadarData radarData = new RadarData(radarDataSet);

        radarChart.setData(radarData);
        radarChart.getXAxis().setDrawLabels(true);
        radarChart.getYAxis().setDrawLabels(false);

////////radar chart2 ///////////////////////


        radarChart2 = findViewById(R.id.RadarChart2);
        radarChart2.getDescription().setEnabled(false);

        XAxis xAxis2 = radarChart2.getXAxis();
        xAxis2.setPosition(XAxis.XAxisPosition.TOP);
        xAxis2.setDrawGridLines(false);
        xAxis2.setDrawLabels(false);
        xAxis2.setGranularity(1f);
        xAxis2.setTextSize(20);
        xAxis2.setLabelCount(xAxisValue2.size());
        xAxis2.setCenterAxisLabels(true);//Set the label to center
        xAxis2.setValueFormatter(new
                IndexAxisValueFormatter(xAxisValue2));


        YAxis yAxis2 = radarChart2.getYAxis();
        yAxis2.setAxisMinimum(0f);
        yAxis2.setAxisMaximum(80f);




        float F21 = (float)(log10(vector_2[0]*100.)/2.0);
        float F22 = (float)(log10(vector_2[1]*100.)/2.0);
        float F23 = (float)(log10(vector_2[2]*100.)/2.0);
        float F24 = (float)(log10(vector_2[3]*100.)/2.0);

        List<RadarEntry> radarEntries2 = new ArrayList<>();
        radarEntries2.add(new

                RadarEntry(F21*100f));
        radarEntries2.add(new

                RadarEntry(F22*100f));
        radarEntries2.add(new

                RadarEntry(F23*100f));
        radarEntries2.add(new

                RadarEntry(F24*100f));


        RadarDataSet radarDataSet2 = new RadarDataSet(radarEntries2,"嗜好タイプ");
        // Solid fill area color
        radarDataSet2.setFillColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        // Whether to fill the area solidly
        radarDataSet2.setDrawFilled(true);
        RadarData radarData2 = new RadarData(radarDataSet2);

        radarChart2.setData(radarData2);
        radarChart2.getXAxis().setDrawLabels(true);
        radarChart2.getYAxis().setDrawLabels(false);



        ///////////////////////////////////////////////////////////////////


        MeasuredListView listView = findViewById(R.id.list_view);

        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル list.xml を activity_main.xml に
        // inflate するためにadapterに引数として渡す
        BaseAdapter adapter = new ListViewAdapter(this.getApplicationContext(),
                R.layout.my_list_view_simple, names, photos);

        // ListViewにadapterをセット
        listView.setAdapter(adapter);

        // クリックリスナーをセット
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v,
                            int position, long id) {

        Intent intent = new Intent(
                this.getApplicationContext(), MainActivity4.class);

        // clickされたpositionのtextとphotoのID
        String selectedText = names_en[position];
        // インテントにセット
        intent.putExtra("number", position);

        // SubActivityへ遷移
        startActivity(intent);
    }


}
