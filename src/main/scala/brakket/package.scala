
package object brakket {
  val greeting = "welcome to March Madness simulation!"

  // maps the beginning of a leaf nodes location string
  // to the region of that nodes Game
  val regions: Map[String, Map[String, String]] = Map(
    "rr" -> Seeds.eastRegion,
    "rl" -> Seeds.westRegion,
    "lr" -> Seeds.southRegion,
    "ll" -> Seeds.midwestRegion
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
  // TODO: seeds are ints or strings?
  // TODO: clean this up
  // higher seeds win by default when playing lower seeds and we don't have
  // data
  val defaultHigherSeedProb: Double = 1.000

  val probSeedWins: Map[Int, Map[Int, Double]] = Map(
    1 -> Map(
      2 -> 0.545,
      3 -> 0.634,
      4 -> 0.705,
      5 -> 0.825,
      6 -> 0.706,
      7 -> 0.857,
      8 -> 0.791,
      9 -> 0.905,
      10 -> 0.875,
      11 -> 0.556,
      12 -> 1.000,
      13 -> 1.000,
      14 -> defaultHigherSeedProb,
      15 -> defaultHigherSeedProb,
      16 -> 0.993
    ),
    2 -> Map(
      3 -> 0.609,
      4 -> 0.500,
      5 -> 0.286,
      6 -> 0.722,
      7 -> 0.700,
      8 -> 0.400,
      9 -> 0.667,
      10 -> 0.635,
      11 -> 0.842,
      12 -> 1.000,
      13 -> defaultHigherSeedProb,
      14 -> defaultHigherSeedProb,
      15 -> 0.932,
      16 -> defaultHigherSeedProb
    ),
    3 -> Map(
      4 -> 0.625,
      5 -> 0.500,
      6 -> 0.581,
      7 -> 0.611,
      8 -> 1.000,
      9 -> 1.000,
      10 -> 0.692,
      11 -> 0.661,
      12 -> defaultHigherSeedProb,
      13 -> defaultHigherSeedProb,
      14 -> 0.851,
      15 -> 0.667,
      16 -> defaultHigherSeedProb
    ),
    4 -> Map(
      5 -> 0.561,
      6 -> 0.333,
      7 -> 0.333,
      8 -> 0.333,
      9 -> 0.500,
      10 -> 1.000,
      11 -> defaultHigherSeedProb,
      12 -> 0.705,
      13 -> 0.791,
      14 -> defaultHigherSeedProb,
      15 -> defaultHigherSeedProb,
      16 -> defaultHigherSeedProb
    ),
    5 -> Map(
      6 -> 1.000,
      7 -> defaultHigherSeedProb,
      8 -> 0.250,
      9 -> 0.250,
      10 -> 1.00,
      11 -> defaultHigherSeedProb,
      12 -> 0.667,
      13 -> 0.842,
      14 -> defaultHigherSeedProb,
      15 -> defaultHigherSeedProb,
      16 -> defaultHigherSeedProb
    ),
    6 -> Map(
      7 -> 0.667,
      8 -> 0.250,
      9 -> defaultHigherSeedProb,
      10 -> 0.600,
      11 -> 0.625,
      12 -> defaultHigherSeedProb,
      13 -> defaultHigherSeedProb,
      14 -> 0.875,
      15 -> defaultHigherSeedProb,
      16 -> defaultHigherSeedProb
    ),
    7 -> Map(
      8 -> 0.500,
      9 -> defaultHigherSeedProb,
      10 -> 0.602,
      11 -> 0.000,
      12 -> defaultHigherSeedProb,
      13 -> defaultHigherSeedProb,
      14 -> 1.000,
      15 -> 0.40,
      16 -> defaultHigherSeedProb
    ),
    8 -> Map(
      9 -> 0.512,
      10 -> defaultHigherSeedProb,
      11 -> 1.000,
      12 -> 0.000,
      13 -> 1.000,
      14 -> defaultHigherSeedProb,
      15 -> 1.000,
      16 -> defaultHigherSeedProb
    ),
    9 -> Map(
      10 -> 1.000,
      11 -> 0.000,
      12 -> defaultHigherSeedProb,
      13 -> 1.000,
      14 -> defaultHigherSeedProb,
      15 -> defaultHigherSeedProb,
      16 -> 1.000
    ),
    10 -> Map(
      11 -> 0.50,
      12 -> defaultHigherSeedProb,
      13 -> defaultHigherSeedProb,
      14 -> 1.000,
      15 -> 1.000,
      16 -> defaultHigherSeedProb
    ),
    11 -> Map(
      12 -> defaultHigherSeedProb,
      13 -> defaultHigherSeedProb,
      14 -> 1.000,
      15 -> defaultHigherSeedProb,
      16 -> defaultHigherSeedProb
    ),
    12 -> Map(
      13 -> 0.750,
      14 -> defaultHigherSeedProb,
      15 -> defaultHigherSeedProb,
      16 -> defaultHigherSeedProb
    ),
    13 -> Map(
      14 -> defaultHigherSeedProb,
      15 -> defaultHigherSeedProb,
      16 -> defaultHigherSeedProb
    ),
    14 -> Map(
      15 -> defaultHigherSeedProb,
      16 -> defaultHigherSeedProb
    ),
    15 -> Map(
      16 -> defaultHigherSeedProb
    )
  )
}
