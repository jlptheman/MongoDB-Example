package flights.core.interfaces;

import flights.core.model.Flight;
import java.util.List;

public interface IFlightService {
  Flight GetFlight(String id);
  List<Flight> GetFlights(String filter);
  Flight InsertFlight(Flight flight);
  Flight UpdateFlight(Flight flight);
  void DeleteFlight(String id);
}
