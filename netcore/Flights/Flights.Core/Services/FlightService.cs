using Flights.Core.Interfaces;
using Flights.Core.Model;
using System.Collections.Generic;

namespace Flights.Core.Services
{
    public class FlightService : IFlightService
    {
        private readonly IFlightRepository _flightRepository;

        public FlightService(IFlightRepository flightRepository)
        {
            _flightRepository = flightRepository;
        }

        public void DeleteFlight(string id)
        {
            _flightRepository.Delete(id);
        }

        public Flight GetFlight(string id)
        {
            return _flightRepository.Get(id);
        }

        public List<Flight> GetFlights(string filter)
        {
            return _flightRepository.GetAll(filter);
        }

        public void InsertFlight(Flight flight)
        {
            _flightRepository.Insert(flight);
        }

        public void UpdateFlight(Flight flight)
        {
            _flightRepository.Update(flight);
        }
    }
}
