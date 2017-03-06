package com.silicon.raja.heterogenousrecylcerview.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.silicon.raja.heterogenousrecylcerview.R;
import com.silicon.raja.heterogenousrecylcerview.model.ItemModel;
import java.util.ArrayList;

/**
 * Created by rajamohamed on 06/03/17.
 */

public class HeterogeneousSecondaryAdapter
    extends RecyclerView.Adapter<HeterogeneousSecondaryAdapter.SingleItemRowHolder> {

  private ArrayList<ItemModel> itemsList;
  private Context mContext;

  public HeterogeneousSecondaryAdapter(Context context, ArrayList<ItemModel> itemsList) {
    this.itemsList = itemsList;
    this.mContext = context;
  }

  @Override public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_secondary, null);
    SingleItemRowHolder mh = new SingleItemRowHolder(v);
    return mh;
  }

  @Override public void onBindViewHolder(SingleItemRowHolder holder, int i) {

    ItemModel singleItem = itemsList.get(i);
    holder.tvTitle.setText(singleItem.getName());
  }

  @Override public int getItemCount() {
    return (null != itemsList ? itemsList.size() : 0);
  }

  public class SingleItemRowHolder extends RecyclerView.ViewHolder {

    protected TextView tvTitle;

    protected ImageView itemImage;

    public SingleItemRowHolder(View view) {
      super(view);

      this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
      this.itemImage = (ImageView) view.findViewById(R.id.itemImage);

      view.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();
        }
      });
    }
  }
}
