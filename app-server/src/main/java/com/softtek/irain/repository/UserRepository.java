package com.softtek.irain.repository;

import com.softtek.irain.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kaishen on 06/09/2018.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
