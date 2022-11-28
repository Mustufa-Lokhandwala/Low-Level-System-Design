package model;

import model.enums.SeatCategory;

public class Seat {
    private int id;
    private SeatCategory seatCategory;
    private int price;

    public Seat(int id, SeatCategory seatCategory, int price) {
        this.id = id;
        this.seatCategory = seatCategory;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public int getPrice() {
        return price;
    }
}
