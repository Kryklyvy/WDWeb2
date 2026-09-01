package com.example.demo;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final JavaMailSender mailSender;

    public UserController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    // ==============================
    // DISPLAY INDEX PAGE
    // ==============================

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("userData", new UserData());

        return "index";
    }


    // ==============================
    // WEDDING RSVP
    // ==============================

    @PostMapping("/submit-form")
    public String submitForm(UserData userData) {

        System.out.println("================================");
        System.out.println("       NEW WEDDING RSVP");
        System.out.println("================================");

        System.out.println("Attending: "
                + (userData.isAttending() ? "YES" : "NO"));


        System.out.println("Attendees:");

        if (userData.getAttendees() != null) {

            for (String attendee : userData.getAttendees()) {

                System.out.println("- " + attendee);

            }
        }


        // Create RSVP email

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("@gmail.com");

        message.setSubject("New Wedding RSVP");


        StringBuilder email = new StringBuilder();

        email.append("NEW WEDDING RSVP\n\n");

        email.append("Attending: ");

        email.append(
                userData.isAttending()
                        ? "YES"
                        : "NO"
        );

        email.append("\n\n");


        email.append("Attendees:\n");


        if (userData.getAttendees() != null) {

            for (int i = 0;
                 i < userData.getAttendees().size();
                 i++) {

                email.append(i + 1)
                     .append(". ")
                     .append(userData.getAttendees().get(i))
                     .append("\n");
            }
        }


        message.setText(email.toString());


        // Send RSVP email

        mailSender.send(message);


        System.out.println("RSVP email sent successfully!");

        return "redirect:/?rsvpSent=true";
    }


    // ==============================
    // LOVE MESSAGE
    // ==============================

    @PostMapping("/send-love-message")
    public String sendLoveMessage(UserData userData) {

        System.out.println("================================");
        System.out.println("       NEW LOVE MESSAGE");
        System.out.println("================================");

        System.out.println("From: "
                + userData.getMessageName());

        System.out.println("Message: "
                + userData.getLoveMessage());


        // Create love message email

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("@gmail.com");

        message.setSubject("New Wedding Love Message");


        String emailText =
                "NEW LOVE MESSAGE\n\n" +

                "From: "
                + userData.getMessageName()
                + "\n\n" +

                "Message:\n"
                + userData.getLoveMessage();


        message.setText(emailText);


        // Send email

        mailSender.send(message);


        System.out.println("Love message email sent successfully!");


        return "redirect:/?messageSent=true";
    }

}