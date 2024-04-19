package org.dnyanyog.controller;

import java.util.List;
import org.dnyanyog.dto.EventVenueRequest;
import org.dnyanyog.dto.EventVenueResponse;
import org.dnyanyog.entity.EventVenue;
import org.dnyanyog.service.EventManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventManagementController {

  @Autowired EventManagementService service;

  @PostMapping("/auth/venue")
  public EventVenueResponse addEventVenue(@RequestBody EventVenueRequest request) {
    return service.addVenue(request);
  }

  @GetMapping("/auth/venue/{eventId}")
  public EventVenueResponse searchEventvenue(@PathVariable int eventId) {
    return service.searchVenue(eventId);
  }

  @GetMapping("/auth/venue")
  public List<EventVenue> searchAllEventvenue() {
    return service.getVenues();
  }

  @PostMapping("/auth/venue")
  public EventVenueResponse updateEventVenue(
      @PathVariable int eventId, @RequestBody EventVenueRequest request) {
    return service.editVenue(eventId, request);
  }

  @DeleteMapping("/auth/venue/{eventId}")
  public String deleteVenue(@PathVariable int eventId) {
    return service.cancleVenue(eventId);
  }
}
