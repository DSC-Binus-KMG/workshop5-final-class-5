package com.example.dscuiuxcasestudy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RiddleAdapter extends RecyclerView.Adapter<RiddleAdapter.ViewHolder>  {

    private List<Riddle> riddles;
    private static final int VIEWHOLDER_UNANSWERED = 0;
    private static final int VIEWHOLDER_ANSWERED = 1;

    public RiddleAdapter() {
        riddles = new ArrayList<>();
    }
    @NonNull
    @Override
    public RiddleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ViewHolder viewHolder = null;
        View view;

        switch (viewType)
        {
            case VIEWHOLDER_UNANSWERED:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_riddle_not_answered, parent,false);;
                viewHolder = new UnAnsweredViewHolder(view);
                break;
            case VIEWHOLDER_ANSWERED:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_riddle_answered, parent,false);;
                viewHolder = new AnsweredViewHolder(view);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RiddleAdapter.ViewHolder holder, int position) {
        holder.bind(riddles.get(position));
    }

    @Override
    public int getItemCount() {
        return riddles.size();
    }

    @Override
    public int getItemViewType(int position) {
        return riddles.get(position).isAnswered() ? VIEWHOLDER_ANSWERED : VIEWHOLDER_UNANSWERED;
    }

    protected void insertNewRiddles(List<Riddle> insertRiddles) {
        DiffUtilCallback myDiffutilCallback = new DiffUtilCallback(riddles, insertRiddles);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(myDiffutilCallback);

        riddles.addAll(insertRiddles);
        diffResult.dispatchUpdatesTo(this);
    }

    protected void setRiddles(List<Riddle> riddles) {
        this.riddles = riddles;
        notifyDataSetChanged();
    }

    protected abstract class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {super(itemView); }

        protected abstract void bind(Riddle riddle);
    }

    public class AnsweredViewHolder extends ViewHolder {

        private TextView riddle;
        private TextView asker;

        public AnsweredViewHolder(@NonNull View itemView) {
            super(itemView);
            riddle = itemView.findViewById(R.id.riddle);
            asker = itemView.findViewById(R.id.asker);
        }

        @Override
        protected void bind(Riddle riddle) {
            this.riddle.setText(riddle.riddle);
            asker.setText("Asked by: "+riddle.asker);
        }

    }

    public class UnAnsweredViewHolder extends ViewHolder {

        private TextView riddle;
        private TextView asker;

        public UnAnsweredViewHolder(@NonNull View itemView) {
            super(itemView);
            riddle = itemView.findViewById(R.id.riddle);
            asker = itemView.findViewById(R.id.asker);
        }

        @Override
        protected void bind(Riddle riddle) {
            this.riddle.setText(riddle.riddle);
            asker.setText("Asked by: "+riddle.asker);
        }

    }
}
