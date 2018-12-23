package telran.ashkelon2018.person.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import telran.ashkelon2018.person.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	List<Person> findByBirthDateBetween(LocalDate fromDate,
			LocalDate toDate);
	
	List<Person> findByAddressCity(String city);
	
	@Query("select p from Person p where p.salary between ?1 and ?2")
	List<Person> findBySalaryBetween(int minSalary, int maxSalary);
}
