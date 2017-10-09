package com.pong.blog.spider.actor;

import org.springframework.context.annotation.Scope;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.actor.Status;



@Scope("prototype")  
public class DetectActor2 extends AbstractActor {

	public static Props props(String response) {
		return Props.create(DetectActor2.class, response);
	}

	@Override
	public Receive createReceive() {
		return receiveBuilder().match(String.class, s -> {

			System.out.printf("get %s\n", s);
			sender().tell("Hi", self());

		}).matchAny(x -> {
			System.out.printf("I dont know what you see in DetectActor,%s", getContext().self().path());
			sender().tell(new Status.Failure(new Exception("I dont know what you see")), self());
		}).build();
	}
}
