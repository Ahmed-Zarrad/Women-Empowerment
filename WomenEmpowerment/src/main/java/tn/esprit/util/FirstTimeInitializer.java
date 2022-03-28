package tn.esprit.util;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tn.esprit.Entity.AppUser;
import tn.esprit.Entity.Gender;
import tn.esprit.Entity.Role;
import tn.esprit.Service.UserServiceImpl;


@Component
public class FirstTimeInitializer implements CommandLineRunner {

    private final Log logger = LogFactory.getLog(FirstTimeInitializer.class);

    @Autowired
    private UserServiceImpl userService;

    @Override
    public void run(String... strings) throws Exception {

        if (userService.retrieveAllUsers().isEmpty()) {
            logger.info("No Users accounts found. Creating some users");

            AppUser appUser = new AppUser(Role.ADMINISTRATOR,"Ahmed","Zarrad","ahmed123",
                    "ahmed123",true,95382514,"ariena",
                    "Ahmed", Gender.Male,true,0,false,
                    true);
            userService.save(appUser);
        }
    }
}
