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
import rva.jpa.Radnik;
import rva.jpa.Sektor;
import rva.repository.RadnikRepository;
import rva.repository.SektorRepository;

@CrossOrigin
@RestController
@Api(tags = {"Radnik CRUD operacije"})
public class RadnikRestController {
	
	@Autowired
	private RadnikRepository radnikRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SektorRepository sektorRepository; 

	@GetMapping("radnik")
	@ApiOperation(value = "Vraca kolekciju svih radnika iz baze podataka")
	public Collection<Radnik> getRadnici() {
		return radnikRepository.findAll();
	}
	
	@GetMapping("radnik/{id}")
	@ApiOperation(value = "Vraca radnika u odnosu na prosledjenu vrednost path varijable id")
	public Radnik getRadnik(@PathVariable("id") Integer id) {
		
		return radnikRepository.getOne(id);
	}
	
	@GetMapping("radniciUSektoruID/{id}")
	@ApiOperation(value = "Vraca kolekciju svih radnika koji rade u sektoru sa id-jem prosledjenim u path varijabli")
	public Collection<Radnik> getRadniciUSektoruID(@PathVariable("id") Integer id) {
		
		Sektor s = sektorRepository.getOne(id);
		return radnikRepository.findBySektor(s);
	}
	
	@GetMapping("radnikIme/{ime}")
	@ApiOperation(value = "Vraca kolekciju svih radnika cije ime sadrzi prosledjenu vrednost u okviru path varijable")
	public Collection<Radnik> getRadnikByIme(@PathVariable("ime") String ime) {
		return radnikRepository.findByImeContainingIgnoreCase(ime);
	}
	
	@PostMapping("radnik")
	@ApiOperation(value = "Dodaje novog radnika u bazu podataka")
	public ResponseEntity<Radnik> insertRadnik(@RequestBody Radnik radnik) {
		if(!radnikRepository.existsById(radnik.getId()))
		{
			radnikRepository.save(radnik);
			return new ResponseEntity<Radnik>(HttpStatus.OK);
		}
		return new ResponseEntity<Radnik>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("radnik")
	@ApiOperation(value = "Update-uje postojece podatke radnika")
	public ResponseEntity<Radnik> updateRadnik(@RequestBody Radnik radnik) {
		if(!radnikRepository.existsById(radnik.getId()))
		{
			return new ResponseEntity<Radnik>(HttpStatus.CONFLICT);
		}
		radnikRepository.save(radnik);
		return new ResponseEntity<Radnik>(HttpStatus.OK);
	}
	
	@DeleteMapping("radnik/{id}")
	@ApiOperation(value = "Brise radnika u odnosu na vrednost prosledjenu u path varijabli")
	public ResponseEntity<Radnik> deleteRandik(@PathVariable Integer id) {
		if(!radnikRepository.existsById(id))
		{
			return new ResponseEntity<Radnik>(HttpStatus.NO_CONTENT);
		}
		radnikRepository.deleteById(id);
		
		if(id == -100)
		{
			jdbcTemplate.execute(" INSERT INTO \"radnik\" (\"id\", \"ime\", \"prezime\", \"broj_lk\", \"obrazovanje\", \"sektor\") "
					+ "VALUES (-100, 'Testime ', 'Testprezime', 11000000, 4, 9)");
		}
		
		return new ResponseEntity<Radnik>(HttpStatus.OK);
	}
}
