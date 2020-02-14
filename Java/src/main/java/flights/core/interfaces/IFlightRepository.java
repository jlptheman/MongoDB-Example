package flights.core.interfaces;

import flights.core.model.Flight;
import java.util.List;

public interface IFlightRepository {
  Flight Get(String id);
  List<Flight> GetAll(String query);
  Flight Insert(Flight flight);
  Flight Update(Flight flight);
  void Delete(String id);
}
