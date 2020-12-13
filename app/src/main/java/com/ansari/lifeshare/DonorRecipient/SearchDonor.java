package com.ansari.lifeshare.DonorRecipient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ansari.lifeshare.HelperClasses.HomeAdapter.DonorsFeaturedAdapter;
import com.ansari.lifeshare.HelperClasses.HomeAdapter.DonorsFeaturedHelperClass;
import com.ansari.lifeshare.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.ansari.lifeshare.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.ansari.lifeshare.R;

import java.util.ArrayList;

public class SearchDonor extends AppCompatActivity {

    RecyclerView featuredRecyler;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_donor);

        //hooks

        featuredRecyler = findViewById(R.id.featured_recycler);


        featuredRecyler();
    }

    private void featuredRecyler() {

        featuredRecyler.setHasFixedSize(true);
        featuredRecyler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<DonorsFeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new DonorsFeaturedHelperClass(R.drawable.abdullah, getString(R.string.donor1), getString(R.string.msg1)));

        adapter = new DonorsFeaturedAdapter(featuredLocations);
        featuredRecyler.setAdapter(adapter);

    }
}