package com.example.evan.explorebandung;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evan.explorebandung.data.DatabaseModel;
import com.example.evan.explorebandung.data.WisataContract;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.onClick;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.ViewHolder> {

    static   List<DatabaseModel> dbList;
    static  Context context;
    WisataAdapter(Context context, List<DatabaseModel> dbList ){
        this.dbList = new ArrayList<DatabaseModel>();
        this.context = context;
        this.dbList = dbList;

    }

    @Override
    public WisataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.wisata_list, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WisataAdapter.ViewHolder holder, int position) {

        holder.name.setText(dbList.get(position).getPlace());
        holder.email.setText(dbList.get(position).getContact());

    }

    @Override
    public int getItemCount() {
        return dbList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView name,email;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            name = (TextView) itemLayoutView
                    .findViewById(R.id.name_tv);
            email = (TextView)itemLayoutView.findViewById(R.id.contact_tv);
            itemLayoutView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context,DetailsActivity.class);

            Bundle extras = new Bundle();
            extras.putInt("position",getAdapterPosition());
            intent.putExtras(extras);

            context.startActivity(intent);
            Toast.makeText(WisataAdapter.context, "You have clicked row number "
                    + getAdapterPosition(), Toast.LENGTH_LONG).show();
        }
    }
}
