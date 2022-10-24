package com.example.crud_php;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter<Cursos> {

Context context;
List<Cursos> arrayCursos;

    public Adapter(@NonNull Context context, List<Cursos> arrayCursos) {
        super(context, R.layout.list_usuarios,arrayCursos);
        this.context =context;
        this.arrayCursos =arrayCursos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_usuarios,null,true);

        /*TextView tvId = view.findViewById(R.id.txt_id);*/
        TextView tvNombre = view.findViewById(R.id.textnombre);

        /*tvId.setText(arrayCursos.get(position).getId());*/
        tvNombre.setText(arrayCursos.get(position).getNombre());

        return view;
    }
}
