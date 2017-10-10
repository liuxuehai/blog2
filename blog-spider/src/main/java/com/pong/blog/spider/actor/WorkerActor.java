package com.pong.blog.spider.actor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import akka.actor.AbstractActor;

@Component("workerActor")
@Scope("prototype")
public class WorkerActor extends AbstractActor {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Receive createReceive() {
		return receiveBuilder().match(String.class, s -> {
			logger.info("获取消息:{}",s);
			
			

		}).matchAny(s -> {
			System.out.printf("get %s\n", s);
		}).build();
	}
}
