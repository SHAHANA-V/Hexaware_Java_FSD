package com.helpdesk.Service;

import com.helpdesk.Enum.Role;
import com.helpdesk.Repository.ExecutiveRepository;
import com.helpdesk.Repository.UserRepository;
import com.helpdesk.exception.ResourceNotFoundException;
import com.helpdesk.model.Executive;
import com.helpdesk.model.Manager;
import com.helpdesk.model.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExecutiveService {

    private final ExecutiveRepository executiveRepository;
    private final UserRepository userRepository;

    public ExecutiveService(ExecutiveRepository executiveRepository, UserRepository userRepository) {
        this.executiveRepository = executiveRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void insert(int managerId, Executive executive, String username, String password) {

        //step 1:Fetch Manager object from DB using managerId : validate managerId

        Optional<Manager> optional = executiveRepository.getManagerById(managerId);
        if(optional.isEmpty())
            throw new ResourceNotFoundException("Invalid Manager Id...");

        Manager manager = optional.get();

        //step 2:Prepare User object and insert it in db

        User user = new User(username,password, Role.EXECUTIVE);
        userRepository.insert(user);

        //step 2.5: Fetch entire user object by its username

        List<User> list = userRepository.getUserByUsername(username);
        user = list.getFirst();

        //step 3:attach user and manager object to the executive

        executive.setManager(manager);
        executive.setUser(user);

        //step 4:pass executive to executiveRepository
        executiveRepository.insert(executive);

    }
}
