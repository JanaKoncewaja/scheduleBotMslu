package com.schedule.dto;


import java.time.LocalDate;
import java.util.Objects;

public class ScheduleDto {

    private Long id;
    private Integer yearOfStudy;
    private Integer groupNumber;
    private LocalDate firstDayOfRequestedWeek;
    private LocalDate lastDayOfRequestedWeek;

    public ScheduleDto() {
    }

    public ScheduleDto(Integer yearOfStudy, Integer groupNumber, LocalDate firstDayOfRequestedWeek, LocalDate lastDayOfRequestedWeek) {
        this.yearOfStudy = yearOfStudy;
        this.groupNumber = groupNumber;
        this.firstDayOfRequestedWeek = firstDayOfRequestedWeek;
        this.lastDayOfRequestedWeek = lastDayOfRequestedWeek;
    }

    public ScheduleDto(Long id, Integer yearOfStudy, Integer groupNumber, LocalDate firstDayOfRequestedWeek, LocalDate lastDayOfRequestedWeek) {
        this.yearOfStudy = yearOfStudy;
        this.groupNumber = groupNumber;
        this.firstDayOfRequestedWeek = firstDayOfRequestedWeek;
        this.lastDayOfRequestedWeek = lastDayOfRequestedWeek;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleDto that = (ScheduleDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(yearOfStudy, that.yearOfStudy) &&
                Objects.equals(groupNumber, that.groupNumber) &&
                Objects.equals(firstDayOfRequestedWeek, that.firstDayOfRequestedWeek) &&
                Objects.equals(lastDayOfRequestedWeek, that.lastDayOfRequestedWeek);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, yearOfStudy, groupNumber, firstDayOfRequestedWeek, lastDayOfRequestedWeek);
    }

    @Override
    public String toString() {
        return
                "yearOfStudy=" + yearOfStudy +
                ", groupNumber=" + groupNumber +
                ", firstDayOfRequestedWeek=" + firstDayOfRequestedWeek +
                ", lastDayOfRequestedWeek=" + lastDayOfRequestedWeek +
                '}';
    }
}
