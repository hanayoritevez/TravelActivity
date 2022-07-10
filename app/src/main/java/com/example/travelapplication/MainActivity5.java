package com.example.travelapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//
//import androidx.recyclerview.widget.ItemTouchHelper;
//import androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.recyclerview.widget.LinearLayoutManager;


public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        Intent intent = getIntent();
        int number=0;
        intent.getIntExtra("number",number);


}
}