package com.empire.sitpoly.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.empire.sitpoly.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExampleActivity extends AppCompatActivity {

    private Button sendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        sendData = findViewById(R.id.send_data);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
//        Call<List<Example>> call = api.getData();
//        call.enqueue(new Callback<List<Example>>() {
//            @Override
//            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
//                List<Example> examples = response.body();
//                for (Example eg: examples){
//                    Log.d("name",eg.getName());
//                    Log.d("dept",eg.getDept());
//                    Log.d("rollNo",eg.getRollNo());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Example>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });


        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Example example = new Example("Vaibhav","CSE","173");
                Call<Example> call1 = api.sendData(example);
                call1.enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
                        Example example1 = response.body();
                        if (example1 != null){
                            Toast.makeText(getApplicationContext(), example1.getName() + example1.getDept(), Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}