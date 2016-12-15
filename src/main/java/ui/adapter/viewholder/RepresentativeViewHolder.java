package ui.adapter.viewholder;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devbrackets.android.recyclerext.adapter.viewholder.ClickableViewHolder;

import agency.rain.findmyrep.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import model.RepData;

public class RepresentativeViewHolder extends ClickableViewHolder {
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.cardView)
    CardView cv;

    private RepresentativeViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public static RepresentativeViewHolder newInstance(ViewGroup parent, ClickableViewHolder.OnClickListener listener) {
        final RepresentativeViewHolder viewHolder = new RepresentativeViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.rep_list_item, parent, false));
        viewHolder.setOnClickListener(listener);
        return viewHolder;
    }
    public void bindData(RepData data) {
        name.setText(data.getName());

        if (data.getParty().equals("R")){
            cv.setCardBackgroundColor(ContextCompat.getColor(cv.getContext(), R.color.red));
        }
    }
}
