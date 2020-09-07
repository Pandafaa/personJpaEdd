package telran.ashkelon2020.person.service;

import telran.ashkelon2020.person.dto.PersonDto;

public interface PersonService {
	
	boolean addPerson(PersonDto personDto);
	
	PersonDto findPersonById(Integer id);
	
	PersonDto editPerson(Integer id, String name);
	
	PersonDto removePerson(Integer id);
	
	Iterable<PersonDto> findPersonsByName(String name);

	Iterable<PersonDto> findPersonsByAges(int min, int max);
	
	Iterable<PersonDto> findPersonsByCity(String city);

}
