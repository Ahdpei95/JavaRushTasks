package com.javarush.task.task36.task3608.model;


import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<com.javarush.task.task36.task3608.bean.User> users = new ArrayList<>();
        com.javarush.task.task36.task3608.bean.User user1 = new com.javarush.task.task36.task3608.bean.User("A", 1, 1);
        com.javarush.task.task36.task3608.bean.User user2 = new com.javarush.task.task36.task3608.bean.User("B", 2, 1);
        users.add(user1);
        users.add(user2);
        modelData.setUsers(users);
    }

    @Override
    public void loadDeletedUsers() {
        //List<User> users = userService.getAllDeletedUsers();
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }
}
