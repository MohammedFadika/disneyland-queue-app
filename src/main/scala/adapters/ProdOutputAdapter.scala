package adapters
import ports.* 
import domain.* 
import scala.io.Source.* 

class csvRepoOutAdapter(repoPath: String) extends RideRepository {
    
    override def fetchAllRecords(): Either[String, List[RideRecordsData]] = Right(

        scala.io.Source.fromFile(repoPath)
            .getLines()
            .drop(1)
            .map(line => line.split( """,(?=(?:[^"]*"[^"]*")*[^"]*$)""" ))
            .map(array => RideRecordsData(array(0), array(1), array(2).toBoolean, array(3).toInt, array(4), array(5)))
            .toList
    )


}