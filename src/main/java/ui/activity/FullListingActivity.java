package ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

import agency.rain.findmyrep.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import model.RepData;
import pocketknife.BindExtra;
import pocketknife.PocketKnife;

public class FullListingActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_REP_DATE = "EXTRA_REP_DATA";
    private static final String MAPS_URI = "https://www.google.com/maps/place/";

    @BindExtra(EXTRA_REP_DATE)
    RepData repData;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_listing);
        ButterKnife.bind(this);
        PocketKnife.bindExtras(this);
        name.setText(repData.getName());
        party.setText(getString(R.string.party_text, repData.getParty()));
        district.setText(getString(R.string.district_text, repData.getDistrict()));
        office.setText(underline(getString(R.string.beginning_of_address, repData.getOffice())));
        phone.setText(underline(repData.getPhone()));
        link.setText(underline(repData.getLink()));

        //click listeners
        office.setOnClickListener(this);
        phone.setOnClickListener(this);
        link.setOnClickListener(this);




    }

    public CharSequence underline(@NonNull String string) {
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new UnderlineSpan(), 0, string.length(), 0);
        return spannableString;
    }

    @Override
    public void onClick(View view) {
        if (view == office) {
            sendAddressToMaps(repData.getOffice());
        }
        if (view == phone) {
            dialPhoneNumber(repData.getPhone());
        }
        if (view == link){
            openWebPage(repData.getLink());
        }

    }

    //intents
    public void sendAddressToMaps(String office) {
            final Uri uri = Uri.parse(MAPS_URI + office);
            Intent mapsIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(mapsIntent);
        }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }






}
