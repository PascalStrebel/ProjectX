package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.AbstractCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConditionRepository extends JpaRepository<AbstractCondition, Long> {

}
