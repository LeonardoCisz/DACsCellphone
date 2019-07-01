package br.univille.cellphone2019.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.univille.cellphone2019.model.Cellphone;

public interface CellphoneRepository extends JpaRepository<Cellphone, Long>{
	
	Cellphone findByModelo(String modelo);

}