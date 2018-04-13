package io.github.cepr0.secondapp;

import io.github.cepr0.commonpart.Repo;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
@EnableJpaRepositories(basePackages = "io.github.cepr0.commonpart")
@EntityScan("io.github.cepr0.commonpart")
@EnableScheduling
@SpringBootApplication
public class SecondApplication {
	
	private static final AtomicLong COUNTER = new AtomicLong(0L);
	
	@NonNull private final Repo repo;
	
	public SecondApplication(Repo repo) {
		this.repo = repo;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SecondApplication.class, args);
	}
	
	@Bean
	public TaskScheduler taskScheduler() {
		return new ThreadPoolTaskScheduler();
	}
	
	@PostConstruct
	private void appStarted() {
		taskScheduler().schedule(this::checkModel, new PeriodicTrigger(5, SECONDS));
	}
	
	private void checkModel() {
		long count = repo.count();
		if (count > COUNTER.get()) {
			log.info("Models count: {}", count);
			COUNTER.set(count);
		}
	}
	
}
