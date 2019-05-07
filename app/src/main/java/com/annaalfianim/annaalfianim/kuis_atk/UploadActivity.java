package com.annaalfianim.annaalfianim.kuis_atk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.annaalfianim.annaalfianim.kuis_atk.models.AtkModel;
import com.annaalfianim.annaalfianim.kuis_atk.networks.BaseResponse;
import com.annaalfianim.annaalfianim.kuis_atk.services.AtkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadActivity extends AppCompatActivity {
    private EditText title,code;
    private Spinner category;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        title = findViewById(R.id.et_title);
        code = findViewById(R.id.et_code);
        category = findViewById(R.id.sp_category);
        fab = findViewById(R.id.fab);
        upload();

    }


    private void upload(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _title = title.getText().toString().trim();
                String _code = code.getText().toString().trim();
                String _category = category.getSelectedItem().toString();
                if (!_title.isEmpty() && !_code.isEmpty() && !_category.isEmpty()){
                    AtkService atkSevice = Api.getAtkService();
                    atkSevice.insert(_title, _code, _category).enqueue(new Callback<BaseResponse<AtkModel>>() {
                        @Override
                        public void onResponse(Call<BaseResponse<AtkModel>> call, Response<BaseResponse<AtkModel>> response) {
                            if (response.isSuccessful()){
                                BaseResponse<AtkModel> body = response.body();
                                if (body.getStatus() == 1){
                                    Toast.makeText(UploadActivity.this, "Data Berhasil DiSimpan", Toast.LENGTH_SHORT).show();
                                    finish();
                                } else {
                                    Toast.makeText(UploadActivity.this, "Tidak Dapat Menyimpan", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(UploadActivity.this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<BaseResponse<AtkModel>> call, Throwable t) {
                            Toast.makeText(UploadActivity.this, "Tidak Dapat Terhubung"+t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                    Toast.makeText(UploadActivity.this, "mohon isi semua form", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
