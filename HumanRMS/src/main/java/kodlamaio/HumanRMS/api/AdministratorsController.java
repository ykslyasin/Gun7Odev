package kodlamaio.HumanRMS.api;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.HumanRMS.entities.concrete.Administrators;
import kodlamaio.HumanRMS.business.abstracts.AdministratorsService;
import kodlamaio.HumanRMS.core.utilities.results.DataResult;
import kodlamaio.HumanRMS.core.utilities.results.Result;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/administrators")
public class AdministratorsController {
	
	private AdministratorsService administratorsService;

	public AdministratorsController(AdministratorsService administratorsService) {
		super();
		this.administratorsService = administratorsService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Administrators>> getAll(){
		return this.administratorsService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Administrators administrators) {
		return this.administratorsService.add(administrators);
	}
}
