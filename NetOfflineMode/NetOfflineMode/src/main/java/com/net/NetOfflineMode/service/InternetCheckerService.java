package com.net.NetOfflineMode.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.net.NetOfflineMode.state.NetworkState;

@Service
public class InternetCheckerService {

    private static final String HEALTH_URL ="https://clients3.google.com/generate_204"; 
    
    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private NetworkState networkState;

    @Autowired
    private SyncService syncService;

    
    @Scheduled(fixedDelay = 5000)
    public void checkInternet() {

        System.out.println("Checking internet... Current State = " 
                + (networkState.isOnline() ? "ONLINE" : "OFFLINE"));

        try {
            restTemplate.getForObject(HEALTH_URL, String.class);

            if (!networkState.isOnline()) {
                System.out.println("Internet Restored! Switching to ONLINE mode");
                networkState.setOnline(true);

                // Call Sync
                System.out.println("🔄 Syncing offline data now...");
            }

        } catch (Exception e) {

            if (networkState.isOnline()) {
                System.out.println("❌ Internet Lost! Switching to OFFLINE mode");
                networkState.setOnline(false);
            }
        }
    }

}
