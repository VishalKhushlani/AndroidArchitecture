package com.example.vishalkhushlani.androidarchitecture.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vishalkhushlani.androidarchitecture.Notification.Notification;
import com.example.vishalkhushlani.androidarchitecture.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {


    private final ArrayList<Notification> notificationsArr;

    public NotificationAdapter(ArrayList<Notification> notificationEntityArrayList) {
        this.notificationsArr = notificationEntityArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.notification_item_view, null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Notification notificationEntity = notificationsArr.get(position);

        if (notificationEntity.getStatus() != null) {
            switch (notificationEntity.getStatus()) {
                case "9":
//                    holder.img.setImageResource(R.drawable.dispached);//Driver dispached for delivery
                    break;
                case "4":
//                    holder.img.setImageResource(R.drawable.payment);// payment Done
                    break;
                case "1":
//                    holder.img.setImageResource(R.drawable.placed); // order placed
                    break;
                case "11":
//                    holder.img.setImageResource(R.drawable.exclamation);//cancel order
                    break;
                case "2":
//                    holder.img.setImageResource(R.drawable.dispensed); // Stock dispensed
                    break;
                default:
//                    holder.img.setImageResource(R.drawable.alert1);
                    break;
            }
        } else {
//            holder.img.setImageResource(R.drawable.alert1);
        }

        holder.txtMessage.setText(notificationEntity.getNotification());
        holder.txtTime.setText(notificationEntity.getCreatedAt());
    }


    public int getItemCount() {
        return notificationsArr.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtMessage, txtTime;
        ImageView img;

        MyViewHolder(View itemView) {
            super(itemView);
            txtMessage = itemView.findViewById(R.id.txt_message);
            txtTime = itemView.findViewById(R.id.txt_time);
            img = itemView.findViewById(R.id.img);
        }
    }
}

