package com.net.NetOfflineMode.state;


import org.springframework.stereotype.Component;

@Component
public class NetworkState {

    private boolean online = false;

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean status) {
        this.online = status;
    }
}
