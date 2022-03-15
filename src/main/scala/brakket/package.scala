
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
      2 -> 0.533,
      3 -> 0.625,
      4 -> 0.707,
      5 -> 0.833,
      6 -> 0.688,
      7 -> 0.857,
      8 -> 0.802,
      9 -> 0.900,
      10 -> 0.857,
      11 -> 0.571,
      12 -> 1.000,
      13 -> 1.000,
      14 -> defaultHigherSeedProb,
      15 -> defaultHigherSeedProb,
      16 -> 0.993
    ),
    2 -> Map(
      3 -> 0.603,
      4 -> 0.444,
      5 -> 0.167,
      6 -> 0.722,
      7 -> 0.701,
      8 -> 0.444,
      9 -> 0.500,
      10 -> 0.633,
      11 -> 0.875,
      12 -> 1.000,
      13 -> defaultHigherSeedProb,
      14 -> defaultHigherSeedProb,
      15 -> 0.943,
      16 -> defaultHigherSeedProb
    ),
    3 -> Map(
      4 -> 0.625,
      5 -> 0.500,
      6 -> 0.578,
      7 -> 0.611,
      8 -> 1.000,
      9 -> 1.000,
      10 -> 0.692,
      11 -> 0.691,
      12 -> defaultHigherSeedProb,
      13 -> defaultHigherSeedProb,
      14 -> 0.850,
      15 -> 1.000,
      16 -> defaultHigherSeedProb
    ),
    4 -> Map(
      5 -> 0.558,
      6 -> 0.333,
      7 -> 0.333,
      8 -> 0.364,
      9 -> 0.500,
      10 -> 1.000,
      11 -> defaultHigherSeedProb,
      12 -> 0.707,
      13 -> 0.799,
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
      12 -> 0.669,
      13 -> 0.824,
      14 -> defaultHigherSeedProb,
      15 -> defaultHigherSeedProb,
      16 -> defaultHigherSeedProb
    ),
    6 -> Map(
      7 -> 0.625,
      8 -> 0.250,
      9 -> defaultHigherSeedProb,
      10 -> 0.600,
      11 -> 0.638,
      12 -> defaultHigherSeedProb,
      13 -> 0.00,
      14 -> 0.875,
      15 -> defaultHigherSeedProb,
      16 -> defaultHigherSeedProb
    ),
    7 -> Map(
      8 -> 0.500,
      9 -> defaultHigherSeedProb,
      10 -> 0.604,
      11 -> 0.000,
      12 -> defaultHigherSeedProb,
      13 -> defaultHigherSeedProb,
      14 -> 1.000,
      15 -> 0.667,
      16 -> defaultHigherSeedProb
    ),
    8 -> Map(
      9 -> 0.512,
      10 -> defaultHigherSeedProb,
      11 -> 1.000,
      12 -> 0.000,
      13 -> 1.000,
      14 -> defaultHigherSeedProb,
      15 -> defaultHigherSeedProb,
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
      11 -> 0.333,
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
