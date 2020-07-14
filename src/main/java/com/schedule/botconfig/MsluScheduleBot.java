package com.schedule.botconfig;

import com.schedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Component
@PropertySource("classpath:telegram.properties")
public class MsluScheduleBot extends TelegramLongPollingBot {

    ScheduleService scheduleService;

    SendMessage sendMessage;
    SendDocument sendDocument;

    @Autowired
    public MsluScheduleBot(ScheduleService scheduleService,SendMessage sendMessage, SendDocument sendDocument) {
        this.scheduleService = scheduleService;
        this.sendMessage=sendMessage;
        this.sendDocument=sendDocument;
    }

    @Value("${bot.name}")
    private String botName;

    @Value("${bot.token}")
    private String botToken;

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = update.getMessage().getChatId();
        String inputText = update.getMessage().getText();
        if (inputText.startsWith("/start")){
            processingStartCommand(chatId);
        } else{
            try{
            processUserRequestData(update,chatId);
            }
            catch(Exception e){
                sendMessage("Упс! Произошла ошибка. Попробуйте еще раз",chatId);
            }
        }
    }

    private void processUserRequestData(Update update,Long chatId) {
        String usersRequestData =update.getMessage().getText();
        List<String> splitRequestStrings = Arrays.asList(usersRequestData.split(",*\\s|,"));
        sendDocument(scheduleService.processUserData(splitRequestStrings),chatId);
    }


    private void processingStartCommand(Long chatId) {

        sendMessage("Привет, студент МГЛУ! Здесь ты можешь узнать свое расписание. " +
                "Введи следующие данные: год учебы, номер группы, день начал недели," +
                " последний день недели(формат даты: 2020-04-12) ", chatId);

    }

    private void sendDocument(String pdfPath,Long chatId){
        File file = new File(pdfPath);
        sendDocument.setChatId(chatId);
        sendDocument.setDocument(file);
        try {
            execute(sendDocument);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    private void sendMessage(String responseMessage, Long chatId){
        sendMessage.setChatId(chatId);
        sendMessage.setText(responseMessage);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
