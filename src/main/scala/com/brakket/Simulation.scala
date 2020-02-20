package com.brakket

import akka.actor.ActorSystem
import akka.actor.Props

// main class
object Simulation extends App {

  // actor system for simulation
  val system = ActorSystem("TournamentSimulation")

  // TODO: recursively create actor
  val championshipGame = system.actorOf(Props(new Game("r")), "Championship")
 
}

