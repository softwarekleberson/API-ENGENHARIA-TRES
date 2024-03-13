package br.com.engenharia.projeto.ProjetoFinal.dtos;

import java.time.LocalDate;
import java.util.Set;

import br.com.engenharia.projeto.ProjetoFinal.entidade.Genero;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCliente(
        
        @NotNull Genero genero,
        
        @NotBlank String nome,
        
        @NotNull LocalDate nascimento,
        
        @NotBlank String cpf,
        
        @Valid @NotNull DadosCadastroEmail email,
        
        @Valid @NotNull DadosCadastroTelefone telefone,
        
        @Valid @NotNull DadosCadastroSenha senha,
        
        @Valid @NotNull DadosCadastroConfirmarSenha confirmarSenha,

        @Valid @NotNull Set<DadosCadastroEntrega> entrega,
        
        @Valid @NotNull Set<DadosCadastroEndereco> cobranca
                                                                    )                                                       {
}
