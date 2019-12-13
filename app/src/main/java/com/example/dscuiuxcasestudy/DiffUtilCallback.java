package com.example.dscuiuxcasestudy;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class DiffUtilCallback extends DiffUtil.Callback  {

    private List<Riddle> oldList;
    private List<Riddle> newList;

    public DiffUtilCallback(List<Riddle> oldList, List<Riddle> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList != null ? oldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newList != null ? newList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition) == newList.get(newItemPosition);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return newList.get(newItemPosition).riddle.equals(oldList.get(oldItemPosition).riddle);
    }
}
