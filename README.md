# The dumb March Madness tournament simulator, built on Akka

Tired of pretending to know what you are doing while filling out March Madness brackets?  Leave every game up to random chance!  This program uses the historical seed matchup records (according to this site: http://mcubed.net/ncaab/seeds.shtml) to run a bernoulli trial for each game, thus picking the winner.  If two seeds have never met in a tournament game, the higher seeded (lower seed number) team is automatically moved forward.

# Running the simulation

- Install SBT
- Clone down this repo
- Check the tournament seedings json files and edit them if necessary:

  `src/main/resources/{east, midwest, south, west}.json`

- Navigate to the repo home directory and compile and run with sbt: `$ sbt run`

# Output

Game results are logged to stdout

