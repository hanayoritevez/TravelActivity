package com.example.travelapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.support.annotation.NonNull;
//
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import androidx.recyclerview.widget.ItemTouchHelper;
//import androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.recyclerview.widget.LinearLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class MainActivity4 extends AppCompatActivity {

//    private RecyclerView.Adapter adapter;
//    private List<String> dataset = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main4);
//
//        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
//
//
//
//        int i = 0;
//        while(i<20){
//            String str = String.format(Locale.US, "Data_0%d",i);
//            dataset.add(str);
//            i++;
//        }
//
//        adapter = new MyAdapter(dataset);
//        recyclerView.setAdapter(adapter);
//
//        recyclerView.setHasFixedSize(true);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//
//        ItemTouchHelper mIth  = new ItemTouchHelper(
//                new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN ,
//                        ItemTouchHelper.LEFT) {
//
//                    @Override
//                    public boolean onMove(@NonNull RecyclerView recyclerView,
//                                          @NonNull RecyclerView.ViewHolder viewHolder,
//                                          @NonNull RecyclerView.ViewHolder target) {
//
//                        final int fromPos = viewHolder.getAdapterPosition();
//                        final int toPos = target.getAdapterPosition();
//                        adapter.notifyItemMoved(fromPos, toPos);
//                        return true;// true if moved, false otherwise
//                    }
//
//                    @Override
//                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//                        final int fromPos = viewHolder.getAdapterPosition();
//                        dataset.remove(fromPos);
//                        adapter.notifyItemRemoved(fromPos);
//                    }
//                });
//
//        mIth.attachToRecyclerView(recyclerView);
//    }
//}


    private static final String[][] names = {{ "金沢城", "21世紀美術館", "兼六園",
            "山中温泉", "近江町市場"},{
            "見附島", "和倉温泉", "のと島水族館",
            "富来海岸", "白米千枚田"
    }};

    private static final String[][] explains = {{"多彩な石垣で有名","前衛芸術の聖地","日本三大名園の一つ","こおろぎ橋が人気","新鮮な海の幸が食べられる"},
            {"28メートルの巨大な奇岩", "オーシャンビューが楽しめる温泉", "ジンベイザメが見れる水族館",
            "世界一長いベンチのある砂浜", "世界農業遺産に登録された千枚田"}};

    // それぞれの画像ファイルをdarawableに入れます
    // ArrayListにコピーするためintからInteger型にしました
    private static final Integer[][] photos = {{R.drawable.kaga1, R.drawable.kaga2,
            R.drawable.kaga3, R.drawable.kaga4,
            R.drawable.kaga5},{
            R.drawable.noto1, R.drawable.noto2,
            R.drawable.noto3, R.drawable.noto4,
            R.drawable.noto5
    }};



    private static final Double[][][] locations = {{{36.565065, 136.661815}, {36.561298, 136.658746},
            {36.561801, 136.662776}, {36.240959, 136.371385},{36.571914, 136.656344}},
            {{37.397611, 137.243852}, {37.088809, 136.915810}, {37.148257, 136.982527}, {37.139785, 136.724411}, {37.425590, 137.000209}
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        Intent intent = getIntent();
        int number=0;
        intent.getIntExtra("number",number);

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager rLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(rLayoutManager);


        // 配列をArrayListにコピー
        List<String> itemNames = new ArrayList<>(Arrays.asList(names[number]));
        List<Integer> itemImages = new ArrayList<>(Arrays.asList(photos[number]));
        List<String> itemExplains = new ArrayList<>(Arrays.asList(explains[number]));
        ArrayList<Double>  itemLocations_lon = new ArrayList<>(Arrays.asList(locations[number][0]));
        ArrayList<Double>  itemLocations_lat = new ArrayList<>(Arrays.asList(locations[number][1]));

        List<ArrayList<Double>> itemLocations = new ArrayList<>();
        for(int i=0;i<locations[0].length;i++){
            ArrayList<Double>  lon_lat = new ArrayList<Double>(Arrays.asList(locations[number][i][0],locations[number][i][1]));
            itemLocations.add(lon_lat);
        }




        itemLocations.add(itemLocations_lon);
        itemLocations.add(itemLocations_lat);





//        for(String s : itemNames){
//            String str = String.format(Locale.ENGLISH, "%s@gmail.com", s);
//            itemEmails.add(str);
//        }

        // specify an adapter (see also next example)
        RecyclerView.Adapter rAdapter = new MyAdapter(itemImages, itemNames, itemExplains,itemLocations);
        recyclerView.setAdapter(rAdapter);



    ItemTouchHelper mIth  = new ItemTouchHelper(
            new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN ,
                    ItemTouchHelper.LEFT) {

                @Override
                public boolean onMove(@NonNull RecyclerView recyclerView,
                                      @NonNull RecyclerView.ViewHolder viewHolder,
                                      @NonNull RecyclerView.ViewHolder target) {

                    final int fromPos = viewHolder.getAdapterPosition();
                    final int toPos = target.getAdapterPosition();
                    rAdapter.notifyItemMoved(fromPos, toPos);
                    return true;// true if moved, false otherwise
                }

                @Override
                public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                    final int fromPos = viewHolder.getAdapterPosition();
                    itemExplains.remove(fromPos);
                    itemNames.remove(fromPos);
                    itemImages.remove(fromPos);
                    itemLocations.remove(fromPos);
                    rAdapter.notifyItemRemoved(fromPos);
                }
            });

        mIth.attachToRecyclerView(recyclerView);


        findViewById(R.id.button_forward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity4.this, MainActivity5.class);


                ContentValues cv = new ContentValues();

//
//                LocationElement = LocationElement();
//
//                intent.putExtra("itemExplains", itemExplains);
//                intent.putExtra("itemNames", itemNames);




                startActivity(intent);


            }
        });
}
}