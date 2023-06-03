package tn.narc.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.narc.dao.MakeYearDaoSpringData;
import tn.narc.entity.CarModel;
import tn.narc.entity.MakeYear;

@Service
@Transactional
public class MakeYearService {

	@Autowired
	private MakeYearDaoSpringData makeYearDaoSpringData;

	private String id;

	public MakeYear createMakeYear(MakeYear makeYear) {
		return makeYearDaoSpringData.save(makeYear);
	}

	public List<MakeYear> getAllMakeYear() {

		return this.makeYearDaoSpringData.findAll();
	}

	public List<CarModel> findCarModelsByMakeYear(Integer yearMake) {

		List<MakeYear> makeYear = makeYearDaoSpringData.findByYearMake(yearMake);
		MakeYear my = new MakeYear();
		int count = 0;

		while (makeYear.size() > count) {
			my = makeYear.get(count);
			count++;
			if (my.getYearMake().toString().equals(yearMake.toString())) {
				this.id = my.getId().toString();
				count = makeYear.size();
			}
		}

		Optional<MakeYear> makeYearOptional = makeYearDaoSpringData.findById(id);
		List<CarModel> cm = makeYearOptional.get().getCarModels();
		
		
		return cm;
	}

}
