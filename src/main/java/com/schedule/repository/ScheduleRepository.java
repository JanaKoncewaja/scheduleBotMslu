package com.schedule.repository;

import com.schedule.dao.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    Schedule findByYearOfStudyAndGroupNumberAndFirstDayOfRequestedWeekAndLastDayOfRequestedWeek
            (Integer yearOfStudy, Integer groupNumber, LocalDate firstDayOfRequestedWeek, LocalDate lastDayOfRequestedWeek);
}
