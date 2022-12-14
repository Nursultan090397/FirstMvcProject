package peaksoft.service;

import peaksoft.model.Course;
import peaksoft.model.Group;

import java.util.List;

public interface GroupService {

    List<Group> getAllGroup();

    void addGroup(Long id, Group group);

    Group getGroupById(Long id);

    void updateGroup(Group group, Long id);

    void removeGroup(Long id);
}