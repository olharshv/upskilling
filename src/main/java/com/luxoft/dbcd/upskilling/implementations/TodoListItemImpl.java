package com.luxoft.dbcd.upskilling.implementations;


import com.luxoft.dbcd.upskilling.interfaces.Togglable;

public class TodoListItemImpl implements Togglable {
    private String title;
    private boolean toggled;

    public TodoListItemImpl(String title){
        if (title.isEmpty()) throw new IllegalArgumentException("Title cannot be empty");
        this.title = title;
        toggled = false;
    }

    public String getTitle() {
        return title;
    }

    public TodoListItemImpl setTitle(String title) {
        //this.title = title;
        if (title.isEmpty()) throw new IllegalArgumentException("New title cannot be empty");
        return new TodoListItemImpl(title);

    }

    public boolean isToggled(){
        return toggled;
    }



    @Override
    public void toggle() {

     //   if (toggled) {
     //       toggled = false;
     //       return;
     //   }
     //   toggled = true;
       toggled = !toggled;
    }
}
