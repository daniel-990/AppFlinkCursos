package com.example.crud_php;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class agregar extends AppCompatActivity {

    EditText t_nombre, t_url, t_categoria, t_descripcion;
    Button btn_insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        t_nombre = findViewById(R.id.nombre);
        t_url = findViewById(R.id.url);
        t_categoria = findViewById(R.id.categoria);
        t_descripcion = findViewById(R.id.descripcion);

        btn_insert = findViewById(R.id.btnInsert);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insertData();
            }
        });
    }

    private void insertData() {

        final String nombre = t_nombre.getText().toString().trim();
        final String urlCurso = t_url.getText().toString().trim();
        final String categoria = t_categoria.getText().toString().trim();
        final String descripcion = t_descripcion.getText().toString().trim();


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("cargando...");

        if(nombre.isEmpty()){
            Toast.makeText(this, "Ingrese nombre del curso", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(urlCurso.isEmpty()){
            Toast.makeText(this, "Ingrese Url del curso", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(categoria.isEmpty()){
            Toast.makeText(this, "Ingrese categoria del curso", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(descripcion.isEmpty()){
            Toast.makeText(this, "Ingrese descripcion del curso", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "https://dbcusos.herokuapp.com/cursos",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response.equalsIgnoreCase("datas insertados")){
                                Toast.makeText(agregar.this, "datas insertados", Toast.LENGTH_SHORT).show();

                                progressDialog.dismiss();
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();
                            }
                            else{
                                Toast.makeText(agregar.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(agregar.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    params.put("nombreCurso",nombre);
                    params.put("urlCurso",urlCurso);
                    params.put("categoria",categoria);
                    params.put("descripcion",descripcion);

                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(agregar.this);
            requestQueue.add(request);

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}