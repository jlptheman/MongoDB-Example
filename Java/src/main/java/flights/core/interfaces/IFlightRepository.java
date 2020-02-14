package flights.core.interfaces;

import flights.core.model.Flight;
import java.util.List;

public interface IFlightRepository {
  Flight get(String id);
  List<Flight> getAll(String query);
  Flight insert(Flight flight);
  Flight update(Flight flight);
  void delete(String id);
}
