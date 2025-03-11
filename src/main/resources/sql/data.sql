-- Inserir usuários (2 admins, 3 usuários regulares)
INSERT INTO users (name, email, password, role, creation_date) VALUES
('Admin One', 'admin1@example.com', '$2a$10$encodedpassword1', 'ADMIN', CURRENT_TIMESTAMP),
('Admin Two', 'admin2@example.com', '$2a$10$encodedpassword2', 'ADMIN', CURRENT_TIMESTAMP),
('User One', 'user1@example.com', '$2a$10$encodedpassword3', 'USER', CURRENT_TIMESTAMP),
('User Two', 'user2@example.com', '$2a$10$encodedpassword4', 'USER', CURRENT_TIMESTAMP),
('User Three', 'user3@example.com', '$2a$10$encodedpassword5', 'USER', CURRENT_TIMESTAMP);

-- Inserir projetos (5 projetos de diferentes áreas)
INSERT INTO projects (name, description) VALUES
('Sistema de Gerenciamento de Projetos', 'Plataforma para organizar projetos de TI'),
('E-commerce Avançado', 'Plataforma online para vendas de produtos diversos'),
('Sistema de Finanças Pessoais', 'Aplicativo para gerenciar finanças pessoais e orçamentos'),
('Plataforma de Ensino Online', 'Sistema para cursos e-learning'),
('Controle de Estoque', 'Sistema para gerenciar o estoque de uma empresa');

-- Inserir atividades relacionadas a cada projeto
INSERT INTO activities (name, description, project_id) VALUES
('Planejamento Inicial', 'Criação do escopo do projeto', 1),
('Desenvolvimento do Backend', 'Codificação da API em Java', 1),
('Implementação do Frontend', 'Criação de interfaces em Angular', 1),
('Teste e Integração', 'Validação de funcionalidades', 1),
('Planejamento de Produtos', 'Definição de categorias no sistema de e-commerce', 2),
('Integração de Pagamento', 'Configuração de gateways de pagamento', 2);

-- Inserir lançamentos de horas para atividades (associados aos projetos)
INSERT INTO time_entries (description, start_time, end_time, activity_id, user_id) VALUES
('Trabalho em planejamento inicial do projeto', '2025-03-10 09:00:00', '2025-03-10 12:00:00', 1, 3),
('Desenvolvimento da API em Java', '2025-03-10 13:00:00', '2025-03-10 17:00:00', 2, 3),
('Construção do Frontend para o projeto de Gerenciamento', '2025-03-11 09:00:00', '2025-03-11 12:00:00', 3, 4),
('Validação final do sistema', '2025-03-11 13:00:00', '2025-03-11 16:00:00', 4, 4),
('Planejamento inicial do e-commerce', '2025-03-12 09:00:00', '2025-03-12 11:00:00', 5, 5),
('Integração de pagamentos no e-commerce', '2025-03-12 13:00:00', '2025-03-12 17:00:00', 6, 5);
