package adapters
import ports.RideRepository
import domain.RideRecordsData

/* Adapter */
class InMemoryRideRepository extends RideRepository {
    override def fetchAllRecords(): Either[String, List[RideRecordsData]] = Right(
        List(
            RideRecordsData(
        "7667",
        "Test Ride",
        true,
        5,
        "29-10-26",
        "08:00"
    )
    )
    )

}