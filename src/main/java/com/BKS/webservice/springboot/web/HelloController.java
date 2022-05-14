package com.BKS.webservice.springboot.web;

import com.BKS.webservice.springboot.web.dto.HelloResponseDto;

import org.springframework.web.bind.annotation.*;


@RestController
// @EnableWebMvc
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


    @GetMapping("/hello/dto")
    @ResponseBody
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                                     @RequestParam("amount") int amount) {

        //return new ResponseEntity<>(new HelloResponseDto(name, amount), HttpStatus.OK);
        return new HelloResponseDto(name, amount);
    }
}
