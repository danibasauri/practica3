package com.dani.ecoparque;

import android.app.Application;

import com.dani.objects.Item;

import java.util.ArrayList;

/**
 * Created by dcandelas on 20/11/13.
 */
public class Constantes extends Application
{
    public static final String[] IMAGES = new String[] {
        "http://tabletpcssource.com/wp-content/uploads/2011/05/android-logo.png",
        "http://simpozia.com/pages/images/stories/windows-icon.png",
        "https://si0.twimg.com/profile_images/1135218951/gmail_profile_icon3_normal.png",
        "http://www.krify.net/wp-content/uploads/2011/09/Macromedia_Flash_dock_icon.png",
        "http://radiotray.sourceforge.net/radio.png",
        "http://www.bandwidthblog.com/wp-content/uploads/2011/11/twitter-logo.png",
        "http://weloveicons.s3.amazonaws.com/icons/100907_itunes1.png",
        "http://weloveicons.s3.amazonaws.com/icons/100929_applications.png",
        "http://www.idyllicmusic.com/index_files/get_apple-iphone.png",
        "http://www.frenchrevolutionfood.com/wp-content/uploads/2009/04/Twitter-Bird.png",
        "http://3.bp.blogspot.com/-ka5MiRGJ_S4/TdD9OoF6bmI/AAAAAAAAE8k/7ydKtptUtSg/s1600/Google_Sky%2BMaps_Android.png",
        "http://www.desiredsoft.com/images/icon_webhosting.png",
        "http://goodereader.com/apps/wp-content/uploads/downloads/thumbnails/2012/01/hi-256-0-99dda8c730196ab93c67f0659d5b8489abdeb977.png",
};

    public static String getPuntoLimpio() {
        return puntoLimpio;
    }

    public static void setPuntoLimpio(String puntoLimpio) {
        Constantes.puntoLimpio = puntoLimpio;
    }

    private static String puntoLimpio;


    public ArrayList getListData() {
        ArrayList results = new ArrayList();
        Item elementData = new Item("Sercomosa", "http://www.sercomosa.es/images/serv_ecoparque1.jpg");
        results.add(elementData);


        elementData = new Item("Virtual", "http://www.imcjb.net/galerias/5088%5Ceco%20parque.jpg");
        results.add(elementData);


        elementData = new Item("Cartagena Sur", "http://www.cartagenaactualidad.com/wp-content/uploads/2013/04/ecoparque.jpg");
        results.add(elementData);


        elementData = new Item("Puebla Mexico", "http://www.puebla-mexico.com/wordpress/wp-content/uploads/2012/07/AAP-Ecoparque2012-6.jpg");
        results.add(elementData);


        elementData = new Item("San Jose - Las Fuentes", "http://images.teinteresa.es/castilla-la-mancha/toledo/miercoles-Ecoparque-Toledo-instalacion-toneladas_TINIMA20120313_0758_5.jpg");
        results.add(elementData);


        elementData = new Item("Universidad - Delicias", "http://www.turismodecantabria.com/imagenes/Patrimonios/81CBB7DA-75CA-5FB3-D588-A89A9754E7BE.jpg/resizeMod/0/1200/Ecoparque-de-Trasmiera.jpg");
        results.add(elementData);

        elementData = new Item("Torrero", "http://img11.imageshack.us/img11/4829/zgz7sc.gif");
        results.add(elementData);


        elementData = new Item("Cogullada", "http://www.eldiariomontanes.es/noticias/201106/06/Media/ecoparque-trasmiera--647x231.JPG");
        results.add(elementData);


        elementData = new Item("Valdespartera", "http://img11.imageshack.us/img11/2954/valdesp9hm.jpg");
        results.add(elementData);


        elementData = new Item("Teruel", "http://www.hoy.es/prensa/noticias/201310/23/fotos/11457994.jpg");
        results.add(elementData);

        elementData = new Item("Valencia", "http://www.elpais.com/recorte/20080111elpval_1/LCO340/Ies/Grandes_contenedores_escombros_muebles_primer_ecoparque_Valencia.jpg");
        results.add(elementData);

        return results;
    }


}
