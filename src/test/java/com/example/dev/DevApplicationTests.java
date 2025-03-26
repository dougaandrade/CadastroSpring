package com.example.dev;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.dev.Enum.StatusSetor;
import com.example.dev.Funcionarios.DTO.FuncionariosDTO;
import com.example.dev.Funcionarios.Model.Cpf;
import com.example.dev.Funcionarios.Service.FuncionariosService;
import com.example.dev.Setores.DTO.SetoresDTO;
import com.example.dev.Setores.Model.SetoresModel;
import com.example.dev.Setores.Service.SetoresService;

@ExtendWith(MockitoExtension.class)
class DevApplicationTests {

	@Mock
	private SetoresService setoresService;

	@Mock
	private FuncionariosService funcionariosService;

	@InjectMocks
	private DevApplicationTests testInstance;

	private SetoresDTO setores;
	private FuncionariosDTO funcionarios;

	@BeforeEach
	void setUp() {
		setores = new SetoresDTO();
		setores.setSetor("TI 8");
		setores.setDescricao("Departamento de Tecnologia da Informação 8");
		setores.setStatus(StatusSetor.ABERTO);

		funcionarios = new FuncionariosDTO();
		funcionarios.setNome("Matheus");
		funcionarios.setEmail("0e8Q2@example.com");
		funcionarios.setIdade(20);
		funcionarios.setCpf(new Cpf("12345678900"));
		funcionarios.setDataNascimento(LocalDate.of(2000, 1, 1));
		SetoresModel setorModel = new SetoresModel();
		setorModel.setId(1L);
		funcionarios.setSetor(setorModel);

	}

	@Test
	void testSetor() {
		when(setoresService.criarSetor(setores)).thenReturn(setores);

		SetoresDTO resultado = setoresService.criarSetor(setores);

		assertEquals("TI 8", resultado.getSetor());
		assertEquals("Departamento de Tecnologia da Informação 8", resultado.getDescricao());
		assertEquals(StatusSetor.ABERTO, resultado.getStatus());
	}

	@Test
	void testFuncionarios() {
		when(funcionariosService.criarNovoFuncionario(funcionarios)).thenReturn(funcionarios);

		FuncionariosDTO resultado = funcionariosService.criarNovoFuncionario(funcionarios);

		assertEquals("Matheus", resultado.getNome());
		assertEquals("0e8Q2@example.com", resultado.getEmail());
		assertEquals(20, resultado.getIdade());
		assertEquals(new Cpf("12345678900"), resultado.getCpf());
		assertEquals(LocalDate.of(2000, 1, 1), resultado.getDataNascimento());
		assertEquals(1L, resultado.getSetor().getId());
	}
}
