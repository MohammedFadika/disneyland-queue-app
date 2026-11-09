package domain
import org.scalatest.funsuite.AnyFunSuite 
import adapters.InMemoryRideRepository

class RideSerivceTest extends AnyFunSuite {

    test("recommedRides retruns at most 3 open rides") {
        // setup 
        val testRepoB = new InMemoryRideRepository()
        val testService = new RideServiceImpl(testRepoB)

        //execute
        val recommendedRidesT = testService.recommendRides()

        //testing
        assert(recommendedRidesT.length == 3)


}
}

