package flights.dal;

import flights.core.interfaces.IFlightRepository;
import flights.core.model.Flight;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class InMemoryFlightRepository implements IFlightRepository {

  private List<Flight> flights;

  public InMemoryFlightRepository(){
    flights = new ArrayList(Arrays.asList(
        new Flight(UUID.randomUUID().toString(), "2020.02.14 14:00:00", "123", "BA", "DUB", "LHR", "OnTime"),
        new Flight(UUID.randomUUID().toString(), "2020.02.14 14:30:00", "456", "BA", "DUB", "STN", "OnTime")));

  }

  public Flight get(String id) {
    List<Flight> matches =
        flights.stream()
        .filter(x -> x.getId().equals(id))
        .collect(Collectors.toList());

    if(matches != null && matches.size() > 0) {
      return matches.get(0);
    } else return null;
  }

  public List<Flight> getAll(String query) {
    return flights;
  }

  public Flight insert(Flight flight) {
    flight.setId(UUID.randomUUID().toString());
    flights.add(flight);
    return flight;
  }

  public Flight update(Flight flight) {
    delete(flight.getId());
    flights.add(flight);
    return flight;
  }

  public void delete(String id) {
    flights.removeIf(x -> x.getId().equals(id));
  }
}
