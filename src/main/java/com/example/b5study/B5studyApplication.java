package com.example.b5study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RespectBinding;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Controller
public class B5studyApplication {

    public static void main(String[] args) {
        SpringApplication.run(B5studyApplication.class, args);
    }

    @GetMapping("/")
    @ResponseBody
    public Map<String, Object> root() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "hello, world");
        response.put("object", new HashMap<String, String>() {
            {
                put("key1", "val1");
            }

            {
                put("key2", "val2");
            }
        });
        return response;
    }

    @GetMapping("/{user_name}")
    @ResponseBody
    public Map<String, String> users(
            @PathVariable("user_name") String userName,
            @RequestParam(name = "custom_message", required = false) String customMessage) {
	    Map<String, String> response = new HashMap<>();
	    response.put("message", "Hello" + userName + " " + customMessage);
	    return response;
    }

    @GetMapping("/index/{user_name}")
    public String user_index(@PathVariable("user_name") String userName, Model model){
        model.addAttribute("userName", userName);
        return "user_index";
    }

}
