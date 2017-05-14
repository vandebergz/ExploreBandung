package com.example.evan.explorebandung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evan.explorebandung.data.WisataDbHelper;

import java.util.ArrayList;
import java.util.List;
import com.example.evan.explorebandung.data.DatabaseModel;

public class DetailsActivity extends AppCompatActivity {

    WisataDbHelper helper;
    List<DatabaseModel> dbList;
    int position;
    TextView tvname, tvwisataid, tvaddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        // 5. get status value from bundle
        position = bundle.getInt("position");

        tvname =(TextView)findViewById(R.id.name);
        tvwisataid =(TextView)findViewById(R.id.wisataid);
        tvaddress =(TextView)findViewById(R.id.address);
        helper = new WisataDbHelper(this);
        dbList= new ArrayList<DatabaseModel>();
        dbList = helper.getDataFromDB();

        if(dbList.size()>0){
            String name= dbList.get(position).getPlace();
            String wisataid=dbList.get(position).getIdWisata();
            String address=dbList.get(position).getAddress();
            tvname.setText(name);
            tvwisataid.setText(wisataid);
            tvaddress.setText(address);
        }
        Toast.makeText(DetailsActivity.this, dbList.toString(), Toast.LENGTH_LONG);
    }

        @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
