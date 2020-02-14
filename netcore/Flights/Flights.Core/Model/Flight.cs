using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;

namespace Flights.Core.Model
{
    public class Flight
    {
        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string Id { get; set; }
        public string ScheduleTime { get; set; }
        public string Number { get; set; }
        public string Airline{ get; set; }
        public string Origin { get; set; }
        public string Destination { get; set; }
        public string Status { get; set; }
    }
}
