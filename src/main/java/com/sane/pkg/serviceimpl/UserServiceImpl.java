package com.sane.pkg.serviceimpl;

import com.sane.pkg.beans.User;
import com.sane.pkg.dao.intiface.UserDao;
import com.sane.pkg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public int addUser(User user) {
         return userDao.addUser(user);
    }
}
