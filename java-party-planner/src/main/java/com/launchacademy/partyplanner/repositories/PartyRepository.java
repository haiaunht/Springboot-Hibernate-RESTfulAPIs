package com.launchacademy.partyplanner.repositories;

import com.launchacademy.partyplanner.models.Party;
import javax.annotation.PreDestroy;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PartyRepository extends CrudRepository<Party, Integer> {
  @Query("SELECT p FROM Party p WHERE p.partyName = :partyName")
  public Party findByName(@Param("partyName") String partyName);

  @Modifying
  @Transactional
  @Query("DELETE FROM Party p WHERE p.id = :id")
  public void delete(@Param("id") Integer id);
}
