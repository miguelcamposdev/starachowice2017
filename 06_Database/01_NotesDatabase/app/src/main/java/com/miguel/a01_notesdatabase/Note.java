package com.miguel.a01_notesdatabase;

/**
 * Created by miguelcampos on 30/11/17.
 */

public class Note {
    private String title;
    private boolean important;

    public Note(String title, boolean important) {
        this.title = title;
        this.important = important;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }
}
