package com.example.nikit.getjob;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Vacancy {
    private String desription;
    private String title;
    private User creator;
    private static String tag;

    public String getDesription() {
        return desription;
    }

    public String getTitle() {
        return title;
    }

    public String getTags() {
        return tag;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTags(String tags) {
        this.tag = tags;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}

