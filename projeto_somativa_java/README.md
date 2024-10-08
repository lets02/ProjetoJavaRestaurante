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
---

## 3. Cronograma (Diagrama Gantt)

### Fases do Projeto

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

### Exemplo de Diagrama de Gantt

O cronograma será organizado em ferramentas como Microsoft Project ou Trello, permitindo acompanhar o progresso das fases e evitar atrasos.

---

## 4. Análise de Risco

### Principais Riscos

1. **Alterações de Requisitos durante o Projeto**:
   - **Impacto**: Mudanças inesperadas podem atrasar a entrega.
   - **Mitigação**: Definir claramente os requisitos desde o início e ter um processo de aprovação para alterações.

2. **Dificuldade de Adoção pelos Funcionários**:
   - **Impacto**: Funcionários podem ter dificuldades para se adaptar ao novo sistema.
   - **Mitigação**: Oferecer treinamento adequado e suporte contínuo.

3. **Problemas no Banco de Dados**:
   - **Impacto**: Falhas no banco de dados podem impactar as operações do restaurante.
   - **Mitigação**: Realizar backups frequentes e ter uma equipe técnica disponível para resolver problemas.

4. **Sobrecarga do Sistema**:
   - **Impacto**: O sistema pode ficar lento ou falhar durante horários de pico.
   - **Mitigação**: Realizar testes de desempenho e otimizar o código.

---

## 5. Recursos

### Humanos

- **Gerente de Projetos**: Coordena as atividades e a comunicação com o cliente.
- **Desenvolvedores Backend**: Implementam a lógica do sistema e a integração com o banco de dados.
- **Desenvolvedores Frontend**: Criam a interface do usuário.
- **Designer UX/UI**: Desenvolve um layout visualmente atraente e fácil de usar.
- **Testadores**: Garantem que o sistema funcione corretamente.

### Tecnológicos

- **Backend**: Java
- **Biblioteca**: Lombok
- **Banco de Dados**: PostgreSQL
- **Frontend**: Bootstrap
- **Hospedagem**: Nginx ou Apache
- **Ferramentas de Gestão de Projetos**: Trello ou Microsoft Project.

### Financeiros

- **Orçamento**: Considerar custos de desenvolvimento, licenças de software, hospedagem e manutenção do sistema.

---

## 6. Diagramas

### 1. Diagrama de Classes

Mostra a estrutura de classes do sistema:

- **Administrador**: Gerencia o cadastro de funcionários, pratos e estoque.
- **Funcionário**: Controla operações diárias e ingredientes.
- **Cliente**: Acessa o sistema para visualizar o cardápio e realizar pedidos.
- **Ingrediente**: Representa os itens do estoque.
- **Prato**: Detalha os pratos disponíveis no cardápio.
- **Pedido**: Gerencia os pedidos realizados pelos clientes.

### 2. Diagrama de Casos de Uso

Descreve as interações dos usuários com o sistema:

- **Administrador**: Cadastra funcionários, gerencia estoque e pratos.
- **Funcionário**: Atualiza ingredientes e gerencia pedidos.
- **Cliente**: Visualiza o cardápio e realiza pedidos.

### 3. Diagrama de Fluxo

Mostra o fluxo de dados entre cliente, sistema e banco de dados, desde o login, cadastro até a realização de pedidos e atualização de estoque.

---

## 7. Experiência do Usuário

### Administrador

- **História**: Como administrador, quero um sistema que facilite o cadastro de funcionários e a atualização do cardápio, para manter o restaurante sempre organizado.
- **Necessidades**: Facilidade de uso e ferramentas eficientes para controle de pratos e estoque.

### Funcionário

- **História**: Como funcionário, quero acessar rapidamente o sistema para registrar o uso de ingredientes e verificar o estoque disponível, garantindo que nunca falte nada.
- **Necessidades**: Interface simples que permita atualizações rápidas do estoque, com alertas para ingredientes em baixa quantidade.

### Cliente

- **História**: Como cliente, quero visualizar o cardápio de forma clara e realizar meus pedidos online, para ter uma experiência de compra fácil e rápida.
- **Necessidades**: Interface atraente e intuitiva, facilidade no cadastro e na escolha de pratos, com opções de pagamento e confirmação de pedido imediata.

---

## Conclusão

O sistema de gerenciamento para o restaurante japonês busca melhorar o controle interno e oferecer uma experiência positiva para todos os envolvidos. Com uma abordagem organizada e um cronograma bem definido, o projeto será desenvolvido para atender às necessidades específicas do restaurante, utilizando Java, Lombok e PostgreSQL para garantir um desempenho robusto e confiável.
