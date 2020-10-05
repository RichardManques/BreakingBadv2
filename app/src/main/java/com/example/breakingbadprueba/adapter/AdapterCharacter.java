package com.example.breakingbadprueba.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
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
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CharacterHolder extends RecyclerView.ViewHolder{
        ImageView item_img;
        TextView item_name;
        public CharacterHolder(@NonNull View itemView) {//asociado al item
            super(itemView);
            item_img = itemView.findViewById(R.id.item_img);
            item_name = itemView.findViewById(R.id.item_name);
        }
    }

}
