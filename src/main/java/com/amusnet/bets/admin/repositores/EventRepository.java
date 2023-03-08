package com.amusnet.bets.admin.repositores;

import com.amusnet.bets.admin.model.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Activity, String>, CrudRepository<Activity, String> {
}
