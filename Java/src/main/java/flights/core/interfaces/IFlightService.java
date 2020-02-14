package flights.core.interfaces;

import flights.core.model.Flight;
import java.util.List;

public interface IFlightService {
  Flight getFlight(String id);
  List<Flight> getFlights(String filter);
  Flight insertFlight(Flight flight);
  Flight updateFlight(Flight flight);
  void deleteFlight(String id);
}
