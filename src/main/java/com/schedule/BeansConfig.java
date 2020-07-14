package com.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Configuration
public class BeansConfig {

    @Bean
    public SendMessage sendMessage(){
        return new SendMessage();
    }

    @Bean
    public SendDocument sendDocument(){ return new SendDocument();}

}
