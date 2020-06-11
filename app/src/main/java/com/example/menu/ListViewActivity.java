package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ListViewActivity extends AppCompatActivity {

    ListView mainListView;
    ArrayList<String> planetList;
    ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mainListView = findViewById(R.id.mainListView);

        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter",
                "Satan", "Uranus", "Neptune", "Pluto"};

        planetList = new ArrayList<String>();
        planetList.addAll(Arrays.asList(planets));

        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, planets);
        mainListView.setAdapter(listAdapter);

        mainListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        mainListView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.listview_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.remove:
                        Toast.makeText(ListViewActivity.this, "Function to remove item", Toast.LENGTH_SHORT).show();
                        //deleteSelectedItem();
                        mode.finish();
                        break;

                    case R.id.refresh:
                        Toast.makeText(ListViewActivity.this, "Refreshed", Toast.LENGTH_SHORT).show();
                        mode.finish();
                        break;

                    default:
                        return false;
                }
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
            }
        });
    }
}