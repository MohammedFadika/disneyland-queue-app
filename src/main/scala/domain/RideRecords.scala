/* shape each row data is received in */

package domain 

case class RideRecordsData(
    rideId : String,
    rideName : String,
    isOpen :   Boolean,
    waitTime: Int,
    date: String,
    timestamp: String
    )
/*All possible Status*/
enum RideStatus:
    case Open(waitTime : Int)
    case Closed
    case Unknown

case class RideState(
    rideId : String,
    rideName: String,
    status: RideStatus,
    lastUpdated: String
    )
