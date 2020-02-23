package brakket

import akka.actor.ActorSystem
import akka.actor.Props

// main class
object Simulation extends App {

  // actor system for simulation
  val system = ActorSystem("TournamentSimulation")

  // build the championship game, the root of the tournament
  // that recursively builds the tree in preStart()
  val championshipGame = system.actorOf(
    Props(new Game("")), "Championship"
  )
}

