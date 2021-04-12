package rva.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import rva.jpa.Obrazovanje;
import rva.repository.ObrazovanjeRepository;

@CrossOrigin
@RestController
@Api(tags = {"Obrazovanje CRUD operacije"})
public class ObrazovanjeRestController {
	
	@Autowired
	private ObrazovanjeRepository obrazovanjeRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("obrazovanje")
	@ApiOperation(value = "Vraca kolekciju svih obrazovanja iz baze podataka")
	public Collection<Obrazovanje> getObrazovanja() {
		return obrazovanjeRepository.findAll();
	}
	
	@GetMapping("obrazovanje/{id}")
	@ApiOperation(value = "Vraca obrazovanje u odnosu na prosledjenu vrednost path varijable id")
	public Obrazovanje getObrazovanje(@PathVariable("id") Integer id) {
		
		return obrazovanjeRepository.getOne(id);
	}
	
	@GetMapping("obrazovanjeNaziv/{naziv}")
	@ApiOperation(value = "Vraca kolekciju svih obrazovanja ciji naziv sadrzi prosledjenu vrednost u okviru path varijable")
	public Collection<Obrazovanje> getObrazovanjeByNaziv(@PathVariable("naziv") String naziv) {
		return obrazovanjeRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@GetMapping("obrazovanjeStepenStrucneSpreme/{stepen_strucne_spreme}")
	@ApiOperation(value = "Vraca kolekciju svih obrazovanja cija oznaka sadrzi prosledjenu vrednost u okviru path varijable")
	public Collection<Obrazovanje> getObrazovanjeByStepenStrucneSpreme(@PathVariable("stepen_strucne_spreme") String stepenStrucneSpreme) {
		
		return obrazovanjeRepository.findByStepenStrucneSpremeContainingIgnoreCase(stepenStrucneSpreme);
	}
	
	@PostMapping("obrazovanje")
	@ApiOperation(value = "Dodaje novo obrazovanje u bazu podataka")
	public ResponseEntity<Obrazovanje> insertObrazovanje(@RequestBody Obrazovanje obrazovanje) {
		if(!obrazovanjeRepository.existsById(obrazovanje.getId()))
		{
			obrazovanjeRepository.save(obrazovanje);
			return new ResponseEntity<Obrazovanje>(HttpStatus.OK);
		}
		return new ResponseEntity<Obrazovanje>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("obrazovanje")
	@ApiOperation(value = "Update-uje postojece obrazovanje")
	public ResponseEntity<Obrazovanje> updateObrazovanje(@RequestBody Obrazovanje obrazovanje) {
		if(!obrazovanjeRepository.existsById(obrazovanje.getId()))
		{
			return new ResponseEntity<Obrazovanje>(HttpStatus.CONFLICT);
		}
		obrazovanjeRepository.save(obrazovanje);
		return new ResponseEntity<Obrazovanje>(HttpStatus.OK);
	}
	
	@DeleteMapping("obrazovanje/{id}")
	@ApiOperation(value = "Brise obrazovanje u odnosu na vrednost prosledjenu u path varijabli")
	public ResponseEntity<Obrazovanje> deleteObrazovanje(@PathVariable Integer id) {
		if(!obrazovanjeRepository.existsById(id))
		{
			return new ResponseEntity<Obrazovanje>(HttpStatus.NO_CONTENT);
		}
		obrazovanjeRepository.deleteById(id);
		
		if(id == -100)
		{
			jdbcTemplate.execute(" INSERT INTO \"obrazovanje\" (\"id\", \"naziv\", \"stepen_strucne_spreme\", \"opis\") "
					+ "VALUES (-100, 'Test obrazovanje', '4.', 'Test opis')");
		}
		
		return new ResponseEntity<Obrazovanje>(HttpStatus.OK);
	}
}
