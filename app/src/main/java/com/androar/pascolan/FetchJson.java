package com.androar.pascolan;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class FetchJson extends AsyncTask<Void, Void, ArrayList<Topic>> implements Serializable {




    Context mContext;

    public FetchJson(Context context){
        this.mContext = context;
    }

    public ArrayList<Topic> topics = new ArrayList<>();

    String data = "";
    String topicNumber, topicNameEng,topicNameHindi, topicNameImage;


    protected ArrayList<Topic> doInBackground(Void ... params) {
        try {
            URL url = new URL("https://pascolan-config.s3.us-east-2.amazonaws.com/android/v1/prod/Category/hi/category.json");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);

            for (int i = 0; i < JA.length(); i++) {
                JSONObject JO = (JSONObject) JA.get(i);
                if (JO.has("i")){
                    topicNumber = ""+JO.get("i");
                }
                if (JO.has("n")) {
                    topicNameHindi = "" + JO.get("n");
                }
                if (JO.has("a")) {
                    topicNameEng = "" + JO.get("a");
                }
                if (JO.has("p")) {
                    topicNameImage = "" + JO.get("p");
                }
                Log.i("topicNameEng > ",topicNameEng);

                Topic topic = new Topic(topicNumber,topicNameHindi, topicNameEng, topicNameImage);
                topics.add(topic);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return topics;
    }


    @Override
    protected void onPostExecute(ArrayList<Topic> result) {
        super.onPostExecute(result);


    }

}
