package com.example.clinic.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * @apiNote SERVICE FOR RETURNING MSG TO CLIENTS
 * @since 25.11.2022
 */

@Component
@RequiredArgsConstructor
public class MessageService {
    private static MessageSource messageSource;
    @Autowired
    public void setSomeThing(MessageSource messageSource)
    {
        MessageService.messageSource = messageSource;
    }

    /**
     * IF KEY COMES, IT WILL GO BACK WITH MSG. <br/>
     * PLACE WHERE TO TAKE KEY <pre>/src/java/resources/messages</pre>
     */
    public static String getMessage(String key) {
        try
        {
            return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
        }
        catch (Exception e)
        {
            return key;
        }
    }
}
