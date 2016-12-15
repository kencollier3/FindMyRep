package ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.devbrackets.android.recyclerext.adapter.RecyclerListAdapter;
import com.devbrackets.android.recyclerext.adapter.viewholder.ClickableViewHolder;
import model.RepData;
import ui.activity.FullListingActivity;
import ui.adapter.viewholder.RepresentativeViewHolder;

public class RepresentativeListAdapter extends RecyclerListAdapter<RepresentativeViewHolder, RepData> implements ClickableViewHolder.OnClickListener {

    private Context context;
    public RepresentativeListAdapter(Context context) {
        this.context = context;

    }

    @Override
    public RepresentativeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return RepresentativeViewHolder.newInstance(parent, this);
    }

    @Override
    public void onBindViewHolder(RepresentativeViewHolder holder, int position) {
        final RepData data = getItem(position);
        if (data == null) {
            return;
        }
        holder.bindData(data);
    }

    @Override
    public void onClick(@NonNull ClickableViewHolder viewHolder) {
        final RepData data = getItem(viewHolder.getAdapterPosition());
        Intent repListIntent = new Intent(context, FullListingActivity.class);
        repListIntent.putExtra(FullListingActivity.EXTRA_REP_DATE, data);
        context.startActivity(repListIntent);
    }
}
