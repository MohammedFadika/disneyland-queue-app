package adapters
import ports.RideRepository
import domain.RideRecordsData

/* Adapter */

class InMemoryRideRepository extends RideRepository {
    override def fetchAllRecords(): Either[String, List[RideRecordsData]] = Right(
        List(
        RideRecordsData("114", "Test Ride", true, 5, "2026-10-29", "08:00"),
        RideRecordsData("225", "Medium Ride", true, 15, "2026-10-29", "08:00"),
        RideRecordsData("1411", "Slow Ride", true, 45, "2026-10-29", "08:00"),
        RideRecordsData("4757", "Closed Ride", false, 0, "2026-10-29", "08:00"),
        RideRecordsData("5553", "Very Slow Ride", true, 60, "2026-10-29", "08:00"),
        RideRecordsData("6672", "Unknown Wait Ride", true, -1, "2026-10-29", "08:00")
    )
    )
}