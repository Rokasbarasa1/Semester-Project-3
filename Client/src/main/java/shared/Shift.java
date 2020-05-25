package shared;

import java.time.LocalDate;

public class Shift {

    private int id;
    private LocalDate date;
    private int user_id;
    private int manager_id;
    private String description;



    public Shift(int id, int user_id, String description, int manager_id, LocalDate date) {
        this.id = id;
        this.user_id = user_id;
        this.description = description;
        this.manager_id = manager_id;
        this.date = date;
    }

    public Shift(int user_id, String description, int manager_id, LocalDate date) {
        this.user_id = user_id;
        this.description = description;
        this.manager_id = manager_id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "id=" + id +
                ", date=" + date +
                ", user_id=" + user_id +
                ", manager_id=" + manager_id +
                ", description='" + description + '\'' +
                '}';
    }
}
