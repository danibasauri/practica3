package com.ecoparque.objects;

/**
 * Created by dcandelas on 20/11/13.
 */
public class Item {
    public String getUrl() {
        return Url;
    }

    public String getName() {
        return Name;
    }


    private final String Url;
    private final String Name;

    public Item(String name, String url) {
        Url = url;
        Name = name;
    }


}
