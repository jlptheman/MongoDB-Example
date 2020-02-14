package flights.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Flight {
  private String id;
  private String scheduleTime;
  private String number;
  private String airline;
  private String origin;
  private String destination;
  private String status;
}
