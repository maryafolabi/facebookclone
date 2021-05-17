package com.maryafolabi.facebookclone.dto;


import com.maryafolabi.facebookclone.model.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseDTO {
    private User user;
    private String message;

}
