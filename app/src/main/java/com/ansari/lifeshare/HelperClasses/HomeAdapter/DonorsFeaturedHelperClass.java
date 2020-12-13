package com.ansari.lifeshare.HelperClasses.HomeAdapter;

public class DonorsFeaturedHelperClass {

    int image;
    String title, description;

    public DonorsFeaturedHelperClass(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

