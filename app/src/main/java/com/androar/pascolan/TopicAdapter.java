package com.androar.pascolan;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import org.w3c.dom.Text;
import java.util.ArrayList;

public class TopicAdapter extends RecyclerView.Adapter <TopicAdapter.ViewHolder> {

    public ArrayList<Topic> topics;
    public Context context;

    public TopicAdapter(Context context, ArrayList<Topic> list)
    {
        this.topics=list;
        this.context = context;
        notifyDataSetChanged();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        TextView tvTopicName;
        ImageView ivTopicThumbnail;

        public ViewHolder (@NonNull View itemView){
            super(itemView);

            tvTopicName = itemView.findViewById(R.id.tvTopicName);
            ivTopicThumbnail = itemView.findViewById(R.id.ivTopicThumbnai);

        }
    }
    @NonNull
    @Override
    public TopicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_rv_topic, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final TopicAdapter.ViewHolder holder, final int position) {
        holder.itemView.setTag(topics.get(position));
        holder.tvTopicName.setText(topics.get(position).getTopicNameHindi());
    }


    @Override
    public int getItemCount() {
        return topics.size();
    }
}