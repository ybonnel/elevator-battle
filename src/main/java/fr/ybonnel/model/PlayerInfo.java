package fr.ybonnel.model;

import java.io.Serializable;
import java.util.List;

public class PlayerInfo implements Serializable {

    private String id;
    private String pseudo;
    private String photo;
    private int score;
    private List<Integer> floors;
    private List<Integer> peopleInTheElevators;
    private List<Boolean> doorsAreOpen;
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

    public List<Integer> getFloors() {
        return floors;
    }

    public void setFloors(List<Integer> floors) {
        this.floors = floors;
    }

    public List<Integer> getPeopleInTheElevators() {
        return peopleInTheElevators;
    }

    public void setPeopleInTheElevators(List<Integer> peopleInTheElevators) {
        this.peopleInTheElevators = peopleInTheElevators;
    }

    public List<Boolean> getDoorsAreOpen() {
        return doorsAreOpen;
    }

    public void setDoorsAreOpen(List<Boolean> doorsAreOpen) {
        this.doorsAreOpen = doorsAreOpen;
    }

    public List<FloorState> getFloorStates() {
        return floorStates;
    }

    public void setFloorStates(List<FloorState> floorStates) {
        this.floorStates = floorStates;
    }
}
