package com.maryafolabi.facebookclone.service.serviceimplementation;


import com.maryafolabi.facebookclone.dto.ResponseDTO;
import com.maryafolabi.facebookclone.model.User;
import com.maryafolabi.facebookclone.repository.UserRepository;
import com.maryafolabi.facebookclone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImplementation  implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public String saveUser(User user) {
        String message = null;
        System.err.println("hgjfkkdk");
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        try {
            if(optionalUser.isPresent()) {
                throw new Exception("Email already taken");
            }
            userRepository.save(user);
        }catch(Exception e) {
          message = e.getMessage();
    }
        return message;
}

    @Override
    public ResponseDTO login(String email, String password) {

        ResponseDTO responseDTO = new ResponseDTO();
        Optional<User> optionalUser =  userRepository.findByEmailAndPassword(email, password);

       try {
            if (optionalUser.isEmpty()) {
                throw new Exception("Invalid email or password");
            }
            responseDTO.setUser(optionalUser.get());

       }catch(Exception e) {
           responseDTO.setMessage(e.getMessage());
        }

       return responseDTO;
    }


}
