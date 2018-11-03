package org.zzu.persistence;

import org.springframework.data.repository.CrudRepository;
import org.zzu.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String>{
}
