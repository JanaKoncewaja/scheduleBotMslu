package com.schedule.service;

import com.schedule.dao.Schedule;
import com.schedule.dto.ScheduleDto;
import com.schedule.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleService {

    ScheduleDto scheduleDto;

    @Autowired
    ScheduleRepository scheduleRepository;

    public String getRequiredScheduleEntityPath(ScheduleDto scheduleDto){
        return scheduleRepository
                .findByYearOfStudyAndGroupNumberAndFirstDayOfRequestedWeekAndLastDayOfRequestedWeek
                        (scheduleDto.getYearOfStudy(),scheduleDto.getGroupNumber(),
                                scheduleDto.getFirstDayOfRequestedWeek(),
                                scheduleDto.getLastDayOfRequestedWeek()).getPdfPath();
    }

    public String processUserData(List<String> splitRequestStrings) {
        scheduleDto = new ScheduleDto(Integer.parseInt(splitRequestStrings.get(0))
                ,Integer.parseInt(splitRequestStrings.get(1))
                ,LocalDate.parse(splitRequestStrings.get(2))
                , LocalDate.parse(splitRequestStrings.get(3)));
        return getRequiredScheduleEntityPath(scheduleDto);
    }


    static Schedule fromDto(ScheduleDto scheduleDto){
        return new Schedule(scheduleDto.getYearOfStudy()
                ,scheduleDto.getGroupNumber()
                ,scheduleDto.getFirstDayOfRequestedWeek()
                , scheduleDto.getLastDayOfRequestedWeek());
    }

    static ScheduleDto fromSchedule(Schedule schedule){
        return new ScheduleDto(schedule.getYearOfStudy()
                ,schedule.getGroupNumber()
                ,schedule.getFirstDayOfRequestedWeek()
                ,schedule.getLastDayOfRequestedWeek());

    }

}
