package com.example.breakingbadprueba.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.breakingbadprueba.Detail_activity_character;
import com.example.breakingbadprueba.MainActivity;
import com.example.breakingbadprueba.R;
import com.example.breakingbadprueba.model.Character;

import java.util.List;

public class AdapterCharacter extends RecyclerView.Adapter<AdapterCharacter.CharacterHolder> {
    public Activity activity;
    public List<Character> list;
    public int item_character;

    public AdapterCharacter(Activity activity, List<Character> list, int item_character) {
        this.activity = activity;
        this.list = list;
        this.item_character = item_character;
    }

    public AdapterCharacter(MainActivity mainActivity, List<java.lang.Character> list, int item_character) {

    }

    @NonNull
    @Override
    public CharacterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(item_character,parent,false);
        return new CharacterHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CharacterHolder holder, int position) {
        Character character = list.get(position);//sacar cada personaje de la lista(API)
        holder.item_name.setText(character.name);
        Glide.with(activity).load(character.img).into(holder.item_img);

        holder.apodo = character.apodo;
        holder.fecha = character.fecNac;
        holder.estado = character.estado;
        holder.ocupacion = character.ocupacion;
        holder.series = character.serie;
        holder.urlImg = character.img;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CharacterHolder extends RecyclerView.ViewHolder{
        ImageView item_img;
        TextView item_name;
        String apodo, fecha, estado, ocupacion, series, urlImg;
        RelativeLayout item_panel;

        public CharacterHolder(@NonNull View itemView) {//asociado al item
            super(itemView);
            item_img = itemView.findViewById(R.id.item_img);
            item_name = itemView.findViewById(R.id.item_name);

            item_panel = itemView.findViewById(R.id.item_panel);

            item_panel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intento = new Intent(activity, Detail_activity_character.class);

                    intento.putExtra("NOMBRE", item_name.getText().toString());
                    intento.putExtra("APODO", apodo);
                    intento.putExtra("IMAGEN", urlImg);
                    intento.putExtra("FECHA", fecha);
                    intento.putExtra("ESTADO", estado);
                    intento.putExtra("OCUPACION", ocupacion);
                    intento.putExtra("SERIES", series);

                    activity.startActivity(intento);


                }
            });

        }
    }

}
