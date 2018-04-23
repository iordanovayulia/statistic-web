package testApp.service;

import testApp.model.Details;
import testApp.model.File;

import java.util.List;
import java.util.Set;

public interface StatisticService {

    List<File> getFilesList();
    Set<Details> getFileDetails(Long fileId);
    File getFile(Long fileId);

}
