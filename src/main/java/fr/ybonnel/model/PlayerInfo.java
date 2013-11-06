package fr.ybonnel.model;

import java.io.Serializable;
import java.util.List;

public class PlayerInfo implements Serializable {

    private String id;
    private String pseudo;
    private String photo;
    private int score;
    private int averageScore;
    private int nbSuccess;
    private int nbLose;
    private int elevatorAtFloor;
    private int peopleInTheElevator;
    private boolean doorIsOpen;
    private String lastErrorMessage;
    private String state;
    private List<FloorState> floorStates;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public int getNbSuccess() {
        return nbSuccess;
    }

    public void setNbSuccess(int nbSuccess) {
        this.nbSuccess = nbSuccess;
    }

    public int getNbLose() {
        return nbLose;
    }

    public void setNbLose(int nbLose) {
        this.nbLose = nbLose;
    }

    public int getElevatorAtFloor() {
        return elevatorAtFloor;
    }

    public void setElevatorAtFloor(int elevatorAtFloor) {
        this.elevatorAtFloor = elevatorAtFloor;
    }

    public int getPeopleInTheElevator() {
        return peopleInTheElevator;
    }

    public void setPeopleInTheElevator(int peopleInTheElevator) {
        this.peopleInTheElevator = peopleInTheElevator;
    }

    public boolean isDoorIsOpen() {
        return doorIsOpen;
    }

    public void setDoorIsOpen(boolean doorIsOpen) {
        this.doorIsOpen = doorIsOpen;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    public void setLastErrorMessage(String lastErrorMessage) {
        this.lastErrorMessage = lastErrorMessage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<FloorState> getFloorStates() {
        return floorStates;
    }

    public void setFloorStates(List<FloorState> floorStates) {
        this.floorStates = floorStates;
    }
}
