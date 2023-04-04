package com.example.retrofitexample.retrofit_basico.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitexample.R;
import com.example.retrofitexample.retrofit_basico.result_api.apicharacter.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {
    private List<Result> resultsCharacters;


    public CharacterAdapter(List<Result> resultsCharacters) {
        this.resultsCharacters = resultsCharacters;

    }

    @NonNull
    @Override
    public CharacterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_character_list_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.ViewHolder holder, int position) {
        holder.txt_name_character.setText(resultsCharacters.get(position).getName());
        Picasso.with(holder.img_character.getContext()).load(resultsCharacters.get(position).getImage()).into(holder.img_character);
    }

    @Override
    public int getItemCount() {
        return resultsCharacters.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_character;
        private TextView txt_name_character;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_character = itemView.findViewById(R.id.img_character);
            txt_name_character = itemView.findViewById(R.id.text_nombre);

        }

    }

}
