package com.example.inventmanege.models;

import java.util.List;

public class Car {
    private int idCar;
    private String carName;
    private float carCarrying;
    private List<Inventory> transportList;
    private int carPriority;

    public int getCarPriority() {
        return carPriority;
    }

    public void setCarPriority(int carPriority) {
        this.carPriority = carPriority;
    }

    public List<Inventory> getTransportList() {
        return transportList;
    }

    public void setTransportList(List<Inventory> transportList) {
        this.transportList = transportList;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public float getCarCarrying() {
        return carCarrying;
    }

    public void setCarCarrying(float carCarrying) {
        this.carCarrying = carCarrying;
    }

    public Car() {
    }

    public Car(int idCar, String carName, float carCarrying) {
        this.idCar = idCar;
        this.carName = carName;
        this.carCarrying = carCarrying;
    }

    public Car(int idCar, String carName, float carCarrying, List<Inventory> transportList) {
        this.idCar = idCar;
        this.carName = carName;
        this.carCarrying = carCarrying;
        this.transportList = transportList;
    }
}
