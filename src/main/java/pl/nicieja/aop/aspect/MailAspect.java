package pl.nicieja.aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.nicieja.aop.service.MailSenderService;

import javax.mail.MessagingException;
import java.util.Arrays;

@Aspect
@Component
public class MailAspect {

    private MailSenderService mailSenderService;

    @Autowired
    public MailAspect(MailSenderService mailSenderService) {
        this.mailSenderService = mailSenderService;
    }

    @After("@annotation(MailingAspect)")
    public void sendEmailAfterAddingVideo(JoinPoint joinPoint) throws MessagingException {
        this.mailSenderService.sendMail("mail@gmail.com", "added new video", "added new video: " + Arrays.stream(joinPoint.getArgs()).findFirst().get().toString());
    }
}
