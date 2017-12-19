package com.dettofatto.logos;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class PresenzeAssenze extends Activity {

    ListView listaListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presenze_assenze);

        listaListView = findViewById(R.id.listView);

        final String[] listaString = new String[]  {"nome stud 1", "nome stud 2"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaString );
        listaListView.setAdapter(arrayAdapter);

        listaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String varSupport = listaString[position];

                Toast.makeText(PresenzeAssenze.this, varSupport, Toast.LENGTH_SHORT).show();
            }
        });

        listaListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String varSupport = listaString[position];

                Toast.makeText(PresenzeAssenze.this, "CLICK_LONG " + varSupport, Toast.LENGTH_SHORT).show();


                return false;
            }
        });

    }
}
