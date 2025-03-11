Sistema de Gerenciamento de Projetos - Back-End

O back-end deste sistema foi desenvolvido utilizando tecnologias modernas e robustas, garantindo desempenho, segurança e escalabilidade para gerenciar dados e operações.

Tecnologias Utilizadas
Java 21: A última versão LTS (Long Term Support) do Java, oferecendo maior desempenho, funcionalidades avançadas e suporte para produção de longo prazo.

Spring Boot 3.4.3: Framework para construção de aplicações Java modernas, com foco em simplificar a configuração e o desenvolvimento, oferecendo uma base poderosa para APIs REST.

Spring Security: Implementação de autenticação e autorização via JWT (JSON Web Tokens), garantindo proteção para rotas e dados sensíveis.

Hibernate e JPA: Ferramentas para mapeamento objeto-relacional (ORM), facilitando a interação com o banco de dados.

Banco de Dados MySQL: Um banco relacional robusto e amplamente utilizado, escolhido pela sua confiabilidade e facilidade de uso.

Maven: Gerenciador de dependências e build, garantindo a organização e o controle das bibliotecas do projeto.

Funcionalidades do Back-End
Autenticação e Autorização:

Implementação de autenticação baseada em JWT.

Controle de acesso às rotas com base em papéis (ADMIN e USER).

Gestão de Dados:

Criação, leitura, atualização e exclusão de dados para usuários, projetos, atividades e lançamentos de horas.

Proteção de Dados:

Validações rigorosas com Bean Validation (@NotNull, @Size, etc.) para garantir a integridade dos dados.

Configuração de rotas protegidas, incluindo rotas públicas e privadas.

Execução de Scripts SQL:

Scripts automatizados para inicializar as tabelas com dados de exemplo.

Desempenho e Escalabilidade:

Configurações avançadas do Spring Boot para suportar ambientes de produção.

Como Iniciar o Back-End
Configuração do Banco de Dados:

Certifique-se de que o MySQL esteja instalado.

Crie um banco de dados para a aplicação:

sql
CREATE DATABASE project_management_system;
Atualize o arquivo application.properties com suas credenciais de acesso ao banco:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/project_management_system
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
Executar a Aplicação:

No terminal, acesse o diretório do projeto back-end:

bash
cd project-management-backend
Compile e execute a aplicação:

bash
mvn spring-boot:run
O servidor estará disponível em: http://localhost:8080.

Documentação e Scripts SQL
A documentação completa da API pode ser encontrada no arquivo API_DOCUMENTATION.md, incluindo detalhes sobre as rotas e exemplos de uso.

Os scripts SQL de inicialização estão localizados em: src/main/resources/sql/data.sql, fornecendo dados de exemplo para testes.