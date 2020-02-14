using Flights.Core.Interfaces;
using Flights.Core.Model;
using MongoDB.Driver;
using System.Collections.Generic;

namespace Flights.Dal.Repositories
{
    public class MongoFlightRepository : IFlightRepository
    {
        private readonly IMongoCollection<Flight> _flightCollection;

        public MongoFlightRepository()
        {
            var client = new MongoClient("mongodb://localhost:27017/admin");
            var database = client.GetDatabase("MongoExample");

            _flightCollection = database.GetCollection<Flight>("Flights");
        }

        public Flight Get(string id)
        {
            return _flightCollection.Find<Flight>(flight => flight.Id == id).FirstOrDefault();
        }

        public List<Flight> GetAll(string filter)
        {
            if (string.IsNullOrWhiteSpace(filter))
            {
                return _flightCollection.Find(flight => true).ToList();
            } else
            {
                return _flightCollection.Find(filter).ToList();
            }
        }

        public void Insert(Flight flightIn)
        {
            _flightCollection.InsertOne(flightIn);
        }

        public void Update(Flight flightIn)
        {
            _flightCollection.ReplaceOne(flight => flight.Id == flightIn.Id, flightIn);
        }

        public void Delete(string id)
        {
            _flightCollection.DeleteOne(flight => flight.Id == id);
        }
    }
}
