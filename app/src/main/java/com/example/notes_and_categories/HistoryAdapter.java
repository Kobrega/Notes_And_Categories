package com.example.notes_and_categories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    private List<History> historyList;

    public void setLogs(List<History> logs) {
        this.historyList = logs;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_history, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        History log = historyList.get(position);
        holder.tvAction.setText(log.action);
        holder.tvDetails.setText(log.details);
        holder.tvLogDate.setText(log.createdAt);


        if (log.action.contains("NOTE")) {
            holder.tvAction.setTextColor(android.graphics.Color.BLUE);
        } else {
            holder.tvAction.setTextColor(android.graphics.Color.MAGENTA);
        }
    }

    @Override
    public int getItemCount() {
        return historyList != null ? historyList.size() : 0;
    }

    static class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvAction, tvDetails, tvLogDate;
        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAction = itemView.findViewById(R.id.tvAction);
            tvDetails = itemView.findViewById(R.id.tvDetails);
            tvLogDate = itemView.findViewById(R.id.tvLogDate);
        }
    }

}
