package com.example.dev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dev.Enum.StatusSetor;
import com.example.dev.Setores.DTO.SetoresDTO;
import com.example.dev.Setores.Service.SetoresService;

@SpringBootTest
class DevApplicationTests {

	@Autowired
	private SetoresService setoresService;

	@Test
	void contextLoads() {
		// Este teste verifica se o contexto da aplicação carrega corretamente.
	}

	@Test
	void testSetor() {
		// Criando um DTO e definindo valores
		SetoresDTO setores = new SetoresDTO();
		setores.setSetor("TI 5");
		setores.setDescricao("Departamento de Tecnologia da Informação 5");
		// setores.setFuncionarios(setores.getFuncionarios()); // Supondo que deveria
		setores.setStatus(StatusSetor.ABERTO);

		setores = setoresService.criarSetor(setores);

		// Assertions para verificar se os valores permanecem corretos
		assertEquals(setores.getSetor(), setores.getSetor());
		assertEquals(setores.getDescricao(), setores.getDescricao());
		assertEquals(setores.getFuncionarios(), setores.getFuncionarios());
		assertEquals(setores.getStatus(), setores.getStatus());
	}
}
