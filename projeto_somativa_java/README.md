# Sistema de Gerenciamento para Restaurante Japonês


## 1. Escopo
O projeto tem como objetivo criar um sistema de gerenciamento para um restaurante japonês, visando facilitar e organizar as operações do dia a dia. O sistema proporcionará uma experiência fluida tanto para os administradores quanto para os funcionários e clientes. A proposta é centralizar todas essas funcionalidades em uma plataforma acessível e prática, utilizando tecnologias como Java, Lombok e PostgreSQL.

---


## 2. Objetivos SMART

- **Específico (S)**: Desenvolver uma plataforma digital onde os administradores poderão cadastrar funcionários, pratos e gerenciar cardápio, os funcionários poderão cadastrar ingredientes, gerenciar estoque e gerenciar os pedidos, enquanto os clientes poderão se cadastrar, visualizar o cardápio e realizar pedidos de maneira simples.


- **Mensurável (M)**: O sistema deverá operar com todas as funcionalidades principais, atendendo a uma alta porcentagem dos pedidos de clientes e controle de estoque de forma eficiente.


- **Atingível (A)**: O desenvolvimento do sistema será realizado com uma equipe dedicada, utilizando Java para o backend, Lombok para simplificar o código e PostgreSQL para o banco de dados, com um cronograma bem definido que permite a entrega de cada módulo.


- **Relevante (R)**: A implementação desse sistema trará melhorias significativas ao restaurante, facilitando o controle interno e aprimorando a experiência do cliente ao realizar pedidos. Isso ajudará a minimizar erros e a tornar a operação mais eficiente.


- **Temporal (T)**: Todo o sistema deve ser desenvolvido, testado e implementado em um período razoável, com entregas parciais e testes contínuos. 



### 2. Cronogramas

1. **Levantamento de Requisitos**: 2 semanas (Outubro 2024)
   - Definição das funcionalidades necessárias e do fluxo do sistema em conjunto com o cliente.

2. **Design de Interface (UX/UI)**: 3 semanas (Outubro - Novembro 2024)
   - Criação de um design que seja fácil de usar e atraente, alinhado à estética do restaurante.

3. **Desenvolvimento Backend**: 4 semanas (Novembro 2024)
   - Implementação da lógica do sistema, integração com o banco de dados PostgreSQL e desenvolvimento das funcionalidades principais.

4. **Desenvolvimento Frontend**: 4 semanas (Novembro - Dezembro 2024)
   - Criação da interface do usuário, focando em responsividade e usabilidade.
   
5. **Testes de Funcionalidades**: 2 semanas (Dezembro 2024)
   - Testes de usabilidade, desempenho e correção de bugs.

6. **Implantação e Treinamento**: 1 semana (Dezembro 2024)
   - Colocação do sistema em produção e treinamento dos usuários finais.



## 4. Análise de Risco

### Principais Riscos

1. **Alterações de Requisitos durante o Projeto**:
   - **Impacto**: Mudanças inesperadas podem atrasar a entrega.
   - **Mitigação**: Definir claramente os requisitos desde o início e ter um processo de aprovação para alterações.

2. **Dificuldade de Adoção pelos Funcionários**:
   - **Impacto**: Funcionários podem ter dificuldades para se adaptar ao novo sistema.
   - **Mitigação**: Oferecer treinamento adequado e suporte contínuo.
   ]
3. **Problemas no Banco de Dados**:
   - **Impacto**: Falhas no banco de dados podem impactar as operações do restaurante.
   - **Mitigação**: Realizar backups frequentes e ter uma equipe técnica disponível para resolver problemas.

4. **Sobrecarga do Sistema**:
   - **Impacto**: O sistema pode ficar lento ou falhar durante horários de pico.
   - **Mitigação**: Realizar testes de desempenho e otimizar o código.


---

## 5. Recursos Tecnológicos

- *Backend*: Java 
- *Biblioteca*: Lombok
- *Banco de Dados*: PostgreSQL
- *Ferramentas de Gestão de Projetos*: Draw.io 
                          

## 6. Diagramas

### DIAGRAMAS:

### DIAGRAMA DE USO:
<p><img src="img/Diagrama de Uso.PNG" width="500px">

### DIAGRAMA DE FLUXO:
<p><img src="img/Digrama de Fluxo.PNG" width="500px">

### DIAGRAMA DE CLASSE:
<p><img src="img/Diagrama de Classe.PNG" width="500px">


# Manual do Usuário: Sistema de Gerenciamento para Restaurante Japonês


## Funcionalidades

### Administradores

1. **Cadastro de Funcionários**:
   - Acesse o **Painel do Administrador** e selecione **Cadastrar Funcionário**.
   - Quando clicar em **Adicionar Funcionário**, preencha os dados necessários (nome, cargo, etc.) e clique em **Cadastrar**.
   
2. **Gerenciamento do Cardápio**:
   - Acesse o **Painel do Administrador**.
   - Adicione novos pratos clicando em **Cadastrar Prato**, preenchendo as informações e salvando.
   - Ao acessar **Visualizar Cardápio** você poderá  **Editar** ou **Excluir** pratos já cadastrados no Cardápio.
   

### Funcionários

1. **Cadastro de Ingredientes**:
   - Acesse o menu **Gerenciamento de Estoque**.
   - Clique em  **Estoque**, aparecerá **Cadastrar Ingrediente** e poderá preencher os dados do ingrediente e clique em salvar no estoque, quando cadastrado algum você poderá excluir e editar.
   -
   
2. **Gerenciamento de Pedidos**:
   - Na seção de **Visualizar Pedidos**, você poderá ver uma lista de pedidos dos clientes.
   - Na seção **Concluir Pedido**, você verá uma lista de pedidos pendentes, selecione um pedido e clique em **Concluir** para marcá-lo como finalizado.
   - Para excluir pedidos concluídos, use a opção **Excluir Pedido**.

### Clientes

1. **Cadastro de Cliente**:
   - Vá até a página de **Cadastro Cliente** e insira suas informações pessoais (nome, e-mail, telefone).
   - Clique em **Cadastrar** para finalizar.

2. **Realizar Pedido**:
   - Faça login e navegue até o **Visualizar Cardápio**.
   - No **Fazer Pedido** Selecione os pratos desejados, adicione-os ao carrinho e finalize o pedido.

---

## Navegação e Uso

### Interface do Sistema
O sistema é dividido em módulos para facilitar o acesso:
- **Administradores**: Gerenciar funcionários, cadastro de pratos e gerenciamento de cardápio.
- **Funcionários**: Visualizar e gerenciar pedidos feitos pelos clientes.
- **Cardápio**: Acesso para os clientes verem os pratos e realizarem pedidos.

### Como Navegar
1. Faça login no sistema e selecione o menu correspondente ao seu perfil (Administrador, Funcionário ou Cliente).
2. Utilize as abas e botões disponíveis para acessar as funcionalidades desejadas.


