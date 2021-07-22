package com.example.androidpracticals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidpracticals.Adapter.RecentsAdapter;
import com.example.androidpracticals.Adapter.TopPlacesAdapter;
import com.example.androidpracticals.Model.RecentData;
import com.example.androidpracticals.Model.TopPlacesData;

import java.util.ArrayList;
import java.util.List;

public class vacationApp extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;

    TextView textView_sell_all;
    ImageView book_flight, book_hotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_app);

        textView_sell_all = (TextView)findViewById(R.id.textView4);
        textView_sell_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vacationApp.this,see_all.class);
                startActivity(intent);
            }
        });

        book_flight = (ImageView)findViewById(R.id.book_flight);
        book_hotel = (ImageView)findViewById(R.id.book_hotel);

        book_flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.goibibo.com/flights/"));
                startActivity(intent);
            }
        });


        book_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.goibibo.com/hotels/"));
                startActivity(intent);
            }
        });

        List<RecentData> recentDataList = new ArrayList<>();
        recentDataList.add(new RecentData("New York","USA","From $200",R.drawable.newyork));
        recentDataList.add(new RecentData("Nilgiri","India","From $200",R.drawable.newyork));
        recentDataList.add(new RecentData("New York","USA","From $200",R.drawable.newyork));
        recentDataList.add(new RecentData("Nilgiri","India","From $200",R.drawable.newyork));
        recentDataList.add(new RecentData("New York","USA","From $200",R.drawable.newyork));
        recentDataList.add(new RecentData("Nilgiri","India","From $200",R.drawable.newyork));

        setRecentRecycler(recentDataList);

        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Kashmir Hill","India","$200 - $500",R.drawable.newyork));
        topPlacesDataList.add(new TopPlacesData("Kashmir Hill","India","$200 - $500",R.drawable.newyork));
        topPlacesDataList.add(new TopPlacesData("Kashmir Hill","India","$200 - $500",R.drawable.newyork));
        topPlacesDataList.add(new TopPlacesData("Kashmir Hill","India","$200 - $500",R.drawable.newyork));
        topPlacesDataList.add(new TopPlacesData("Kashmir Hill","India","$200 - $500",R.drawable.newyork));
        topPlacesDataList.add(new TopPlacesData("Kashmir Hill","India","$200 - $500",R.drawable.newyork));

        setTopPlacesRecycler(topPlacesDataList);

    }

    private void setRecentRecycler(List<RecentData> recentDataList){
        recentRecycler = findViewById((R.id.recent_recycler));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this,recentDataList);
        recentRecycler.setAdapter(recentsAdapter);
    }

    private void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList){
        topPlacesRecycler = findViewById((R.id.top_places_recycler));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this,topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);
    }




}