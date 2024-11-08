package com.mrmms.caroselimageslider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrmms.caroselimageslider.databinding.ItemBinding;

import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder> {
    List<Integer> images;
    OnItemClickListener onItemClickListener;

    public CarouselAdapter(List<Integer> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public CarouselAdapter.CarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CarouselViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CarouselAdapter.CarouselViewHolder holder, int position) {
        int res = images.get(position);
        holder.binding.imageView.setImageResource(res);
        holder.binding.imageView.setOnClickListener(view -> {
            onItemClickListener.onClick(holder.binding.imageView, res);
            Toast.makeText(holder.itemView.getContext(), "" + position, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class CarouselViewHolder extends RecyclerView.ViewHolder {
        ItemBinding binding;

        public CarouselViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(ImageView imageView, int item);
    }

}
