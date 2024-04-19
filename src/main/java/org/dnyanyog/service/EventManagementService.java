package org.dnyanyog.service;

import java.util.List;
import java.util.Optional;
import org.dnyanyog.dto.EventVenueRequest;
import org.dnyanyog.dto.EventVenueResponse;
import org.dnyanyog.entity.EventVenue;
import org.dnyanyog.repo.EventVenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventManagementService {

  @Autowired EventVenueRepository repo;

  @Autowired EventVenueResponse response;

  public EventVenueResponse addVenue(EventVenueRequest request) {

    EventVenue eventVenue = new EventVenue();
    eventVenue.setEventType(request.getEventType());
    eventVenue.setCapacity(request.getCapacity());
    eventVenue.setLocation(request.getLocation());
    eventVenue.setCost(request.getCost());
    eventVenue.setContacts(request.getContacts());
    eventVenue.setDate(request.getDate());
    eventVenue.setItemName(request.getItemName());
    eventVenue.setItemCost(request.getItemCost());
    eventVenue.setEquipmentName(request.getEquipmentName());
    eventVenue.setEquipmentCost(request.getEquipmentCost());

    eventVenue = repo.save(eventVenue);

    response.setMessage("Venue added successfully !!");
    response.setEventType(request.getEventType());
    response.setCapacity(request.getCapacity());
    response.setLocation(request.getLocation());
    response.setContacts(request.getContacts());
    response.setCost(request.getCost());
    response.setDate(request.getDate());
    response.setItemName(request.getItemName());
    response.setItemCost(request.getItemCost());
    response.setEquipmentName(request.getEquipmentName());
    response.setEquipmentCost(request.getEquipmentCost());
    response.setEventId(eventVenue.getEventId());

    return response;
  }

  public EventVenueResponse editVenue(int eventId, EventVenueRequest request) {

    Optional<EventVenue> editVenue = repo.findById(eventId);
    if (editVenue.isEmpty()) {
      response.setMessage("Venue not found !!");
    } else {
      EventVenue venue = editVenue.get();
      venue.setEventType(request.getEventType());
      venue.setCapacity(request.getCapacity());
      venue.setContacts(request.getContacts());
      venue.setLocation(request.getLocation());
      venue.setCost(request.getCost());
      venue.setDate(request.getDate());
      venue.setItemName(request.getItemName());
      venue.setItemCost(request.getItemCost());
      venue.setEquipmentName(request.getEquipmentName());
      venue.setEquipmentCost(request.getEquipmentCost());

      response.setMessage("Venue updated successfully !!");
    }

    return response;
  }

  public EventVenueResponse searchVenue(int eventId) {

    Optional<EventVenue> venueTable = repo.findById(eventId);

    if (venueTable.isEmpty()) {
      response.setMessage("Venue not found");
    } else {
      EventVenue eventVenue = venueTable.get();
      response.setMessage("Venue searched successfully !!");
      response.setEventType(eventVenue.getEventType());
      response.setLocation(eventVenue.getLocation());
      response.setCapacity(eventVenue.getCapacity());
      response.setContacts(eventVenue.getContacts());
      response.setCost(eventVenue.getCost());
      response.setDate(eventVenue.getDate());
      response.setItemName(eventVenue.getItemName());
      response.setItemCost(eventVenue.getItemCost());
      response.setEquipmentName(eventVenue.getEquipmentName());
      response.setEquipmentCost(eventVenue.getEquipmentCost());
    }
    return response;
  }

  public List<EventVenue> getVenues() {
    return repo.findAll();
  }

  public String cancleVenue(int eventId) {
    repo.deleteById(eventId);
    return "Venue cancled !!";
  }
}
