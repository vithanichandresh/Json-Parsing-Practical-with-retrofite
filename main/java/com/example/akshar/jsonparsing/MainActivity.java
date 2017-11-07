package com.example.akshar.jsonparsing;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView recyclerView;
    int Position;
    private String TAG = getClass().getSimpleName();
    private MyAdapter adapter;
    private ArrayList<DataModel> arrayList;
    DataModel model;
    Activity context = MainActivity.this;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(ListView) findViewById(R.id.recyclerView);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.getJsonData("").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Response<ResponseBody> response) {
                try {

                    arrayList=new ArrayList<DataModel>();
                    String json=response.body().string().toString();
                    Log.i(TAG, "onResponse: "+json);
                    JSONObject object=new JSONObject(json);
                    JSONArray array=object.getJSONArray("results");
                    for (int i = 0; i < array.length(); i++) {
                        model=new DataModel();
                        JSONObject object1=array.getJSONObject(i);
                        JSONObject object2=object1.getJSONObject("geometry");
                        JSONObject object3=object2.getJSONObject("location");
                        model.setName(object1.getString("name"));
                        model.setIconUrl(object1.getString("icon"));
                        model.setLat(object3.getString("lat"));
                        model.setLng(object3.getString("lng"));
                        arrayList.add(model);
                    }
                    adapter=new MyAdapter(context,arrayList);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i(TAG, "onFailure: "+t);
                Toast.makeText(context, ""+t, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(context,MapsActivity.class);
                intent.putExtra("map",arrayList.get(i));
                startActivity(intent);
            }
        });
    }
}
