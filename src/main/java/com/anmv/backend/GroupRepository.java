package com.anmv.backend;

import com.anmv.entity.Group;
import com.anmv.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class GroupRepository {
    private HibernateUtils hibernateUtils;

    public GroupRepository() {
        this.hibernateUtils = HibernateUtils.getInstance();
    }

    // Phương thức tạo 1 Group mới
    public void createGroup(Group group){
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            session.save(group);
            System.out.println("Thêm mới Group thành công");
        } catch (Exception e){
            System.out.println("Thêm mới thất bại :" + e.getMessage());
        } finally {
            if(session != null){
                session.close();
            }
        }
    }

    // Phương thức lấy tất cả Group
    public List<Group> getListGroup(){
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            Query<Group> listGroups = session.createQuery("from Group");

            return listGroups.list();
        } finally {
            if(session != null){
                session.close();
            }
        }
    }

    // Phương thức lấy 1 Group dựa vào ID
    public Group getGroupById(short id){
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            Group group = session.get(Group.class, id);

            return group;
        } finally {
            if(session != null){
                session.close();
            }
        }
    }

    // Phương thức lấy 1 Group dựa vào name:
    public List<Group> getGroupByName(String name){
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            Query<Group> query = session.createQuery("FROM Group WHERE groupName = :nameParameter");

            query.setParameter("nameParameter", name);

            return query.list();
        } finally {
            if(session != null){
                session.close();
            }
        }
    }

    // Phương thức dùng để update Groups:
    public void updateGroup(short id, String newName){
        Session session = null;
        try{
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Group group = session.load(Group.class, id);

            group.setGroupName(newName);

            session.getTransaction().commit();
        } finally {
            if(session != null){
                session.close();
            }
        }
    }

    // Phương thức dùng để delete Groups theo ID:
    public void deleteGroup(short id){
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Group group = session.load(Group.class, id);
            session.beginTransaction();
            session.delete(group);
            session.getTransaction().commit();

        } finally {
            if(session != null){
                session.close();
            }
        }
    }

    // Phương thức check Group đã tồn tại hay chưa theo ID:
    public boolean isGroupExistsById(short id){
        Group group = getGroupById(id);
        if(group == null){
            return false;
        }
        return true;
    }

    // Phương thức check Group đã tồn tại hay chưa theo Name:
    public boolean isGroupExistsByName(String name){
        List<Group> group = getGroupByName(name);
        if(group.size() > 0){
            return true;
        }
        return false;
    }
}
