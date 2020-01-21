package com.tcoots.songr;

import org.springframework.web.bind.annotation.*;


@RestController
public class HelloWorld {


    @GetMapping("/hello")
    public String helloWorld(){
        return "hello";
    }

    @GetMapping("/capitalize/{textInput}")
    public String toUpperCase(@PathVariable String textInput){
        return textInput.toUpperCase();
    }


}
