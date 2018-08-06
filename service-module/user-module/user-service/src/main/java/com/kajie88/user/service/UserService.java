package com.kajie88.user.service;

import com.kajie88.user.domain.UserDomain;

import java.util.List;

public interface UserService {
    List<UserDomain> getUserList(UserDomain domain);
}
