package com.ansari.lifeshare.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ansari.lifeshare.BloodCompatibility;
import com.ansari.lifeshare.Common.LearnAboutBlood;
import com.ansari.lifeshare.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.ansari.lifeshare.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.ansari.lifeshare.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import static com.ansari.lifeshare.R.*;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    Button btnSignIn;
    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;

    static final float END_SCALE = 0.7f;
    LinearLayout contentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_user_dashboard);

        //Recycler View
        featuredRecycler = findViewById(id.featured_recycler);
        featuredRecycler();

        //menu
        drawerLayout = findViewById(id.drawer_layout);
        navigationView = findViewById(id.navigation_view);
        menuIcon = findViewById(id.menu_icon);

        btnSignIn = findViewById(id.btnSignIn);

        contentView = findViewById(id.contentView);

        navigationView.setItemIconTintList(null);

        signIn();

        navigationDrawer();

        animateNavigationDrawer();

    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(drawable.abdullah, getString(string.donor1), getString(string.msg1)));
        featuredLocations.add(new FeaturedHelperClass(drawable.zeeshan, getString(string.donor2), getString(string.msg2)));
        featuredLocations.add(new FeaturedHelperClass(drawable.zeeshan,getString(string.donor3), getString(string.msg3)));
        featuredLocations.add(new FeaturedHelperClass(drawable.profile,getString(string.donor4), getString(string.msg4)));
        featuredLocations.add(new FeaturedHelperClass(drawable.zeeshan, getString(string.donor5), getString(string.msg5)));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);
    }

    private void signIn() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserDashboard.this,SignIn.class);
                startActivity(intent);
            }
        });
    }

    private void navigationDrawer() {
        //navigation drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case id.nav_home:
                break;

            case id.nav_signin:
                Intent intent_signin = new Intent(UserDashboard.this, SignIn.class);
                startActivity(intent_signin);
                break;

            case id.nav_signup:

                Intent intent_signup = new Intent(UserDashboard.this, SignUp.class);
                startActivity(intent_signup);
//                menu.findItem(id.nav_signup).setVisible(false);
                break;

            case id.nav_info:
                Intent intent_info = new Intent(UserDashboard.this, LearnAboutBlood.class);
                startActivity(intent_info);
                break;


            case id.nav_compatibility:

                Intent intent_compatibility = new Intent(UserDashboard.this, BloodCompatibility.class);
                startActivity(intent_compatibility);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void animateNavigationDrawer() {

        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        //drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });

    }


}