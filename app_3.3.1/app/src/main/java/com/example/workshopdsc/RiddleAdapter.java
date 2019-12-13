package com.example.workshopdsc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RiddleAdapter extends RecyclerView.Adapter<RiddleAdapter.ViewHolder> {
    private List<Riddle> riddles;

    public RiddleAdapter(){
        riddles = new ArrayList<>();
    }

    @NonNull
    @Override
    public RiddleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder = null;
        View view;

        switch (viewType){
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_with_done, parent, false);
                viewHolder = new WithDoneViewHolder(view);
                break;
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_with_no_done, parent, false);
                viewHolder = new WithNoDoneViewHolder(view);
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
    public int getItemViewType(int position){
        return riddles.get(position).isAnswer() ? 1 : 2;
    }

    public class WithDoneViewHolder extends RiddleAdapter.ViewHolder {
        private TextView riddle;
        private TextView asker;

        public WithDoneViewHolder(@NonNull View itemView){
            super(itemView);
            riddle = itemView.findViewById(R.id.riddle);
            asker = itemView.findViewById(R.id.asker);
        }

        @Override
        protected void bind(Riddle riddle){
            this.riddle.setText(riddle.getRiddle());
            asker.setText(riddle.getAsker());
        }
    }

    protected void insertNewRiddles(List<Riddle> insertRiddles){
        DiffUtilCallback diffUtilCallback = new DiffUtilCallback(riddles, insertRiddles);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtilCallback);

        riddles.addAll(insertRiddles);
        diffResult.dispatchUpdatesTo(this);
    }

    protected abstract class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {super(itemView);}
        protected abstract void bind(Riddle riddle);
    }

    public class WithNoDoneViewHolder extends RiddleAdapter.ViewHolder {
        private TextView riddle;
        private TextView asker;

        public WithNoDoneViewHolder(@NonNull View itemView){
            super(itemView);
            riddle = itemView.findViewById(R.id.riddle);
            asker = itemView.findViewById(R.id.asker);
        }

        @Override
        protected void bind(Riddle riddle){
            this.riddle.setText(riddle.getRiddle());
            asker.setText(riddle.getAsker());
        }
    }
}
