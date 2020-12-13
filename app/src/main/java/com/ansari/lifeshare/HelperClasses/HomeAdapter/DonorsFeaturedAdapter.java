package com.ansari.lifeshare.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ansari.lifeshare.R;

import java.util.ArrayList;

import javax.xml.parsers.FactoryConfigurationError;

public class DonorsFeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    ArrayList<DonorsFeaturedHelperClass> featuredlocations;

    public DonorsFeaturedAdapter(ArrayList<DonorsFeaturedHelperClass> featuredlocations) {
        this.featuredlocations = featuredlocations;
    }

    @NonNull
    @Override
    public FeaturedAdapter.FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design_donors,parent,false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedAdapter.FeaturedViewHolder holder, int position) {

        DonorsFeaturedHelperClass donorsFeaturedHelperClass = featuredlocations.get(position);

        holder.image.setImageResource(donorsFeaturedHelperClass.getImage());
        holder.title.setText(donorsFeaturedHelperClass.getTitle());
        holder.desc.setText(donorsFeaturedHelperClass.getDescription());

    }

    @Override
    public int getItemCount() {
        return featuredlocations.size();
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, desc;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks
            image = itemView.findViewById(R.id.featured_image_donor);
            title = itemView.findViewById(R.id.featured_title_donor);
            desc = itemView.findViewById(R.id.featured_desc_donor);
        }
    }
}
