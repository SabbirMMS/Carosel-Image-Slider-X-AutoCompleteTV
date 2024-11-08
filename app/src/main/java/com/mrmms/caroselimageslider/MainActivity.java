package com.mrmms.caroselimageslider;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.carousel.CarouselSnapHelper;
import com.mrmms.caroselimageslider.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new CarouselLayoutManager());
        new CarouselSnapHelper().attachToRecyclerView(binding.recyclerView);

        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.a1);
        images.add(R.drawable.a2);
        images.add(R.drawable.a3);
        images.add(R.drawable.a1);
        images.add(R.drawable.a2);
        images.add(R.drawable.a3);
        images.add(R.drawable.a1);
        images.add(R.drawable.a2);
        images.add(R.drawable.a3);
        CarouselAdapter adapter = new CarouselAdapter(images);
        binding.recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener((imageView, item) -> {

            startActivity(new Intent(this, ImageActivity.class).putExtra("image", item),
                    ActivityOptions.makeSceneTransitionAnimation(this, imageView, "image").toBundle());
        });


        // Auto Complete Text View
        ArrayAdapter<String> adapter2 =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.countries)
                );
        binding.autoCom.setAdapter(adapter2);
    }
}