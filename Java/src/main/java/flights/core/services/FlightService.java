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

  public Flight GetFlight(String id) {
    return flightRepository.Get(id);
  }

  public List<Flight> GetFlights(String filter) {
    return flightRepository.GetAll(filter);
  }

  public Flight InsertFlight(Flight flight) {
    return flightRepository.Insert(flight);
  }

  public Flight UpdateFlight(Flight flight) {
    return flightRepository.Update(flight);
  }

  public void DeleteFlight(String id) {
    flightRepository.Delete(id);
  }
}
