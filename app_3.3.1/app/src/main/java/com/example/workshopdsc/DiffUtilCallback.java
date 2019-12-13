package com.example.workshopdsc;

import androidx.recyclerview.widget.DiffUtil;

import java.util.ArrayList;
import java.util.List;

public class DiffUtilCallback extends DiffUtil.Callback {

    private List<Riddle> oldList;
    private List<Riddle> newList;

    public DiffUtilCallback(List<Riddle> oldList, List<Riddle> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override //AreObjectsTheSame
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition) == newList.get(newItemPosition);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).riddle.equals(newList.get(newItemPosition).riddle);
    }
}
