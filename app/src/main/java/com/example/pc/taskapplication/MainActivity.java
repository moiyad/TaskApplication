package com.example.pc.taskapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
//    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        listView = (ListView) findViewById(R.id.listViewHeroes);

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<Example> call = api.getExample();


        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                Example example = response.body();
                Rates rates = response.body().getRates();


                Log.d("rate AUD  ",String.valueOf(rates.getAUD()));
                Log.d("rate BGN  ",String.valueOf(rates.getBGN()));
                Log.d("rate BRL  ",String.valueOf(rates.getBRL()));
                Log.d("rate CAD  ",String.valueOf(rates.getCAD()));
                Log.d("rate CHF  ",String.valueOf(rates.getCHF()));



//                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, ratesArr));
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });
    }
}
