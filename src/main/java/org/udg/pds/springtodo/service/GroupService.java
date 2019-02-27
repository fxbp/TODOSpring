package org.udg.pds.springtodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.udg.pds.springtodo.controller.exceptions.ServiceException;
import org.udg.pds.springtodo.entity.Group;
import org.udg.pds.springtodo.entity.IdObject;
import org.udg.pds.springtodo.entity.User;
import org.udg.pds.springtodo.repository.GroupRepository;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserService userService;

    @Transactional
    public IdObject addGroup(String name, Long userId, String description){

        try{
            User user = userService.getUser(userId);
            Group group = new Group(name,description);

            group.setUser(user);
            user.addGroup(group);

            groupRepository.save(group);
            return new IdObject(group.getId());

        }
        catch (Exception ex){
            throw new ServiceException(ex.getMessage());
        }
    }

}
