package adapters
import ports.*
import domain.*
import scala.io.Source.* 
import java.io.PrintWriter 
import java.io.PrintWriter

@main def BatchAdapter() : Unit = {
    
    val sourceData: RideRepository = new csvRepoOutAdapter("queuetimes.csv")
    
    val batchRepo: RideServiceImpl = new RideServiceImpl(sourceData)

    val OutputOfCommands = new PrintWriter("testoutput.txt")

    val commandreading = scala.io.Source.fromFile("testCommands.txt")
        .getLines()
        .takeWhile(line => line != "exit")   //stops when finding "exit"
        .foreach(line =>
            if (line == "list") {
                OutputOfCommands.println(batchRepo.listRides())
                }
            else if (line.startsWith("find ")) {
                OutputOfCommands.println(batchRepo.findRides(line.stripPrefix("find ")))
                }
            else if (line == "recommend") {
                OutputOfCommands.println(batchRepo.recommendRides())
                }
            )
    OutputOfCommands.close()


}