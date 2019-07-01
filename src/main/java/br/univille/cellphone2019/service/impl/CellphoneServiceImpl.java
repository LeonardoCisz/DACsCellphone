package br.univille.cellphone2019.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.cellphone2019.model.Cellphone;
import br.univille.cellphone2019.repository.CellphoneRepository;
import br.univille.cellphone2019.service.CellphoneService;

@Service
public class CellphoneServiceImpl implements CellphoneService{

	@Autowired
	private CellphoneRepository cellphoneRepository;
	
	@Override
	public List<Cellphone> getAll() {
		
		return cellphoneRepository.findAll();
	}

	@Override
	public void save(Cellphone cellphone) {
		// TODO Auto-generated method stub
		cellphoneRepository.save(cellphone);
	}

	@Override
	public void remove(Cellphone cellphone) {
		cellphoneRepository.delete(cellphone);
	}

	@Override
	public Cellphone findById(long id) {
		Optional<Cellphone> retorno = cellphoneRepository.findById(id);
		if(retorno.isPresent()) 
			return retorno.get();
		return null;
	}

	@Override
	public Cellphone findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
