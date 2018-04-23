package testApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testApp.model.Details;
import testApp.model.Content;
import testApp.model.File;
import testApp.dao.StatisticDAO;

import java.util.List;
import java.util.Set;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    StatisticDAO statisticDao;

    public StatisticServiceImpl(StatisticDAO statisticDao) {
        this.statisticDao = statisticDao;
    }

    public StatisticServiceImpl() {
    }

    @Transactional
    public StatisticDAO getStatisticDao() {
        return statisticDao;
    }

    @Transactional
    public void setStatisticDao(StatisticDAO statisticDao) {
        this.statisticDao = statisticDao;
    }

    @Transactional
    public List<File> getFilesList() {
        return statisticDao.getFilesList();
    }

    @Transactional
    public Set<Details> getFileDetails(Long fileId) {
        return statisticDao.getFileDetails(fileId);
    }

    @Transactional
    public File getFile(Long fileId) {

        return statisticDao.getFile(fileId);

    }



}
