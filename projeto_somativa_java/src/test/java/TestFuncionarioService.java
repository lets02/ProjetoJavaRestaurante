import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.restaurante.Models.Funcionario;
import com.restaurante.Test.Repository.TesteFuncionarioRepository;
import com.restaurante.Test.Service.TesteFuncionarioService;

public class TestFuncionarioService {
    private TesteFuncionarioRepository repositoryMock;
    private TesteFuncionarioService funcionarioService;
    private Funcionario funcionarioMock;


    @BeforeEach
    public void setUp() {
        // Criar mock do repositório
        repositoryMock = Mockito.mock(TesteFuncionarioRepository.class);

        // Criar instância do serviço com o mock injetado
        funcionarioService = new TesteFuncionarioService(repositoryMock);

        // Criar mock de um funcionário para usar nos testes
        funcionarioMock = new Funcionario();
        funcionarioMock.setId(1L);
        funcionarioMock.setNome("João Silva");
        funcionarioMock.setCpf("12345678901");
        funcionarioMock.setCargo("Gerente");
        funcionarioMock.setLogin("joao");
        funcionarioMock.setSenha("senha123");
    }

    @Test
    public void testCadastrarFuncionarioComSucesso() {
        // Executar o método de cadastro
        funcionarioService.cadastrarFuncionario(funcionarioMock);

        // Verificar se o método de salvar foi chamado no repositório
        verify(repositoryMock).save(funcionarioMock);
    }

    @Test
    public void testAutenticarFuncionarioComSucesso() {
        // Simular comportamento do repositório
        when(repositoryMock.findByLogin("joao")).thenReturn(funcionarioMock);

        // Executar o método de autenticação
        Funcionario resultado = funcionarioService.autenticarFuncionario("joao", "senha123");

        // Verificar se a autenticação foi bem-sucedida
        assertEquals(funcionarioMock, resultado);

        // Verificar se o método de encontrar por login foi chamado
        verify(repositoryMock).findByLogin("joao");
    }

    @Test
    public void testAutenticarFuncionarioFalhaLogin() {
        // Simular comportamento do repositório
        when(repositoryMock.findByLogin("joao")).thenReturn(funcionarioMock);

        // Executar o método de autenticação com senha errada
        Funcionario resultado = funcionarioService.autenticarFuncionario("joao", "senhaErrada");

        // Verificar se a autenticação falhou
        assertNull(resultado);
    }

    @Test
    public void testAutenticarFuncionarioFuncionarioNaoEncontrado() {
        // Simular comportamento do repositório: funcionário não existe
        when(repositoryMock.findByLogin("maria")).thenReturn(null);

        // Executar o método de autenticação
        Funcionario resultado = funcionarioService.autenticarFuncionario("maria", "senha123");

        // Verificar se a autenticação falhou
        assertNull(resultado);
    }
}
