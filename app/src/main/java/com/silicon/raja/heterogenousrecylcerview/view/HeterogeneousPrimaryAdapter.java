package com.silicon.raja.heterogenousrecylcerview.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.silicon.raja.heterogenousrecylcerview.R;
import com.silicon.raja.heterogenousrecylcerview.model.ItemModel;
import com.silicon.raja.heterogenousrecylcerview.model.SectionModel;
import java.util.ArrayList;
import java.util.List;

public class HeterogeneousPrimaryAdapter
    extends RecyclerView.Adapter<HeterogeneousPrimaryAdapter.ViewHolder> {

  private List<SectionModel> dataList;
  private Context context;

  public HeterogeneousPrimaryAdapter(List<SectionModel> dataList, Context context) {
    this.dataList = dataList;
    this.context = context;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_primary, parent, false));
  }

  @Override public int getItemCount() {
    return dataList.size();
  }

  @Override public void onBindViewHolder(ViewHolder itemRowHolder, int i) {
    final String sectionName = dataList.get(i).getHeaderTitle();
    ArrayList singleSectionItems = dataList.get(i).getAllItemsInSection();
    itemRowHolder.itemTitle.setText(sectionName);
    HeterogeneousSecondaryAdapter itemListDataAdapter =
        new HeterogeneousSecondaryAdapter(context, singleSectionItems);
    itemRowHolder.recycler_view_list.setHasFixedSize(true);
    itemRowHolder.recycler_view_list.setLayoutManager(
        new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
    itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);
    itemRowHolder.recycler_view_list.setNestedScrollingEnabled(false);
    itemRowHolder.btnMore.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Toast.makeText(v.getContext(), "click event on more, " + sectionName, Toast.LENGTH_SHORT)
            .show();
      }
    });
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    protected TextView itemTitle;
    protected RecyclerView recycler_view_list;
    protected Button btnMore;

    public ItemModel item;

    public ViewHolder(View view) {
      super(view);
      this.itemTitle = (TextView) view.findViewById(R.id.itemTitle);
      this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_list);
      this.btnMore = (Button) view.findViewById(R.id.btnMore);
    }

    public void setData(ItemModel item) {
      this.item = item;
    }
  }
}
                                