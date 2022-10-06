package com.vpindjou.Vpsallaumlines.model;

public class Track {


    //region 0. Konstanten
    private static final String DEFAULT_VALUE_STRINGS = ">noValueSetYet<";

    private static int DEFAULT_VALUE_INT = -1;

    private int trackId;
    private String VIN;
    private String carMark;
    private String carModel;
    private String loadingPort;
    private String dischargingPort;
    private String voyageNumber;
    private String trackStatus;
    private String receivedDate;
    private String shippedDate;
    private String deliveredDate;


    //endregion

    //region 2. Konstruktoren
    public Track() {
        this.trackId = DEFAULT_VALUE_INT;
        this.VIN = DEFAULT_VALUE_STRINGS;
        this.carMark = DEFAULT_VALUE_STRINGS;
        this.carModel = DEFAULT_VALUE_STRINGS;
        this.loadingPort = DEFAULT_VALUE_STRINGS;
        this.dischargingPort = DEFAULT_VALUE_STRINGS;
        this.voyageNumber = DEFAULT_VALUE_STRINGS;
        this.trackStatus = DEFAULT_VALUE_STRINGS;
        this.receivedDate = DEFAULT_VALUE_STRINGS;
        this.shippedDate = DEFAULT_VALUE_STRINGS;
        this.deliveredDate = DEFAULT_VALUE_STRINGS;


    }

    // überladener Konstruktor
    public Track(int trackId, String VIN, String carMark, String carModel, String loadingPort, String dischargingPort, String voyageNumber, String trackStatus, String receivedDate, String shippedDate, String deliveredDate) {
        this.trackId = trackId;
        this.VIN = VIN;
        this.carMark = carMark;
        this.carModel = carModel;
        this.loadingPort = loadingPort;
        this.dischargingPort = dischargingPort;
        this.voyageNumber = voyageNumber;
        this.trackStatus = trackStatus;
        this.receivedDate = receivedDate;
        this.shippedDate = shippedDate;
        this.deliveredDate = deliveredDate;
    }

    //endregion

    //region 3. Getter und Setter


    public static int getDefaultValueInt() {
        return DEFAULT_VALUE_INT;
    }

    public int getTrackId() {
        return trackId;
    }

    public String getVIN() {
        return VIN;
    }

    public String getCarMark() {
        return carMark;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getLoadingPort() {
        return loadingPort;
    }

    public String getDischargingPort() {
        return dischargingPort;
    }

    public String getVoyageNumber() {
        return voyageNumber;
    }

    public String getTrackStatus() {
        return trackStatus;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public String getDeliveredDate() {
        return deliveredDate;
    }


    public static void setDefaultValueInt(int defaultValueInt) {
        DEFAULT_VALUE_INT = defaultValueInt;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setLoadingPort(String loadingPort) {
        this.loadingPort = loadingPort;
    }

    public void setDischargingPort(String dischargingPort) {
        this.dischargingPort = dischargingPort;
    }

    public void setVoyageNumber(String voyageNumber) {
        this.voyageNumber = voyageNumber;
    }

    public void setTrackStatus(String trackStatus) {
        this.trackStatus = trackStatus;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public void setDeliveredDate(String deliveredDate) {
        this.deliveredDate = deliveredDate;
    }


    //endregion

    //region 4. toString Funktionen


    @Override
    public String toString() {
        return "Track{" +
                "trackId=" + trackId +
                ", VIN='" + VIN + '\'' +
                ", carMark='" + carMark + '\'' +
                ", carModel='" + carModel + '\'' +
                ", loadingPort='" + loadingPort + '\'' +
                ", dischargingPort='" + dischargingPort + '\'' +
                ", voyageNumber='" + voyageNumber + '\'' +
                ", trackStatus='" + trackStatus + '\'' +
                ", receivedDate='" + receivedDate + '\'' +
                ", shippedDate='" + shippedDate + '\'' +
                ", deliveredDate='" + deliveredDate + '\'' +
                '}';
    }

    //endregion

}
