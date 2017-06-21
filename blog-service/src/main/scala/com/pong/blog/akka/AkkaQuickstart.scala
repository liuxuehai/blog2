package com.pong.blog.akka

import akka.actor.ActorRef
import akka.actor.Props
import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.ActorSystem
import scala.io.StdIn

object Greeter {
  def props(message: String, printerActor: ActorRef): Props = Props(new Greeter(message, printerActor))
  final case class WhoToGreet(who: String)
  case object Greet
}

class Greeter(message: String, printerActor: ActorRef) extends Actor {
  import Greeter._
  import Printer._

  var greeting = ""

  def receive = {
    case WhoToGreet(who) =>
      greeting = s"$message,$who"
    case Greet =>
      printerActor ! Greeting(greeting)
  }
}

object Printer {
  def props: Props = Props[Printer]
  final case class Greeting(greeting: String)
}

class Printer extends Actor with ActorLogging {
  import Printer._

  def receive = {
    case Greeting(greeting) =>
      log.info(s"Greeting received (from ${sender()}): $greeting")
  }

}

object AkkaQuickstart extends App {
  import Greeter._

  val system: ActorSystem = ActorSystem("helloAkka")

  try {

    val printer: ActorRef = system.actorOf(Printer.props, "printerActor")

    val howdyGreeter: ActorRef = system.actorOf(Greeter.props("howdy", printer), "howdyGreeter")
    val helloGreeter: ActorRef = system.actorOf(Greeter.props("Hello", printer), "helloGreeter")
    val goodGreeter: ActorRef = system.actorOf(Greeter.props("Good day", printer), "goodGreeter")

    howdyGreeter ! WhoToGreet("akka")

    howdyGreeter ! Greet
    
    howdyGreeter ! WhoToGreet("Lightbend")
    howdyGreeter ! Greet

    helloGreeter ! WhoToGreet("Scala")
    helloGreeter ! Greet

    goodGreeter ! WhoToGreet("Play")
    goodGreeter ! Greet


    println(">>> Press ENTER to exit <<<")
    StdIn.readLine()
  } finally {
    system.terminate()
  }
}