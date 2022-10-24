package com.example.crud_php;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class editar extends AppCompatActivity {

    EditText edId, edNombre, edUrlCurso, edCategoria, edDescripcion;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        edId = findViewById(R.id.id);
        edNombre = findViewById(R.id.nombre);
        edUrlCurso = findViewById(R.id.url);
        edCategoria = findViewById(R.id.categoria);
        edDescripcion = findViewById(R.id.descripcion);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        edId.setText(MainActivity.employeeArrayList.get(position).getId());
        edNombre.setText(MainActivity.employeeArrayList.get(position).getNombre());
        edUrlCurso.setText(MainActivity.employeeArrayList.get(position).getUrlCurso());
        edCategoria.setText(MainActivity.employeeArrayList.get(position).getCategoria());
        edDescripcion.setText(MainActivity.employeeArrayList.get(position).getDescripcion());
    }

    public void actualizar(View view) {
        final String id = edId.getText().toString();
        final String nombre = edNombre.getText().toString();
        final String urlCurso = edUrlCurso.getText().toString();
        final String categoria = edCategoria.getText().toString();
        final String descripcion = edDescripcion.getText().toString();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Actualizando....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.PUT, "https://dbcusos.herokuapp.com/cursos/" + id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.equalsIgnoreCase("datas insertados")){
                            Toast.makeText(editar.this, "datas insertados", Toast.LENGTH_SHORT).show();

                            progressDialog.dismiss();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            finish();
                        }
                        else{
                            Toast.makeText(editar.this, response, Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                params.put("id",id);
                params.put("nombreCurso",nombre);
                params.put("urlCurso",urlCurso);
                params.put("categoria",categoria);
                params.put("descripcion",descripcion);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(editar.this);
        requestQueue.add(request);
    }
}