package telran.ashkelon2020.person.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import telran.ashkelon2020.person.model.Address;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonDto {
	Integer id;
	String name;
	LocalDate birthDate;
	Address address;

}
