package com.schedule.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Schedule {

    @Id
    private Long id;

    @NotNull
    private Integer yearOfStudy;

    @NotNull
    private Integer groupNumber;

    @NotNull
    private LocalDate firstDayOfRequestedWeek;

    @NotNull
    private LocalDate lastDayOfRequestedWeek;

    @NotNull
    private String pdfPath;


    public Schedule() {
    }

    public Schedule(@NotNull Integer yearOfStudy, @NotNull Integer groupNumber, @NotNull LocalDate firstDayOfRequestedWeek, @NotNull LocalDate lastDayOfRequestedWeek) {
        this.yearOfStudy = yearOfStudy;
        this.groupNumber = groupNumber;
        this.firstDayOfRequestedWeek = firstDayOfRequestedWeek;
        this.lastDayOfRequestedWeek = lastDayOfRequestedWeek;
    }

    public Schedule(Long id, Integer yearOfStudy, Integer groupNumber, LocalDate firstDayOfRequestedWeek, LocalDate lastDayOfRequestedWeek, String pdfPath) {
        this.id = id;
        this.yearOfStudy = yearOfStudy;
        this.groupNumber = groupNumber;
        this.firstDayOfRequestedWeek = firstDayOfRequestedWeek;
        this.lastDayOfRequestedWeek = lastDayOfRequestedWeek;
        this.pdfPath=pdfPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public LocalDate getFirstDayOfRequestedWeek() {
        return firstDayOfRequestedWeek;
    }

    public void setFirstDayOfRequestedWeek(LocalDate firstDayOfRequestedWeek) {
        this.firstDayOfRequestedWeek = firstDayOfRequestedWeek;
    }

    public LocalDate getLastDayOfRequestedWeek() {
        return lastDayOfRequestedWeek;
    }

    public void setLastDayOfRequestedWeek(LocalDate lastDayOfRequestedWeek) {
        this.lastDayOfRequestedWeek = lastDayOfRequestedWeek;
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(id, schedule.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
