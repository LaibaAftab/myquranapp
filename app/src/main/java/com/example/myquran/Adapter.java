package com.example.myquran;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Modelclass> ayatList;
    public Adapter(List<Modelclass>ayatList)
    {
        this.ayatList = ayatList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        int resource = ayatList.get(position).getNumber();
        String ar = ayatList.get(position).getArabic();
        String ur = ayatList.get(position).getTrans();
        holder.setData(resource,ar,ur);

    }

    @Override
    public int getItemCount() {
        return ayatList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        // implements View.OnClickListener

        private TextView number;
        private TextView arabic;
        private TextView trans;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number =itemView.findViewById(R.id.number);
            arabic = itemView.findViewById(R.id.arofrecycler);
            trans = itemView.findViewById(R.id.urofrecycler);
//            number.setOnClickListener(this);
        }
//        @Override
//        public void onClick(View view)
//        {
//
//        }

        public void setData(int n,String ar,String ur)
        {
            number.setText(Integer.toString(n));
            arabic.setText(ar);
            trans.setText(ur);
        }

    }
}
