package domain
import ports.* 
import domain.RideState

/* Implementing Ride Service trait as a class */

class RideServiceImpl(repo: RideRepository) extends RideService {
    
    override def listRides(): List[RideState] = {
        repo.fetchAllRecords() match {
        case Right(records) => records
            .groupBy(_.rideId)
            .values
            .map(lOfRideHistory => lOfRideHistory.maxBy(k => (k.date, k.timestamp))) // single latest record now shape of: RideRecordsdata
            .map(latestRecord => RideState(latestRecord.rideId, latestRecord.rideName, 
                { if (latestRecord.isOpen && latestRecord.waitTime >= 0) {RideStatus.Open(latestRecord.waitTime)}
                    else if (!latestRecord.isOpen) {RideStatus.Closed}
                    else {RideStatus.Unknown}
                    },
                s"${latestRecord.date} ${latestRecord.timestamp}"))   //changing the shape of the latest record to: RideState 
                .toList
                .sortBy(_.rideId)
                
             

        case Left(error) => List()
    } 
    }

    override def findRides(rideID: String): Option[RideState] = ???

    override def recommendRides(): List[RideState] =  ??? 
}