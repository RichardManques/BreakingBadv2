package com.example.breakingbadprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail_activity_character extends AppCompatActivity {

    String nombre, apodo, imagen, fecha, estado, ocupacion, series;
    TextView d_nombre, d_apodo, d_fecha, d_estado, d_ocupacion, d_series;
    ImageView d_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_character);

        nombre = getIntent().getStringExtra("NOMBRE");
        apodo = getIntent().getStringExtra("APODO");
        imagen = getIntent().getStringExtra("IMAGEN");
        fecha = getIntent().getStringExtra("FECHA");
        estado = getIntent().getStringExtra("ESTADO");
        ocupacion = getIntent().getStringExtra("OCUPACION");
        series = getIntent().getStringExtra("SERIES");

        d_nombre = findViewById(R.id.nombre_det);
        d_apodo = findViewById(R.id.apodo_det);
        d_fecha = findViewById(R.id.fecha_det);
        d_estado = findViewById(R.id.estado_det);
        d_ocupacion = findViewById(R.id.ocupacion1_det);
        d_series = findViewById(R.id.serie1_det);
        d_img = findViewById(R.id.image_det);


        d_nombre.setText(nombre);
        d_apodo.setText(apodo);
        d_fecha.setText(fecha);
        d_estado.setText(estado);
        d_ocupacion.setText(ocupacion);
        d_series.setText(series);
        Glide.with(this).load(imagen).into(d_img);

    }
}