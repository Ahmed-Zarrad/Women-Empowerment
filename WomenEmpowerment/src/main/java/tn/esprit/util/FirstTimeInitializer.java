package tn.esprit.util;

import tn.esprit.Entity.AppUser;
import tn.esprit.Service.UserServiceImpl;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class FirstTimeInitializer implements CommandLineRunner {

    private final Log logger = LogFactory.getLog(FirstTimeInitializer.class);

    @Autowired
    private UserServiceImpl userService;

    @Override
    public void run(String... strings) throws Exception {

        if (userService.retrieveAllUsers().isEmpty()) {
            logger.info("No Users accounts found. Creating some users");

            AppUser user = new AppUser("Ahmed","Zarrad",95382514, "ahmed@esprit.tn", "ahmed123","Male","ariena");
            userService.save(user);
        }
    }
}
