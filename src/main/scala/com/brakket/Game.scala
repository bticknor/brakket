//#full-example
package com.brakket

import akka.actor.Actor

import akka.actor.typed.ActorRef
import akka.actor.typed.ActorSystem
import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors


case class Team(name: String, seed: Int)


object GameSimulation {

  // TODO simulate the result of this
  def simulateGameResult(team1: Team, team2: Team) = team1

}


class BracketGame extends Actor {

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
        // TODO: add current team to set of teams used in simulation
      }
    } 
  }
}



