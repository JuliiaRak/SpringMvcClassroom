package com.api.classroom.repos;

import com.api.classroom.domain.Message;
import com.api.classroom.domain.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QueryRepo extends CrudRepository<Query, Long> {

    List<Query> findByAdmin(String tag);

}
