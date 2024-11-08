package com.mrmms.caroselimageslider;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mrmms.caroselimageslider.databinding.ActivityImageBinding;

public class ImageActivity extends AppCompatActivity {

    ActivityImageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageView.setImageResource(getIntent().getIntExtra("image", R.drawable.a1));

    }
}