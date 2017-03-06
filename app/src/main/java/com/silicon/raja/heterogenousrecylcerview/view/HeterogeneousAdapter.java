package com.silicon.raja.heterogenousrecylcerview.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.silicon.raja.heterogenousrecylcerview.R;
import com.silicon.raja.heterogenousrecylcerview.model.ItemModel;
import java.util.List;

public class HeterogeneousAdapter extends RecyclerView.Adapter<HeterogeneousAdapter.ViewHolder> {

  private List<ItemModel> itemModels;
  private ItemListener myListener;

  public HeterogeneousAdapter(List<ItemModel> items, ItemListener listener) {
    itemModels = items;
    myListener = listener;
  }

  public void setListener(ItemListener listener) {
    myListener = listener;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_recyclerview, parent, false));
  }

  @Override public int getItemCount() {
    return itemModels.size();
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    holder.setData(itemModels.get(position));
  }

  public interface ItemListener {
    void onItemClick(ItemModel item);
  }

  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    // TODO - Your view members
    public ItemModel item;

    public ViewHolder(View itemView) {
      super(itemView);
      itemView.setOnClickListener(this);
    }

    public void setData(ItemModel item) {
      this.item = item;
    }

    @Override public void onClick(View v) {
      if (myListener != null) {
        myListener.onItemClick(item);
      }
    }
  }
}
                                