package com.ecoparque.objects;

/**
 * Created by dcandelas on 20/11/13.
 */
public class Item {
    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String Url;
    public String Name;

    public Item(String name, String url) {
        Url = url;
        Name = name;
    }


}
