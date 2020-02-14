using Flights.Core.Model;
using System.Collections.Generic;

namespace Flights.Core.Interfaces
{
    public interface IFlightService
    {
        Flight GetFlight(string id);
        List<Flight> GetFlights(string filter);
        void InsertFlight(Flight flight);
        void UpdateFlight(Flight flight);
        void DeleteFlight(string id);
    }
}
