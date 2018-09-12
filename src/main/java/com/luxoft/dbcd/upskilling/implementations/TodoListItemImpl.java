package com.luxoft.dbcd.upskilling.implementations;


import com.luxoft.dbcd.upskilling.interfaces.Togglable;

public class TodoListItemImpl implements Togglable {
    private String title;
    private boolean toggled;

    public TodoListItemImpl(String title){
        this.title = title;
        toggled = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isToggled(){
        return toggled;
    }



    @Override
    public void toggle() {

    }
}
