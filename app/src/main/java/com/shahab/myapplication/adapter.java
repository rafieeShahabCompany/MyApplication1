package com.shahab.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.HolderActivity> {
    List<String> myList;
    public adapter(List<String> List){
      myList = List;
    }


    @NonNull
    @Override
    public HolderActivity onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View X = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,
                false);
        HolderActivity holder = new HolderActivity(X);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderActivity holder, int position) {
       String Menu = myList.get(position);
       holder.txtItem.setText(Menu);


    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    class HolderActivity extends RecyclerView.ViewHolder{


        TextView txtItem;

        public HolderActivity(@NonNull View itemView) {
            super(itemView);
            txtItem = itemView.findViewById(R.id.txtItem);
        }
    }

}
