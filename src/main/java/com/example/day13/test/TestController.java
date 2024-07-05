package com.example.day13.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping(method = RequestMethod.GET, value = "ex01")
    public ResponseEntity<String> ex01(){
        return ResponseEntity.ok("ex01");
    }
}
