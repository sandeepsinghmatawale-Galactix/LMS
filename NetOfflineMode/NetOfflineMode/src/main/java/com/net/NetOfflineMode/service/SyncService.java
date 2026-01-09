package com.net.NetOfflineMode.service;


import org.springframework.stereotype.Service;

@Service
public class SyncService {

    public void startSync() {
        System.out.println("🔥 Sync Started… Sending pending data to server...");
        // In real project → read sync_queue and push
    }
}
