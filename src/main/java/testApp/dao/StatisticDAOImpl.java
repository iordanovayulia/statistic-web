package testApp.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testApp.model.Details;
import testApp.model.Content;
import testApp.model.File;
import org.hibernate.query.Query;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Repository
public class StatisticDAOImpl implements StatisticDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<File> getFilesList() {
        System.out.println("---------IN GET_FILE_LIST---------");
        Query query = sessionFactory.getCurrentSession().createQuery("FROM File");
        return (List<File>)query.list();
    }


    @Override
    public Set<Details> getFileDetails(Long fileId) {
        System.out.println("---------IN GET_DETAILS---------\nFILE ID: "+ fileId);
        File file = getFile(fileId);
        System.out.println("FILE: " + file);
        Set<Content> contentSet = file.getContentSet();
        System.out.println("CONTENT SET : " + contentSet);
        Set<Details> details = new LinkedHashSet<>();
        for(Content content : contentSet){
            details.add(content.getDetails());
        }
        System.out.println("DETAILS: " + details);
        return details;
    }

    @Override
    public File getFile(Long fileId) {
        System.out.println("---------IN GET_FILE---------\nFILE ID: "+ fileId);
        Query query = sessionFactory.getCurrentSession().createQuery("FROM File WHERE fileId = :id");
        query.setParameter("id", fileId);
        return (File) query.getSingleResult();
    }


}
