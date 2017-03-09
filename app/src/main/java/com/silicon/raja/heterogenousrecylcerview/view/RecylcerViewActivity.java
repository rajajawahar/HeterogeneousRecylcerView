package com.silicon.raja.heterogenousrecylcerview.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.silicon.raja.heterogenousrecylcerview.R;
import com.silicon.raja.heterogenousrecylcerview.model.ItemModel;
import com.silicon.raja.heterogenousrecylcerview.model.SectionModel;
import java.util.ArrayList;
import java.util.List;

public class RecylcerViewActivity extends AppCompatActivity {

  List<SectionModel> itemList = new ArrayList<>();
  RecyclerView my_recycler_view;
  HeterogeneousPrimaryAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recylcer_view);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null)
            .show();
      }
    });
    createDummyData();
    my_recycler_view = (RecyclerView) findViewById(R.id.recyclerView);
    my_recycler_view.setHasFixedSize(true);
    adapter = new HeterogeneousPrimaryAdapter(itemList, this);
    my_recycler_view.setLayoutManager(
        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    my_recycler_view.setAdapter(adapter);
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_recylcer_view, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  private void createDummyData() {
    for (int i = 1; i <= 5; i++) {
      SectionModel dm = new SectionModel();
      dm.setHeaderTitle("Section " + i);
      ArrayList<ItemModel> singleItem = new ArrayList<ItemModel>();
      for (int j = 0; j <= 5; j++) {
        singleItem.add(new ItemModel("Item " + j, "URL " + j));
      }
      dm.setAllItemsInSection(singleItem);
      itemList.add(dm);
    }
  }
}
