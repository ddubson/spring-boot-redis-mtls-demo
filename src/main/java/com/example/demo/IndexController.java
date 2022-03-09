package com.example.demo;

import java.util.UUID;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	private final RedisTemplate<String, Object> redisTemplate;

	public IndexController(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@GetMapping("/")
	public String index() {
		redisTemplate.opsForValue().set("test", UUID.randomUUID().toString());
		return (String) redisTemplate.opsForValue().get("test");
	}
}
