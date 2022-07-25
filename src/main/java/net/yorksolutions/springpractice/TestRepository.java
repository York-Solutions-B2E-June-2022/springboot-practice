package net.yorksolutions.springpractice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository  extends CrudRepository<Test, Long> {
}
