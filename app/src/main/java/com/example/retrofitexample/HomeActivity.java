package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.retrofitexample.mvvm_with_retrofit.RetrofitWithMvvm;
import com.example.retrofitexample.retrofit_basico.model.MainActivity;
import com.example.retrofitexample.retrofit_call_back.model.RetrofitCallBackActivity;
import com.example.retrofitexample.retrofit_cargadinamica.model.RetrofitCargaDinamicaActivity;
import com.example.retrofitexample.retrofit_interceptor.model.RetrofitInterceptorActivity;
import com.example.retrofitexample.retrofit_interceptor_sesion.model.RetrofitInterceptorSesionActivity;
import com.example.retrofitexample.retrofit_interceptor_session_parametro.model.RetrofitInterceptorSessionParameterActivity;
import com.example.retrofitexample.retrofit_time.RetrofitTimeActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        findViewById(R.id.btnRetrofitBasico).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnRetrofitInterceptor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, RetrofitInterceptorActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnRetrofitInterceptorSesion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, RetrofitInterceptorSesionActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnRetrofitTime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, RetrofitTimeActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnRetrofitWhitParameter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, RetrofitInterceptorSessionParameterActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnRetrofitCargaDinamica).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, RetrofitCargaDinamicaActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnRetrofitCallBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, RetrofitCallBackActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnRetrofitWithMvvm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, RetrofitWithMvvm.class);
                startActivity(intent);
            }
        });


    }

}