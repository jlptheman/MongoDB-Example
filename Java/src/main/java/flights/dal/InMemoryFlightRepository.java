package flights.dal;

import flights.core.interfaces.IFlightRepository;
import flights.core.model.Flight;
import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class InMemoryFlightRepository implements IFlightRepository {

  private List<Flight> _flights;

  public InMemoryFlightRepository(){
    _flights = new ArrayList(Arrays.asList(
        new Flight(UUID.randomUUID().toString(), "2020.02.14 14:00:00", "123", "BA", "DUB", "LHR", "OnTime"),
        new Flight(UUID.randomUUID().toString(), "2020.02.14 14:30:00", "456", "BA", "DUB", "STN", "OnTime")));

  }

  public Flight Get(String id) {
    List<Flight> matches =
        _flights.stream()
        .filter(x -> x.getId().equals(id))
        .collect(Collectors.toList());

    if(matches != null && matches.size() > 0) {
      return matches.get(0);
    } else return null;
  }

  public List<Flight> GetAll(String query) {
    return _flights;
  }

  public Flight Insert(Flight flight) {
    flight.setId(UUID.randomUUID().toString());
    _flights.add(flight);
    return flight;
  }

  public Flight Update(Flight flight) {
    Delete(flight.getId());
    _flights.add(flight);
    return flight;
  }

  public void Delete(String id) {
    _flights.removeIf(x -> x.getId().equals(id));
  }
}
