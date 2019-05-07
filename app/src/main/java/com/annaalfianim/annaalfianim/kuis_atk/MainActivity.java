package com.annaalfianim.annaalfianim.kuis_atk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.annaalfianim.annaalfianim.kuis_atk.models.AtkModel;
import com.annaalfianim.annaalfianim.kuis_atk.networks.BaseListResponse;
import com.annaalfianim.annaalfianim.kuis_atk.services.AtkService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_atk;
    private AtkService atkService = Api.getAtkService();
    private ArrayList<AtkModel> atkList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rv_atk = findViewById(R.id.rv_atk);
        rv_atk.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,UploadActivity.class));
            }
        });
    }

    private void fetchData(){
        atkList.clear();
        atkService.all().enqueue(new Callback<BaseListResponse<AtkModel>>() {
            @Override
            public void onResponse(Call<BaseListResponse<AtkModel>> call, Response<BaseListResponse<AtkModel>> response) {
                if (response.isSuccessful()){
                    BaseListResponse<AtkModel> body = response.body();
                    if (body!=null && body.getStatus()==1){
                        Toast.makeText(MainActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                        atkList= (ArrayList<AtkModel>) body.getData();
                        rv_atk.setAdapter(new AtkAdapter(atkList, MainActivity.this));
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Tidak Dapat Mengambil Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BaseListResponse<AtkModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Tidak Dapat Terhubung", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        atkList.clear();
        fetchData();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
