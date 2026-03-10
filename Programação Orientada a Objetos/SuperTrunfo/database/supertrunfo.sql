CREATE DATABASE super_trunfo;
USE super_trunfo;

CREATE TABLE carta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    velocidade INT,
    aceleracao INT,
    potencia INT,
    super_trunfo BOOLEAN DEFAULT FALSE
);

INSERT INTO carta (nome, velocidade, aceleracao, potencia, super_trunfo) VALUES
('Ferrari F8 Tributo', 340, 3, 720, FALSE),
('Lamborghini Huracán', 325, 3, 640, FALSE),
('Porsche 911 Turbo S', 330, 2, 650, FALSE),
('McLaren 720S', 341, 2, 720, FALSE),
('Bugatti Chiron', 420, 2, 1500, TRUE);  -- Super Trunfo