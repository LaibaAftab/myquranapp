package com.example.myquran;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class surahAdapter extends RecyclerView.Adapter<surahAdapter.Myholder>{

    private List<modelsurah>ModelSurah;
    public surahAdapter(List<modelsurah>ModelSurah){this.ModelSurah = ModelSurah;}
    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.suratitem,parent,false);
        return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder,int position) {

        String eng = ModelSurah.get(position).getEnglish();
        String urdu = ModelSurah.get(position).getUrdu();
        holder.english.setText(eng);
        holder.urdu.setText(urdu);
    }

    @Override
    public int getItemCount() {
        return ModelSurah.size();
    }

    public class Myholder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView urdu;
        private TextView english;
        public Myholder(@NonNull View view)
        {
            super(view);
            urdu = view.findViewById(R.id.Urdu);
            english = view.findViewById(R.id.English);
            urdu.setOnClickListener(this);
            english.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
        {
            Intent i = new Intent(view.getContext(),translation.class);
            i.putExtra("ok",english.getText().toString());
            view.getContext().startActivity(i);
        }

    }
}
