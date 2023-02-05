package com.example.coursework3.service;

import com.example.coursework3.dto.SockRequest;
import com.example.coursework3.exception.InvalidSockRequestException;
import com.example.coursework3.model.Color;
import com.example.coursework3.model.Size;
import com.example.coursework3.model.Sock;

import javax.naming.InsufficientResourcesException;
import java.util.HashMap;
import java.util.Map;

public class SockService {
    private final Map<Sock, Integer> socks = new HashMap<>();

    public void addSock(SockRequest sockRequest) {
        validateRequest(sockRequest);
        Sock sock = mapToSock(sockRequest);
        if (socks.containsKey(sock)) {
            socks.put(sock, socks.get(sock) + sockRequest.getQuantity());
        } else {
            socks.put(sock, sockRequest.getQuantity());
        }
    }

    public void issueSock(SockRequest sockRequest) throws InsufficientResourcesException {
        validateRequest(sockRequest);
        Sock sock = mapToSock(sockRequest);
        int sockQuentity = socks.getOrDefault(sock, 0);
        if (sockQuentity >= sockRequest.getQuantity()) {
            socks.put(sock, sockQuentity - sockRequest.getQuantity());
        } else {
            throw new InsufficientResourcesException("Носков больше нет");
        }
    }

    public int getsockQuentity(Color color, Size size, Integer cottonMin, Integer cottonMax) {
        int total = 0;
        for (Map.Entry<Sock, Integer> entry : socks.entrySet()) {
            if (color != null && !entry.getKey().getColor().equals(color)) {
                continue;
            }
            if (size != null && !entry.getKey().getSize().equals(size)) {
                continue;
            }
            if (cottonMin != null && entry.getKey().getCottonPercentage() < cottonMin) {
                continue;
            }
            if (cottonMax != null && entry.getKey().getCottonPercentage() > cottonMax) {
                continue;
            }
            total += entry.getValue();
        }
        return total;
    }
        private void validateRequest (SockRequest sockRequest){
            if ((sockRequest.getColor() == null || sockRequest.getSize() == null)) {
                throw new RuntimeException("Все поля должны быть заполненны");
            }
            if (sockRequest.getCottonPercentege() < 0 || sockRequest.getCottonPercentege() > 100) {
                throw new RuntimeException("Процент хлопка должен быть от 0 до 100");
            }
            if (sockRequest.getQuantity() <= 0) {
                throw new RuntimeException("Количество долджно быть больше 0");
            }
        }

        private Sock mapToSock (SockRequest sockRequest){
            return new Sock(sockRequest.getColor(), sockRequest.getSize(), sockRequest.getCottonPercentege());

        }
    }
