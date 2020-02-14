using Flights.Core.Interfaces;
using Flights.Core.Model;
using Microsoft.AspNetCore.Mvc;

namespace Flights.Web.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class FlightsController : Controller
    {
        private readonly IFlightService _flightService;

        public FlightsController(IFlightService flightService)
        {
            _flightService = flightService;
        }

        [HttpGet("{id}")]
        public IActionResult Get(string id)
        {
            return new OkObjectResult(_flightService.GetFlight(id));
        }

        [HttpGet]
        public IActionResult GetAll([FromQuery]string filter)
        {
            return new OkObjectResult(_flightService.GetFlights(filter));
        }

        [HttpPost]
        public IActionResult Insert(Flight flight)
        {
            _flightService.InsertFlight(flight);
            return new OkResult();
        }

        [HttpPut("{id}")]
        public IActionResult Update(string id, Flight flight)
        {
            _flightService.UpdateFlight(flight);
            return new OkResult();
        }

        [HttpDelete("{id}")]
        public IActionResult Delete(string id)
        {
            _flightService.DeleteFlight(id);
            return new NoContentResult();
        }
    }
}