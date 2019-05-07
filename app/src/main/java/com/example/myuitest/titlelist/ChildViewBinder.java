package com.example.myuitest.titlelist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myuitest.R;

import me.drakeet.multitype.ItemViewBinder;


/**
 * @author hel
 * @date 2019/5/7
 * 文件 MyUITest
 * 描述
 */
public class ChildViewBinder extends ItemViewBinder<Child, ChildViewBinder.ViewHolder> {
OnClickListener onClickListener;
    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_content, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Child title) {
        Glide.with(holder.imageView.getContext()).load(title.imageUrl).into(holder.imageView);
        holder.textView.setText(title.name);
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_title);
            textView = itemView.findViewById(R.id.text_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClick(getAdapterPosition());
                }
            });
        }
    }
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    interface OnClickListener {
        void onClick(int position);
    }
}
