package kodlamaio.HumanRMS.business.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HumanRMS.business.abstracts.PositionsService;
import kodlamaio.HumanRMS.core.utilities.results.DataResult;
import kodlamaio.HumanRMS.core.utilities.results.Result;
import kodlamaio.HumanRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HumanRMS.core.utilities.results.SuccessResult;
import kodlamaio.HumanRMS.dataAccess.abstracts.PositionsDao;
import kodlamaio.HumanRMS.entities.concrete.Positions;

@Service
public class PositionsManager implements PositionsService{
	
	private PositionsDao positionsDao;

	@Autowired
	public PositionsManager(PositionsDao positionsDao) {
		super();
		this.positionsDao = positionsDao;
	}

	@Override
	public DataResult<List<Positions>> getAll() {
		return new SuccessDataResult<List<Positions>>
		(this.positionsDao.findAll() , "Data listelendi");
	}

	@Override
	public Result add(Positions positions) {
		this.positionsDao.save(positions);
		return new SuccessResult("Ürün eklendi");
	}

}
