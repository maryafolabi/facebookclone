package com.maryafolabi.facebookclone.service;


import com.maryafolabi.facebookclone.dto.ResponseDTO;
import com.maryafolabi.facebookclone.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String saveUser(User user);

    ResponseDTO login(String email, String password);

}
