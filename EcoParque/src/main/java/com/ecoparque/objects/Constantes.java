package com.ecoparque.objects;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by dcandelas on 20/11/13.
 */
public class Constantes extends Application {

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


        elementData = new Item("Cartagena Sur", "https://gp3.googleusercontent.com/-y9ZsmNL_vJU/AAAAAAAAAAI/AAAAAAAAAAA/PwfpKzFJZYA/s48-c-k-no/photo.jpg");
        results.add(elementData);


        elementData = new Item("Puebla Mexico", "http://www.puebla-mexico.com/wordpress/wp-content/uploads/2012/07/AAP-Ecoparque2012-6.jpg");
        results.add(elementData);


        elementData = new Item("San Jose - Las Fuentes", "http://images.teinteresa.es/castilla-la-mancha/toledo/miercoles-Ecoparque-Toledo-instalacion-toneladas_TINIMA20120313_0758_5.jpg");
        results.add(elementData);


        elementData = new Item("Universidad - Delicias", "http://www.turismodecantabria.com/imagenes/Patrimonios/81CBB7DA-75CA-5FB3-D588-A89A9754E7BE.jpg/resizeMod/0/1200/Ecoparque-de-Trasmiera.jpg");
        results.add(elementData);

        elementData = new Item("Torrero", "http://img11.imageshack.us/img11/4829/zgz7sc.gif");
        results.add(elementData);


        elementData = new Item("Cogullada", "https://khms0.google.es/kh/v=141&src=app&cookie=fzwq2t5XM6zEgNVbCMabgjEAEVUolAo0XfrNmw&x=2020&y=1513&z=12&s=Galil");
        results.add(elementData);


        elementData = new Item("Valdespartera", "http://img11.imageshack.us/img11/2954/valdesp9hm.jpg");
        results.add(elementData);


        elementData = new Item("Teruel", "http://www.hoy.es/prensa/noticias/201310/23/fotos/11457994.jpg");
        results.add(elementData);

        elementData = new Item("Valencia", "http://www.elpais.com/recorte/20080111elpval_1/LCO340/Ies/Grandes_contenedores_escombros_muebles_primer_ecoparque_Valencia.jpg");
        results.add(elementData);

        elementData = new Item("Madrid", "http://foto.hrsstatic.com/fotos/0/3/256/256/80/FFFFFF/http%3A%2F%2Ffoto-origin.hrsstatic.com%2Ffoto%2F0%2F5%2F6%2F5%2F056536%2F056536_a_3556338.jpg/l%2BvJ65tJeZ21DUXH%2Fr28wA%3D%3D/2592,1751/6/Muehlenthalers_Park_Hotel-Konz-Aussenansicht-2-56536.jpg");
        results.add(elementData);

        elementData = new Item("Torrejón de Ardoz", "https://pbs.twimg.com/profile_images/3156998453/173bb256153918a667d89a09fe537377.jpeg");
        results.add(elementData);

        elementData = new Item("Basauri", "https://gp3.googleusercontent.com/-y9ZsmNL_vJU/AAAAAAAAAAI/AAAAAAAAAAA/PwfpKzFJZYA/s48-c-k-no/photo.jpg");
        results.add(elementData);

        elementData = new Item("Bilbao", "https://khms0.google.es/kh/v=141&src=app&cookie=fzwq2t5XM6zEgNVbCMabgjEAEVUolAo0XfrNmw&x=2020&y=1513&z=12&s=Galil");
        results.add(elementData);

        elementData = new Item("Amurrio", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSl3uLqk7Y_ZgknWO5V2tcx-22BOiphhYNFV8iIslEQGtxa_xJXCQ");
        results.add(elementData);

        elementData = new Item("Galdakao", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTD3lS0bKqtSAqT-Q2zu7yL2mvONCNGhYPMapy6MXIDgvCo_d-TBw");
        results.add(elementData);

        elementData = new Item("Amorebieta", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTey_VTVAoaX9XUOPEBRPA882s0iSmzoYosVwbPLIskJHunMIfM_A");
        results.add(elementData);

        elementData = new Item("Larrabetxu", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTPQ1mFWOtnnGUGy3iuwMF8d8Mlm3xQWqI1AHfXXJ_wXhaLWiHAUg");
        results.add(elementData);

        elementData = new Item("Barakaldo", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSw8XZ674Gezink0s4EUaTHwW1He-A6aEWBdtPZlvbCHrKmO3HNbA");
        results.add(elementData);

        elementData = new Item("Gernika", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSoVb3o5JDc5lbGdm2NHrr4RS8ftETPv6DBJT73RgZNQ_xIuQvT");
        results.add(elementData);

        elementData = new Item("Portuondo", "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcT1qBWf3eENpHRJFwhsskRBoKzMV__aJ1PoxBhR2brbN1PXXZJ1");
        results.add(elementData);

        elementData = new Item("Erandio", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRe-JEXMmhCo6Z6hwMiFmLAusFJ33nngygUU6uvMmWK_SJpsYej");
        results.add(elementData);

        elementData = new Item("Muxika", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9Z36iPWK6FbSQtCVMbj6WNi9yZnxRLoMKNU7SjvuM-d6-vDnYGQ");
        results.add(elementData);

        return results;
    }


}
