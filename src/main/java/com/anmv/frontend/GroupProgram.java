package com.anmv.frontend;

import com.anmv.backend.GroupRepository;
import com.anmv.entity.Group;

import java.util.List;

public class GroupProgram {
    public static void main(String[] args) {
        GroupRepository groupRepository = new GroupRepository();
        List<Group> listGroups = groupRepository.getListGroup();
        for(Group g : listGroups){
            System.out.println(g);
        }
    }
}
