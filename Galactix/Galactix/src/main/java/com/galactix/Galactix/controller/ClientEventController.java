package com.galactix.Galactix.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.galactix.Galactix.dtos.ClientEventRequest;
import com.galactix.Galactix.entities.ClientEvent;
import com.galactix.Galactix.repositories.ClientEventRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/events")
public class ClientEventController {

    private final ClientEventRepository repository;

    // ✅ Constructor injection (BEST)
    public ClientEventController(ClientEventRepository repository) {
        this.repository = repository;
    }

    /* -------------------------------------------------
       1️⃣ LOGIN / FORM PAGE
    ------------------------------------------------- */
    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("clientEvent", new ClientEventRequest());
        return "login";
    }

    /* -------------------------------------------------
       2️⃣ ANALYTICS ENDPOINT (JS fetch)
    ------------------------------------------------- */
    @PostMapping(
            value = "/track",
            consumes = "application/json"
    )
    @ResponseBody
    public void trackEvent(
            @RequestBody ClientEventRequest dto,
            HttpServletRequest request
    ) {
        saveEventInternal(dto, request);
    }

    /* -------------------------------------------------
       3️⃣ FORM SUBMIT (LOGIN BUTTON)
    ------------------------------------------------- */
    @PostMapping("/login")
    public String submitLogin(
            @RequestParam String username,
            @RequestParam String password,
            HttpServletRequest request
    ) {
        // You can authenticate later

        // OPTIONAL: Save minimal login event
        ClientEventRequest dto = new ClientEventRequest();
        dto.setEventType("login_submit");
        System.out.println(dto);


        saveEventInternal(dto, request);

        return "redirect:/events/list";
    }

    /* -------------------------------------------------
       4️⃣ LIST EVENTS (ADMIN VIEW)
    ------------------------------------------------- */
    @GetMapping("/list")
    public String listEvents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model
    ) {
        Page<ClientEvent> events = repository.findAll(
                PageRequest.of(page, size, Sort.by("createdAt").descending())
        );

        model.addAttribute("events", events);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", events.getTotalPages());

        return "events";
    }

    /* -------------------------------------------------
       🔧 SHARED SAVE LOGIC
    ------------------------------------------------- */
    private void saveEventInternal(
            ClientEventRequest dto,
            HttpServletRequest request
    ) {
        ClientEvent event = ClientEvent.builder()
                .ipAddress(getClientIp(request))
                .userAgent(request.getHeader("User-Agent"))
                .browser(dto.getBrowser())
                .browserVersion(dto.getBrowserVersion())
                .os(dto.getOs())
                .platform(dto.getPlatform())
                .deviceType(dto.getDeviceType())
                .language(dto.getLanguage())
                .timezone(dto.getTimezone())
                .screenResolution(dto.getScreenResolution())
                .viewport(dto.getViewport())
                .colorDepth(dto.getColorDepth())
                .touchSupport(dto.getTouchSupport())
                .connectionType(dto.getConnectionType())
                .downlink(dto.getDownlink())
                .rtt(dto.getRtt())
                .pageUrl(dto.getPageUrl())
                .referrer(dto.getReferrer())
                .eventType(dto.getEventType())
                .build();

        repository.save(event);
    }

    private String getClientIp(HttpServletRequest request) {
        String xff = request.getHeader("X-Forwarded-For");
        if (xff != null && !xff.isBlank()) {
            return xff.split(",")[0];
        }
        return request.getRemoteAddr();
    }
}