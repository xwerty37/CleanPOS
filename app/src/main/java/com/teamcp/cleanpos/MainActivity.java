package com.teamcp.cleanpos;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView restaurantList = findViewById(R.id.restaurant_list);
        RestaurantAdapter adapter = new RestaurantAdapter();
        adapter.addItem(new Restaurant(0, R.drawable.ic_launcher_foreground, "테스트1", "010-0000-0000", "4.1/5 (10)"));
        adapter.addItem(new Restaurant(0, R.drawable.ic_launcher_foreground, "테스트2", "010-0000-0000", "4.2/5 (20)"));
        restaurantList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.category, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.restaurant_korean:
                Toast.makeText(this, "한식", Toast.LENGTH_SHORT).show();
                break;
            case R.id.restaurant_snack:
                Toast.makeText(this, "분식", Toast.LENGTH_SHORT).show();
                break;
            case R.id.restaurant_chinese:
                Toast.makeText(this, "중식", Toast.LENGTH_SHORT).show();
                break;
            case R.id.restaurant_japanese:
                Toast.makeText(this, "일식", Toast.LENGTH_SHORT).show();
                break;
            case R.id.restaurant_asian:
                Toast.makeText(this, "아시안, 양식", Toast.LENGTH_SHORT).show();
                break;
            case R.id.restaurant_chicken:
                Toast.makeText(this, "치킨", Toast.LENGTH_SHORT).show();
                break;
            case R.id.restaurant_pizza:
                Toast.makeText(this, "피자", Toast.LENGTH_SHORT).show();
                break;
            case R.id.restaurant_pork_hocks:
                Toast.makeText(this, "족발 보쌈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.restaurant_night:
                Toast.makeText(this, "야식", Toast.LENGTH_SHORT).show();
                break;
            case R.id.restaurant_fastfood:
                Toast.makeText(this, "패스트푸드", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class RestaurantAdapter extends BaseAdapter {
        ArrayList<Restaurant> items = new ArrayList<Restaurant>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Restaurant item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            RestaurantView restaurantView = null;
            if (convertView == null) {
                restaurantView = new RestaurantView(getApplicationContext());
            } else {
                restaurantView = (RestaurantView) convertView;
            }
            Restaurant item = items.get(position);
            restaurantView.setThumbnail(item.getThumbnailId());
            restaurantView.setName(item.getName());
            restaurantView.setPhone(item.getPhone());
            restaurantView.setRate(item.getRate());
            return restaurantView;
        }
    }
}
