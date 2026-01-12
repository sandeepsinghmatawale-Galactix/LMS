package com.galactix.Galactix.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "client_events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ip_address", length = 45)
    private String ipAddress;

    @Column(name = "user_agent", columnDefinition = "TEXT")
    private String userAgent;

    @Column(name = "browser")
    private String browser;

    @Column(name = "browser_version")
    private String browserVersion;

    @Column(name = "os")
    private String os;

    @Column(name = "platform")
    private String platform;

    @Column(name = "device_type")
    private String deviceType;

    @Column(name = "language")
    private String language;

    @Column(name = "timezone")
    private String timezone;

    @Column(name = "screen_resolution")
    private String screenResolution;

    @Column(name = "viewport")
    private String viewport;

    @Column(name = "color_depth")
    private Integer colorDepth;

    @Column(name = "touch_support")
    private Boolean touchSupport;

    @Column(name = "connection_type")
    private String connectionType;

    @Column(name = "downlink")
    private Double downlink;

    @Column(name = "rtt")
    private Integer rtt;

    @Column(name = "page_url", columnDefinition = "TEXT")
    private String pageUrl;

    

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
