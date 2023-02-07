package com.example.coursework3.dto;

import com.example.coursework3.model.Color;
import com.example.coursework3.model.Size;
import com.example.coursework3.model.Sock;

public class SockRequest {
    private Color color;
    private Size size;
    private int cottonPercentege;
    private int quantity;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getCottonPercentege() {
        return cottonPercentege;
    }

    public void setCottonPercentege(int cottonPercentege) {
        this.cottonPercentege = cottonPercentege;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void issueSock(SockRequest sockRequest) {
    }
}