package telran.ashkelon2020.person.dao;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import telran.ashkelon2020.person.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	@Query("select p from ChildOfLove p where p.name=?1")
	Stream<Person> findByName(String name);
	
	//Stream<Person> findByName(String name);

	Stream<Person> findByBirthDateBetween(LocalDate from, LocalDate to);
	
	@Query("select p from ChildOfLove p where p.address.city=:city")
	Stream<Person> findByAddressCity(@Param("city") String city);
	
	//Stream<Person> findByAddressCity(String city);

}
