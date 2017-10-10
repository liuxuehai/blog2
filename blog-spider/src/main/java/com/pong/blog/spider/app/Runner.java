package com.pong.blog.spider.app;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pong.blog.spider.extension.SpringExtension;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import scala.concurrent.duration.Duration;

@Component
public class Runner implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ActorSystem actorSystem;

	@Autowired
	private SpringExtension springExtension;

	@Override
	public void run(String... args) throws Exception {
		try {
			logger.info("定时任务开始");

			ActorRef workerActor = actorSystem.actorOf(springExtension.props("workerActor"), "worker-actor");
			actorSystem.scheduler().schedule(Duration.create(1, TimeUnit.SECONDS),
					Duration.create(1, TimeUnit.SECONDS), new Runnable() {
						public void run() {
							workerActor.tell("ping", null);
						}
					}, actorSystem.dispatcher());
		} finally {
			logger.info("定时任务结束");
		}
	}

}
