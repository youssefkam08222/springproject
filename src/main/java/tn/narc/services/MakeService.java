package tn.narc.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.narc.dao.MakeDaoSpringData;
import tn.narc.entity.CarModel;
import tn.narc.entity.Make;
import tn.narc.entity.MakeYear;

@Service
@Transactional
public class MakeService {

	@Autowired
	private MakeDaoSpringData makeDaoSpringData;

	public Make createMake(Make make) {
		return makeDaoSpringData.save(make);
	}

	public List<String> getAllMake() {

		List<Make> make = makeDaoSpringData.findAll();
		List<String> MakeNameList = new ArrayList<>();
		for (Make m : make) {
			MakeNameList.add(m.getMakeName());
		}
		return MakeNameList;
	}

	public List<String> findMakeYearsByMakeName(String makeName) {

		List<MakeYear> makeyear = getMakeYearListByMakeName(makeName);

		List<String> MakeYearList = new ArrayList<>();
		for (MakeYear my : makeyear) {
			MakeYearList.add(my.getYearMake().toString());
		}

		return MakeYearList;
	}

	public List<String> findCarModelByMakeNameAndMakeYear(String makeName, String makeYear) {

		List<MakeYear> makeyear = getMakeYearListByMakeName(makeName);

		List<CarModel> carModel = null;

		MakeYear my = new MakeYear();
		int count = 0;
		while (makeyear.size() > count) {
			my = makeyear.get(count);
			count++;
			if (my.getYearMake().toString().equals(makeYear.toString())) {
				carModel = my.getCarModels();
				break;
			}
		}
		List<String> carModelNameList = new ArrayList<>();
		for (CarModel cm : carModel) {
			carModelNameList.add(cm.getCarModelName());
		}

		return carModelNameList;
	}

	private List<MakeYear> getMakeYearListByMakeName(String makeName) {
		List<Make> make = makeDaoSpringData.findByMakeName(makeName);
		Make v = new Make();
		v = make.get(0);
		List<MakeYear> makeyear = v.getMakeYears();
		return makeyear;
	}

	/*
	 * public List<Make> getAllMake() {
	 * 
	 * List<Make> make = makeDaoSpringData.findAll();
	 * 
	 * List<String> s = new ArrayList<>();
	 * 
	 * for (Make m : make) {
	 * 
	 * s.add(m.getMakeName()); }
	 * 
	 * return this.makeDaoSpringData.findAll(); }
	 */

}
