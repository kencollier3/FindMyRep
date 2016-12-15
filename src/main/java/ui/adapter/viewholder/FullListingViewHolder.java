package ui.adapter.viewholder;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devbrackets.android.recyclerext.adapter.viewholder.ClickableViewHolder;

import agency.rain.findmyrep.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import model.RepData;

public class FullListingViewHolder extends ClickableViewHolder {
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.office)
    TextView office;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.link)
    TextView link;
    @BindView(R.id.district)
    TextView district;
    @BindView(R.id.party)
    TextView party;

    private FullListingViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public static ui.adapter.viewholder.FullListingViewHolder newInstance(ViewGroup parent, ClickableViewHolder.OnClickListener listener) {
        final ui.adapter.viewholder.FullListingViewHolder viewHolder = new ui.adapter.viewholder.FullListingViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_full_listing, parent, false));
        viewHolder.setOnClickListener(listener);
        return viewHolder;
    }
    public void bindData(RepData data) {
        name.setText(data.getName());
        office.setText(data.getOffice());
        phone.setText(data.getPhone());
        link.setText(data.getLink());
        district.setText(data.getDistrict());
        party.setText(data.getParty());
    }
}
