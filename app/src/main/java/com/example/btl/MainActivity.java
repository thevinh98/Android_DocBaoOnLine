package com.example.btl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    Button tdva, dvb,tyt,tratu,dtbqt;
    String url_Data = "http://192.168.137.1:8081/android/GetData.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        GetData(url_Data);
        tdva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_comback_tdva = new Intent(MainActivity.this, dictionaryva.class);
                startActivity(intent_comback_tdva);
            }
        });
        dvb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_comback_dvb = new Intent(MainActivity.this, translate.class);
                startActivity(intent_comback_dvb);
            }

        });
        tyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_comback_dvb = new Intent(MainActivity.this, Main_Activity_tuyeuthich.class);
                startActivity(intent_comback_dvb);
            }

        });
        tratu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_comback_dvb = new Intent(MainActivity.this, Main_Activity_tratu.class);
                startActivity(intent_comback_dvb);
            }

        });
        dtbqt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_comback_dvb = new Intent(MainActivity.this, Main_Activity_DTBQT.class);
                startActivity(intent_comback_dvb);
            }

        });

    }

    private void AnhXa() {
        tdva = (Button) findViewById(R.id.btnTDVA);
        dvb = (Button) findViewById(R.id.btnDVB);
        tyt = (Button) findViewById(R.id.btnTYT);
        tratu = (Button) findViewById(R.id.btnTVQT);
        dtbqt = (Button) findViewById(R.id.btnTDT);
    }

    private void GetData(String url)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

}
