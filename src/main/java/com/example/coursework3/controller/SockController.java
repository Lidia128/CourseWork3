package com.example.coursework3.controller;

import com.example.coursework3.dto.SockRequest;
import com.example.coursework3.model.Color;
import com.example.coursework3.model.Size;
import com.example.coursework3.model.Sock;
import com.example.coursework3.service.SockService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sock")

public class SockController {
    private final SockService sockService;

    public SockController(SockService sockService) {
        this.sockService = sockService;
    }

    @PostMapping
    public void addSocks(@RequestBody SockRequest sockRequest) {
        sockService.addSock(sockRequest);
    }

    @PutMapping
    public void issueSocks(@RequestBody SockRequest sockRequest) {
        sockRequest.issueSock (sockRequest);
    }
    @GetMapping
    public int getSockeCounte (@RequestParam (required = false, name = "color") Color color,
                               @RequestParam (required = false, name =  "size") Size size,
                               @RequestParam (required = false, name = "cottonMin") Integer cottonMin,
                               @RequestParam (required = false, name = "cottonMax") Integer cottonMax){
        return  sockService.getsockQuentity(color, size, cottonMin, cottonMax);
    }
}
