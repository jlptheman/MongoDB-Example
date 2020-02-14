package flights.core.services;

import flights.core.interfaces.IFlightRepository;
import flights.core.interfaces.IFlightService;
import flights.core.model.Flight;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class FlightService implements IFlightService {

  private IFlightRepository flightRepository;

  public FlightService(IFlightRepository flightRepository){
    this.flightRepository = flightRepository;
  }

  public Flight getFlight(String id) {
    return flightRepository.get(id);
  }

  public List<Flight> getFlights(String filter) {
    return flightRepository.getAll(filter);
  }

  public Flight insertFlight(Flight flight) {
    return flightRepository.insert(flight);
  }

  public Flight updateFlight(Flight flight) {
    return flightRepository.update(flight);
  }

  public void deleteFlight(String id) {
    flightRepository.delete(id);
  }
}
