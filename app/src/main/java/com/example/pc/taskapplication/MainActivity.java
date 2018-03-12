package com.example.pc.taskapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference base =database.getReference("base");
        final DatabaseReference date =database.getReference("date");
        final DatabaseReference rate =database.getReference("rates");



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

                base.setValue(example.getBase());
                date.setValue(example.getDate());

                rate.child("AUD").setValue(rates.getAUD());
                rate.child("BGN").setValue(rates.getBGN());
                rate.child("BRL").setValue(rates.getBRL());




            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });
    }
}
