package com.example.dev.Funcionarios.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import com.example.dev.Setores.Model.SetoresModel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionariosDTO {

  @PositiveOrZero(message = "Código do funcionário não pode ser negativo")
  private Long codFuncionario;

  @NotNull(message = "Nome não pode ser nulo")
  @Size(min = 1, message = "Nome não pode ser vazio")
  private String nome;

  @Email(message = "Email inválido")
  private String email;

  @Min(value = 18, message = "Idade mínima é 18 anos")
  private int idade;

  @Pattern(regexp = "\\d{11}", message = "CPF deve ter 11 dígitos")
  private String cpf;

  @Past(message = "Data de nascimento deve ser no passado")
  private LocalDate dataNascimento;

  private SetoresModel setor;
}
