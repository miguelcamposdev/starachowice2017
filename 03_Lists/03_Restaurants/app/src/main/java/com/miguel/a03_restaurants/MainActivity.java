package com.miguel.a03_restaurants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;

    List<Restaurant> restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listViewRestaurants);

        restaurantList = new ArrayList<>();
        restaurantList.add(new Restaurant("Goiko Grill","Rep. Argentina Street, 30, Seville","0034954112233",4,"https://www.goikogrill.com/","https://www.goikogrill.com/wp-content/uploads/2017/05/GOIKO_GRILL_aragon-2.jpg"));

        MyRestaurantAdapter adapter = new MyRestaurantAdapter(
                this,
                R.layout.restaurant_item,
                restaurantList
        );

        lista.setAdapter(adapter);
    }
}
