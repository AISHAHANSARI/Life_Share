package com.ansari.lifeshare.DonorRecipient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ansari.lifeshare.HelperClasses.HomeAdapter.DonorsFeaturedAdapter;
import com.ansari.lifeshare.HelperClasses.HomeAdapter.DonorsFeaturedHelperClass;
import com.ansari.lifeshare.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.ansari.lifeshare.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.ansari.lifeshare.R;
import com.ansari.lifeshare.User.UserDashboard;

import java.util.ArrayList;

public class SearchDonor extends AppCompatActivity {

    RecyclerView featuredRecyler;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_donor);

        //hooks

//        featuredRecyler = findViewById(R.id.donor_recycler);
//        featuredRecyler();
    }

    private void featuredRecyler() {

        featuredRecyler.setHasFixedSize(true);
        featuredRecyler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ArrayList<DonorsFeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new DonorsFeaturedHelperClass(R.drawable.abdullah, getString(R.string.donor1), getString(R.string.msg1)));

        adapter = new DonorsFeaturedAdapter(featuredLocations);
        featuredRecyler.setAdapter(adapter);

    }

    public void backToHome(View view) {
        Intent intent = new Intent(SearchDonor.this, UserDashboard.class);
        startActivity(intent);
        finish();
    }
}