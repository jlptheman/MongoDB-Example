using Flights.Core.Interfaces;
using Flights.Core.Model;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Flights.Dal.Repositories
{
    public class InMemoryFlightRepository : IFlightRepository
    {
        private readonly List<Flight> _flights = new List<Flight>();

        public InMemoryFlightRepository()
        {
            _flights.AddRange(
                new List<Flight>
                {
                    new Flight
                    {
                        Id =Guid.NewGuid().ToString(),
                        Airline = "BA",
                        Number = "123",
                        Origin = "DUB",
                        Destination = "LHR",
                        ScheduleTime = "2020.02.12 14:00:00",
                        Status = "On Time"
                    },
                    new Flight
                    {
                        Id = Guid.NewGuid().ToString(),
                        Airline = "BA",
                        Number = "456",
                        Origin = "DUB",
                        Destination = "LHR",
                        ScheduleTime = "2020.02.12 20:00:00",
                        Status = "On Time"
                    }
                }
            );
        }

        public Flight Get(string id)
        {
            return _flights.FirstOrDefault(f => f.Id == id);
        }

        public List<Flight> GetAll(string filter)
        {
            return _flights;
        }

        public void Insert(Flight flight)
        {
            flight.Id = Guid.NewGuid().ToString();
            _flights.Add(flight);
        }

        public void Update(Flight flight)
        {
            var match = _flights.FirstOrDefault(f => f.Id == flight.Id);
            if(match != null)
            {
                _flights.Remove(match);
                _flights.Add(flight);
            }
        }
        public void Delete(string id)
        {
            var match = _flights.FirstOrDefault(f => f.Id == id);
            if (match != null)
            {
                _flights.Remove(match);
            }
        }
    }
}
