import scala.io.Source
import scala.io._
import java.io._
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper


package object brakket {
  val greeting = "welcome to March Madness simulation!"
 
  def loadRegion(filePath: String): Map[String, Object] = {
    // load region from json file into map 
    val json = Source.fromURL(getClass.getResource(filePath))
    val mapper = new ObjectMapper() with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    val parsedJson = mapper.readValue[Map[String, Object]](json.reader())
    parsedJson
  }

  // load in region seed data
  val westRegion = loadRegion("/west.json")
  val eastRegion = loadRegion("/east.json")
  val southRegion = loadRegion("/south.json")
  val midwestRegion = loadRegion("/midwest.json")

  // maps the beginning of a leaf nodes location string
  // to the region of that nodes Game
  val regions: Map[String, Map[String, Object]] = Map(
    "rr" -> eastRegion,
    "rl" -> westRegion,
    "lr" -> southRegion,
    "ll" -> midwestRegion
  )
  // static map from bracket locations to seeds
  val regionLocationsToSeeds: Map[String, (String, String)] = Map(
    "rrr" -> ("1", "16"),
    "rrl" -> ("8", "9"),
    "rlr" -> ("5", "12"),
    "rll" -> ("4", "13"),
    "lrr" -> ("6", "11"),
    "lrl" -> ("3", "14"),
    "llr" -> ("7", "10"),
    "lll" -> ("2", "15")
  )

  // read in probabilities of seeds winning
}
