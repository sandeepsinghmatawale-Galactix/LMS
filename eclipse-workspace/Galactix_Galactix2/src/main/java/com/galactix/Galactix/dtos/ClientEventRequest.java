package com.galactix.Galactix.dtos;



import lombok.Data;

@Data
public class ClientEventRequest {

    private String browser;
    private String browserVersion;
    private String os;
    private String platform;
    private String deviceType;

    private String language;
    private String timezone;

    private String screenResolution;
    private String viewport;
    private Integer colorDepth;
    private Boolean touchSupport;

    private String connectionType;
    private Double downlink;
    private Integer rtt;

    private String pageUrl;
  
    private String eventType;
    
    
}

