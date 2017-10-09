package com.pong.blog.spider.actor;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import akka.actor.AbstractActor;


@Component("workerActor")
@Scope("prototype")
public class WorkerActor extends AbstractActor {

	@Override
	public Receive createReceive() {
		return receiveBuilder().match(Request.class, s -> {

			System.out.printf("get %s\n", s);
			sender().tell("Hi", self());

		}).match(Response.class,s  -> {
			System.out.printf("get %s\n", s);
			sender().tell("Hi", self());
		}).build();
	}
	
	
	public static class Request {
	}

	public static class Response {
	}
}
