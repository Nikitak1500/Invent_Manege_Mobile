package com.example.inventmanege.models;

public class Inventory {
    private int idinv;
    private String invName;

    private int invRespId;
    private String invRespName;

    private String invInstruction;
    private float invWeight;

    private int invTypeId;
    private String invTypeName;

    private int invPositionId;
    private String invPositionName;

    private String invRFID;

    public Inventory(int idinv, String invName,
                     int invRespId,
                     String invInstruction, float invWeight,
                     int invTypeId,
                     int invPositionId) {
        this.idinv = idinv;
        this.invName = invName;
        this.invRespId = invRespId;
        this.invInstruction = invInstruction;
        this.invWeight = invWeight;
        this.invTypeId = invTypeId;
        this.invPositionId = invPositionId;
    }

    public Inventory() {

    }

    public int getIdinv() {
        return idinv;
    }

    public void setIdinv(int idinv) {
        this.idinv = idinv;
    }

    public String getInvName() {
        return invName;
    }

    public void setInvName(String invName) {
        this.invName = invName;
    }

    public int getInvRespId() {
        return invRespId;
    }

    public void setInvRespId(int invRespId) {
        this.invRespId = invRespId;
    }

    public String getInvRespName() {
        return invRespName;
    }

    public void setInvRespName(String invRespName) {
        this.invRespName = invRespName;
    }

    public String getInvInstruction() {
        return invInstruction;
    }

    public void setInvInstruction(String invInstruction) {
        this.invInstruction = invInstruction;
    }

    public float getInvWeight() {
        return invWeight;
    }

    public void setInvWeight(float invWeight) {
        this.invWeight = invWeight;
    }

    public int getInvTypeId() {
        return invTypeId;
    }

    public void setInvTypeId(int invTypeId) {
        this.invTypeId = invTypeId;
    }

    public String getInvTypeName() {
        return invTypeName;
    }

    public void setInvTypeName(String invTypeName) {
        this.invTypeName = invTypeName;
    }

    public int getInvPositionId() {
        return invPositionId;
    }

    public void setInvPositionId(int invPositionId) {
        this.invPositionId = invPositionId;
    }

    public String getInvPositionName() {
        return invPositionName;
    }

    public void setInvPositionName(String invPositionName) {
        this.invPositionName = invPositionName;
    }

    public String getInvRFID() {
        return invRFID;
    }

    public void setInvRFID(String invRFID) {
        this.invRFID = invRFID;
    }
}
