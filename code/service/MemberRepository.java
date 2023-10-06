package service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MemberRepository extends CrudRepository<Member_info, Integer> {}
