package com.example.inventmanege.models;

import java.util.List;

public class Storage {
    private int idStorage;
    private String storageName;
    private List<Inventory> storedList;
    private int StoredPriority;

    public int getStoredPriority() {
        return StoredPriority;
    }

    public void setStoredPriority(int storedPriority) {
        StoredPriority = storedPriority;
    }

    public int getIdStorage() {
        return idStorage;
    }

    public void setIdStorage(int idStorage) {
        this.idStorage = idStorage;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public List<Inventory> getStoredList() {
        return storedList;
    }

    public void setStoredList(List<Inventory> storedList) {
        this.storedList = storedList;
    }

    public Storage(int idStorage, String storageName, List<Inventory> storedList) {
        this.idStorage = idStorage;
        this.storageName = storageName;
        this.storedList = storedList;
    }

    public Storage(int idStorage, String storageName) {
        this.idStorage = idStorage;
        this.storageName = storageName;
    }

    public Storage() {
    }
}
