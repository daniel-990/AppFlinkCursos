package com.example.crud_php;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.MediaController;

public class detalles extends AppCompatActivity {

    TextView tvid,tvnombre,tvcategoria,tvdescripcion;
    VideoView tvVideo;
    int position;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        //Initializing Views
        tvnombre = findViewById(R.id.txtname);
        tvVideo = findViewById(R.id.txtvideo);
        tvcategoria = findViewById(R.id.txtcategoria);
        tvdescripcion = findViewById(R.id.txdescripcion);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        MediaController mediaController = new MediaController(this);
        tvVideo.setMediaController(mediaController);
        mediaController.setAnchorView(tvVideo);

        tvnombre.setText("Name: " + MainActivity.employeeArrayList.get(position).getNombre());
        tvVideo.setVideoURI(Uri.parse(MainActivity.employeeArrayList.get(position).getUrlCurso()));
        tvVideo.start();
        tvcategoria.setText("Categoria: " + MainActivity.employeeArrayList.get(position).getCategoria());
        tvdescripcion.setText("Descripcion: " + MainActivity.employeeArrayList.get(position).getDescripcion());

    }
}