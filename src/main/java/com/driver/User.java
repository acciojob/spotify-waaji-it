package com.driver;

import java.util.*;

public class User {
    private String name;
    private String mobile;
    private List<Song> likedSongs;

    public User() {this.likedSongs = new ArrayList<>();}

    public User(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
        this.likedSongs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
