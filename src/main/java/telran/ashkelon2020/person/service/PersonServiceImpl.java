package telran.ashkelon2020.person.service;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.ashkelon2020.person.dao.PersonRepository;
import telran.ashkelon2020.person.dto.PersonDto;
import telran.ashkelon2020.person.dto.PersonNotFoundException;
import telran.ashkelon2020.person.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public boolean addPerson(PersonDto personDto) {
		Person person = modelMapper.map(personDto, Person.class);
		if (person == null) {
			personRepository.save(person);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public PersonDto findPersonById(Integer id) {
		Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException());
		return modelMapper.map(person, PersonDto.class);
	}

	@Override
	public PersonDto editPerson(Integer id, String name) {
		Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException());
		person.setName(name);
		personRepository.save(person);
		return modelMapper.map(person, PersonDto.class);
	}

	@Override
	public PersonDto removePerson(Integer id) {
		Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException());
		personRepository.deleteById(id);
		return modelMapper.map(person, PersonDto.class);
	}

	@Override
	public Iterable<PersonDto> findPersonsByName(String name) {
		return personRepository.findByName(name)
				.stream()
				.map(p -> modelMapper.map(p, PersonDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public Iterable<PersonDto> findPersonsByAges(int min, int max) {
		LocalDate from = LocalDate.now().minusYears(max);
		LocalDate to = LocalDate.now().minusYears(min);
		return personRepository.findByBirthDateBetween(from, to).stream()
				.map(p -> modelMapper.map(p, PersonDto.class))
				.collect(Collectors.toList());
	}

}
