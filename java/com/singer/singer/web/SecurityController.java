package com.singer.singer.web;

import com.singer.singer.util.Message;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.logging.Logger;

@Controller
@RequestMapping("/security")
public class SecurityController {

    private final Logger logger = (Logger) LoggerFactory.getLogger(SecurityController.class);
    private MessageSource messageSource;

    @RequestMapping("/loginFail")
    public String loginFail(Model uiModel, Locale locale) {
        logger.info("Login fail detected.");
        uiModel.addAttribute("message", new Message("error", messageSource.getMessage(
                "message_login_fail", new Object[]{}, locale
        )));
        return "singers/list";
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}