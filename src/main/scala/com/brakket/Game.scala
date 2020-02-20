//#full-example
package com.brakket

import akka.actor.Actor
import akka.actor.typed.ActorSystem
import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import scala.util.Random.nextFloat
import akka.event.Logging
import akka.actor.Props

// Data type for team
case class Team(name: String, seed: Int)


object GameSimulation {

  // logic for simulating the winner of the game
  def simulateGameResult(first: Team, second: Team): Team = {
    // val probFirstWins = seedProbs(first.seed)(second.seed)
    val probFirstWins = 0.5
    val sample = nextFloat
    val winningTeam = if(sample < probFirstWins) first else second
    val losingTeam = if(sample >= probFirstWins) first else second
    // log result
    println(s"${winningTeam.name} beat ${losingTeam.name}!")
    winningTeam
  }
}


// games are actors that contain pointers to the next game
// TODO: should be using typed actors?
class Game(location: String) extends Actor {

  val log = Logging(context.system, this)

  override def preStart() = {
    // log creation
    log.info(s"created actor at ${location}")
    // check length of location string 
    if(location.length == 3) {
      // TODO update this 
      println("this is a leaf node")
    } else {
      // TODO create actors
      val childOneL = location + "r"
      val childOne = context.actorOf(Props(new Game(childOneL)), childOneL)
      val childTwoL = location + "l"
      val childTwo = context.actorOf(Props(new Game(childTwoL)), childTwoL)
      // TODO does this work
    }
  }

  // TODO check position, if at leaf read teams and run simulation
  // TODO else recursively build child actors

  case class Winner(team: Team)

  def receive = active(Set.empty[Team])

  // our internal state is the set of winning teams we've received from prior games 
  def active(teamsReceived: Set[Team]): Receive = {
    // if we have already received the other winner, simulate the game with the
    // received team
    case Winner(team) => {
      if(teamsReceived.size == 0) {
        // if we haven't received the other winner yet
        // we add the winner we've received into the teams buffer
        context become active(teamsReceived + team)
      } else {
        // if we have received the other winner, simulate that team vs. the received team
        val winner = GameSimulation.simulateGameResult(
          teamsReceived.head, team
        )
        // then send that winner as a message to the next game
        context.parent ! Winner(winner)
      }
    } 
  }
}



