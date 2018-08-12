package org.zzu.persistence;

import org.springframework.data.repository.CrudRepository;
import org.zzu.domain.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long>{

}
