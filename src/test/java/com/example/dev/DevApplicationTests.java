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
import com.example.dev.Funcionarios.DTO.FuncionariosRequest.FuncionariosRequest;
import com.example.dev.Funcionarios.DTO.FuncionariosResponse.FuncionariosResponse;
import com.example.dev.Funcionarios.Model.Cpf;
import com.example.dev.Funcionarios.Model.FuncionariosModel;
import com.example.dev.Funcionarios.Service.FuncionariosService;
import com.example.dev.Setores.DTO.SetoresResquest.SetoresRequest;
import com.example.dev.Setores.Model.SetoresModel;
import com.example.dev.Setores.Service.SetoresService;

import jakarta.validation.Valid;

@ExtendWith(MockitoExtension.class)
class DevApplicationTests {

	@Mock
	private SetoresService setoresService;

	@Mock
	private FuncionariosService funcionariosService;

	@InjectMocks
	private DevApplicationTests testInstance;

	private @Valid SetoresRequest setoresRequest;
	private @Valid FuncionariosRequest funcionariosRequest;

	@BeforeEach
	void setUp() {
		setoresRequest = new SetoresRequest();
		setoresRequest.setSetor("TI 8");
		setoresRequest.setDescricao("Departamento de Tecnologia da Informação 8");
		setoresRequest.setStatus(StatusSetor.ABERTO);

		funcionariosRequest = new FuncionariosRequest();
		funcionariosRequest.setNome("Matheus");
		funcionariosRequest.setEmail("0e8Q2@example.com");
		funcionariosRequest.setIdade(20);
		funcionariosRequest.setCpf(new Cpf("12345678900"));
		funcionariosRequest.setDataNascimento(LocalDate.of(2000, 1, 1));
		SetoresModel setorModel = new SetoresModel();
		setorModel.setId(1L);
		funcionariosRequest.setSetor(setorModel);

	}

	@Test
	void testSetor() {
		SetoresModel mockModel = new SetoresModel();
		mockModel.setSetor("TI 8");
		mockModel.setDescricao("Departamento de Tecnologia da Informação 8");
		mockModel.setStatus(StatusSetor.ABERTO);

		when(setoresService.criarSetor(setoresRequest)).thenReturn(mockModel);

		SetoresModel resultado = setoresService.criarSetor(setoresRequest);

		assertEquals("TI 8", resultado.getSetor());
		assertEquals("Departamento de Tecnologia da Informação 8", resultado.getDescricao());
		assertEquals(StatusSetor.ABERTO, resultado.getStatus());
	}

	@Test
	void testFuncionarios() {
		FuncionariosResponse mockResponse = new FuncionariosResponse();
		mockResponse.setNome("Matheus");
		mockResponse.setEmail("0e8Q2@example.com");
		mockResponse.setIdade(20);
		mockResponse.setCpf(new Cpf("12345678900"));
		mockResponse.setDataNascimento(LocalDate.of(2000, 1, 1));

		SetoresModel setorModel = new SetoresModel();
		setorModel.setId(1L);
		mockResponse.setSetor(setorModel);

		// mock correto DEPOIS de criar o response
		when(funcionariosService.criarNovoFuncionario(funcionariosRequest)).thenReturn(mockResponse);

		FuncionariosResponse resultado = funcionariosService.criarNovoFuncionario(funcionariosRequest);

		assertEquals("Matheus", resultado.getNome());
		assertEquals("0e8Q2@example.com", resultado.getEmail());
		assertEquals(20, resultado.getIdade());
		assertEquals(new Cpf("12345678900"), resultado.getCpf());
		assertEquals(LocalDate.of(2000, 1, 1), resultado.getDataNascimento());
		assertEquals(1L, resultado.getSetor().getId());
	}

}
