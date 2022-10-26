package com.anmv.backend;

import com.anmv.entity.Group;
import com.anmv.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GroupRepository {
    private HibernateUtils hibernateUtils;

    public GroupRepository() {
        this.hibernateUtils = HibernateUtils.getInstance();
    }

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
}
