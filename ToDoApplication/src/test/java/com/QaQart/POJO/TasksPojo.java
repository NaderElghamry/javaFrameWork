package com.QaQart.POJO;

public class TasksPojo {
    private boolean isCompleted;
    private String item;


    public TasksPojo(String item, boolean isCompleted) {
        this.isCompleted = isCompleted;
        this.item = item;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }


}
