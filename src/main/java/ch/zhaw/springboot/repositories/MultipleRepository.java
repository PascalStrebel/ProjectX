package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Multiple;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultipleRepository extends JpaRepository<Multiple, Long> {

}
