package com.neves.pontointeligente.api.services.impl;

import java.util.Optional;

import com.neves.pontointeligente.api.entities.Empresa;
import com.neves.pontointeligente.api.repositories.EmpresaRepository;
import com.neves.pontointeligente.api.services.EmpresaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	private final EmpresaRepository empresaRepository;

	@Autowired
	public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}

	@Override
	public Optional<Empresa> buscarPorCnpj(String cnpj) {
		log.info("Buscando uma empresa para o CNPJ {}", cnpj);
		return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
	}

	@Override
	public Empresa persistir(Empresa empresa) {
		log.info("Persistindo empresa: {}", empresa);
		return this.empresaRepository.save(empresa);
	}
}
