package org.lib.calorieservice.repository;

import org.lib.calorieservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
