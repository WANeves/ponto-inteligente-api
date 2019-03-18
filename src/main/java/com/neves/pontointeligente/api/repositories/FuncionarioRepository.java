package com.neves.pontointeligente.api.repositories;

import com.neves.pontointeligente.api.entities.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {

	Funcionario findByCpf(String cpf);
	
	Funcionario findByEmail(String email);
	
	Funcionario findByCpfOrEmail(String cpf, String email);
}
