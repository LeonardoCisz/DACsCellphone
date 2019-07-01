package br.univille.cellphone2019.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.cellphone2019.model.Cellphone;

@Service
public interface CellphoneService {
	
	List<Cellphone> getAll();
	void save (Cellphone cellphone);
	void remove (Cellphone cellphone);
	Cellphone findById(Long id);
	Cellphone findById(long id);

}
