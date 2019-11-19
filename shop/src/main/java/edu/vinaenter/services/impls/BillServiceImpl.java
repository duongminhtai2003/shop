package edu.vinaenter.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.daos.BillDao;
import edu.vinaenter.dto.BillDto;
import edu.vinaenter.services.BillService;

@Service
public class BillServiceImpl implements BillService {
	@Autowired
	private BillDao billdao;
	

	public List<BillDto> findAllPagination(int offset) {
		return billdao.findUserByOffset(offset);
	}


	public int countPagination() {
		return billdao.countUser();
	}


	public int delete(Integer id) {
		return billdao.del(id);
	}


	public BillDto getItem(Integer id) {
		return billdao.getItem(id);
	}

	public int edit(BillDto billDto) {
		return billdao.edit(billDto);
	}

}
