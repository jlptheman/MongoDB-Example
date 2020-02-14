package flights.web;

import flights.core.interfaces.IFlightService;
import flights.core.model.Flight;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*") // TODO is this necessary/desirable?
@RestController
@RequestMapping(
    value = "api/flights",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class FlightsController {
  private IFlightService flightService;

  @Autowired
  public FlightsController(final IFlightService flightService){
    this.flightService = flightService;
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Flight> get(@PathVariable String id){
    return new ResponseEntity<Flight>(flightService.getFlight(id), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Flight>> getFiltered(@RequestParam(required = false) String filter){
    return new ResponseEntity<List<Flight>>(flightService.getFlights(filter), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity insert(@RequestBody Flight flight){
    return new ResponseEntity<Flight>(flightService.insertFlight(flight), HttpStatus.OK);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Flight> update(@PathVariable String id, @RequestBody Flight flight){
    return new ResponseEntity<Flight>(flightService.updateFlight(flight), HttpStatus.OK);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Flight> delete(@PathVariable String id){
    flightService.deleteFlight(id);
    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }
}
