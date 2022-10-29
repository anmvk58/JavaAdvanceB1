package com.anmv.frontend;

import com.anmv.backend.GroupRepository;
import com.anmv.entity.Group;

import java.util.Date;
import java.util.List;

public class GroupProgram {
    public static void main(String[] args) {
        GroupRepository groupRepository = new GroupRepository();

        // Create new group
//        System.out.println("Create a new Group");
//        Group group = new Group();
//        group.setGroupName("Test Group");
//        group.setCreateDate(new Date());
//        groupRepository.createGroup(group);

        // View all Group
        System.out.println("\nView all group in tables: ");
        List<Group> listGroups = groupRepository.getListGroup();
        for(Group g : listGroups){
            System.out.println(g);
        }

        // Get a Group by ID:
        System.out.println("\nGet Group by ID:");
        Group group1 = groupRepository.getGroupById((short) 3);
        System.out.println(group1);

        // Get a Group by Name
        System.out.println("\nGet Group by Name:");
        List<Group> listGroups2 = groupRepository.getGroupByName("VTI Sale 01");
        for(Group g : listGroups2){
            System.out.println(g);
        }

        // Update a Group:
        groupRepository.updateGroup((short) 11, "new Name");
    }
}
