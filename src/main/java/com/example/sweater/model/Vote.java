package com.example.sweater.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "votes")
public class Vote extends AbstractBaseEntity {

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NotNull
    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "time", nullable = false)
    private LocalTime time;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    public Vote() {
    }

    public Vote(Integer id, LocalDateTime dateTime, User user, Restaurant restaurant) {
        super(id);
        this.date = dateTime.toLocalDate();
        this.time = dateTime.toLocalTime();
        this.user = user;
        this.restaurant = restaurant;
    }

    public Vote(LocalDateTime dateTime, User user, Restaurant restaurant) {

        this.date = dateTime.toLocalDate();
        this.time = dateTime.toLocalTime();
        this.user = user;
        this.restaurant = restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}


