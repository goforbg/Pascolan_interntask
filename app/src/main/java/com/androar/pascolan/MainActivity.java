package com.androar.pascolan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView; //List of topics
    Button btnNext; //Bottom Button Next.
    public ArrayList<Topic> topics; //List of all JSON topics as object containing name,thumbnail,etc
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter myAdapter;


    public interface OnTopicsListener {
        void onTopicsCompleted(ArrayList<Topic> topics);
        void onTopicsError(String error);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fetching objects from JSON
        FetchJson fetchData = new FetchJson(getApplicationContext());
        //Fetching ends

        //Recyclerview starts
        topics = new ArrayList<Topic>();
        topics = fetchData.execute();
        recyclerView = (RecyclerView) findViewById(R.id.rvTopics);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        if (topics != null) {
            myAdapter = new TopicAdapter(this, topics);
        }
        myAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(myAdapter);
        //Recyclerviewends

        //Button starts
        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Thanks for the opportunity team!" , Toast.LENGTH_SHORT).show();
            }
        });
        //Button Ends
    }




}

