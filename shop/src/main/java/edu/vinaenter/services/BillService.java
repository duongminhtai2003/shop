package edu.vinaenter.services;

import java.util.List;

import edu.vinaenter.dto.BillDto;

public interface BillService {
	List<BillDto> findAllPagination(int offset);
	int countPagination();
	int delete(Integer id);
	BillDto getItem(Integer id);
	int edit(BillDto billDto);
}
