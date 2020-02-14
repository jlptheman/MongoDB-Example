using Flights.Core.Model;
using System.Collections.Generic;

namespace Flights.Core.Interfaces
{
    public interface IFlightRepository
    {
        Flight Get(string id);
        List<Flight> GetAll(string query);
        void Insert(Flight flight);
        void Update(Flight flight);
        void Delete(string id);
    }
}
