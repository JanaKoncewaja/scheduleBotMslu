package com.schedule.service;
import static org.junit.Assert.*;

import com.schedule.dto.ScheduleDto;
import com.schedule.repository.ScheduleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
class ScheduleServiceTest {

    @Autowired
    ScheduleService scheduleService;

    @MockBean
    ScheduleRepository scheduleRepository;

    ScheduleDto scheduleDto;

    @BeforeEach
    void setUp() {
        scheduleDto=new ScheduleDto(2020, 218,
                LocalDate.parse("2020-12-12"),LocalDate.parse("2020-12-17"));
    }

    @Test
    void processUserData() {
    }
}