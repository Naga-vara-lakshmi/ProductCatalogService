package com.techwave.ProductService.FeignProxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.techwave.ProductService.FeignClinetConfig.FeignClientConfiguration;

@FeignClient(name = "SpringSecurityDemo",url = "localhost:8080",configuration = FeignClientConfiguration.class)
public interface UserProxy {
	@GetMapping("/user/getUserById/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable int id);

}
