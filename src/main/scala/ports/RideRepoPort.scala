package ports
import domain.RideRecordsData
import domain.RideState
 
/* Output port to ask for data */

trait RideRepository {
    def fetchAllRecords() : Either[String, List[RideRecordsData]]
}

/* Input port to trigger action from inside */

trait RideService {
    def listRides() : List[RideState]
    def findRides(rideID: String) : Option[RideState]     // evaluates to None or some type
    def recommendRides(): List[RideState]
}

