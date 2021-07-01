package com.launchacademy.donutTracker.repositories;

import com.launchacademy.donutTracker.models.Donut;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonutRepository extends PagingAndSortingRepository<Donut, Integer> {
  public List<Donut> findByOrderByType(Pageable pageable);
}
