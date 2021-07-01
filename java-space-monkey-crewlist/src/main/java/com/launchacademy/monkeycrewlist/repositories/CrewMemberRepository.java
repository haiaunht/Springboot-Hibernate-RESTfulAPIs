package com.launchacademy.monkeycrewlist.repositories;

import com.launchacademy.monkeycrewlist.models.CrewMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewMemberRepository extends CrudRepository<CrewMember, Integer> {

}
