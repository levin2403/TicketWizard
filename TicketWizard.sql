CREATE DATABASE IF NOT EXISTS ticketwizard;

USE ticketwizard;

-- modela la informacion de la persona(usuario)
CREATE TABLE IF NOT EXISTS Persona (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL, -- nombre completo de la persona 
    contraseña VARCHAR(200) NOT NULL, -- contraseña de la persona (encriptada)
    fecha_nacimiento DATE, -- fecha de nacimiento de la persona
    correo VARCHAR(100) NOT NULL, -- correo de la persona con el cual hara login
    saldo DECIMAL(10, 2) DEFAULT 0.00, -- saldo con el que cuenta actualmente
	id_domicilio INT NOT NULL, -- id que hace referencia al domicilio
    generated_key VARCHAR(100) NOT NULL, --  llave generada para encriptacion y desencriptacion de la contraseña
    CONSTRAINT UC_Correo UNIQUE (correo) 
);

-- tabla que modela la direccion de un cliente 
CREATE TABLE IF NOT EXISTS Direccion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ciudad VARCHAR(30) NOT NULL, 
    colonia VARCHAR(30) NOT NULL,
    calle VARCHAR(30) NOT NULL,
    num_exterior INT NOT NULL, -- numero exterior del domicilio
    num_interior INT DEFAULT NULL, -- numero interior del domicilio
    codigo_postal INT NOT NULL
);

-- esta tabla modela el venue que le corresponde a cada evento
CREATE TABLE IF NOT EXISTS Venue (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL, -- nombre del venue
    ciudad VARCHAR(100), -- ciudad donde se encuentra el venue 
    estado VARCHAR(100) -- estado del pais donde se encuentra el venue 
);

-- esta tabla modela la informacion necesaria de cada evento
CREATE TABLE IF NOT EXISTS Evento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL, -- nombre del evento
    fecha DATE NOT NULL, -- fecha en la que se realizara el evento
    descripcion VARCHAR(100), -- descripcion del evento (de que trata)
    image_url VARCHAR(50) NOT NULL, -- direccion url de la imagen promocional del evento
    id_venue INT NOT NULL -- id del venue donde se llevara a cabo el evento
);

-- esta tabla va a registrar los boletos pertenecientes a un evento
CREATE TABLE IF NOT EXISTS Boleto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    precio DECIMAL NOT NULL, -- ultimo precio al que fue vendido 
    numero_serie VARCHAR(8) NOT NULL UNIQUE, -- Número de serie único generado en cada venta.
    numero_control VARCHAR(8) NOT NULL UNIQUE, -- numero unico interno (este no se va a cambiar cada compra)
    fila VARCHAR(10), -- fila a la que le pertenece el asiento
    asiento VARCHAR(10), -- asiento al que le pertence el boleto
    tipo_boleto ENUM('BOLETERA', 'REVENTA') NOT NULL, -- para saber si fue adquirido por reventa o por boletera
    precio_original DECIMAL(10, 2) NOT NULL, -- Precio original del boleto.
    id_evento INT NOT NULL -- Relación con el evento
); 

-- esta tabla registra los boletos que le pertenecen a cada usuario, por lo que nos servira historial de las compras de una persona
CREATE TABLE IF NOT EXISTS Persona_Boleto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_persona INT NOT NULL, -- id de la persona a la que le pertenece el boleto
    id_boleto INT NOT NULL, -- id del boleto obtenido
    fecha_adquisicion DATE NOT NULL, -- fecha en la que dicho boleto fue adquirido
    hora_adquisicion TIME NOT NULL, -- hora en la que fue adquirido 
    tipo_adquisicion ENUM('BOLETERA', 'REVENTA') NOT NULL, -- para saber si fue adquirido por reventa o por boletera
    UNIQUE (id_persona, id_boleto), -- Llave única compuesta para evitar duplicados.
    FOREIGN KEY (id_persona) REFERENCES Persona(id),
    FOREIGN KEY (id_boleto) REFERENCES Boleto(id)
);	

CREATE TABLE IF NOT EXISTS HistorialVenta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_vendedor INT NOT NULL, -- id del vendedor del boleto
    id_comprador INT NOT NULL, -- id del comprador del boleto
    id_boleto INT NOT NULL, -- id del boleto que fue vendido
    precio_venta DECIMAL(10, 2) NOT NULL, -- Precio al que fue vendido
    fecha_venta DATE NOT NULL, -- Fecha en la que se realizo la venta 
    hora_venta TIME NOT NULL, -- Hora a la que se realizo la venta
    UNIQUE (id_vendedor, id_comprador, id_boleto), -- Llave única compuesta para evitar duplicados.
    FOREIGN KEY (id_vendedor) REFERENCES Persona(id),
    FOREIGN KEY (id_comprador) REFERENCES Persona(id),
    FOREIGN KEY (id_boleto) REFERENCES Boleto(id)
);

CREATE TABLE IF NOT EXISTS HistorialCompra (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_persona INT NOT NULL, -- id de la persona que compró el boleto
    id_boleto INT NOT NULL, -- id del boleto que fue comprado
    fecha_compra DATE NOT NULL, -- fecha en la que el boleto fue comprado
    hora_compra TIME NOT NULL, -- hora en la que fue comprado 
    tipo_compra ENUM('BOLETERA', 'REVENTA') NOT NULL, -- tipo de compra (boletera o reventa)
    FOREIGN KEY (id_persona) REFERENCES Persona(id),
    FOREIGN KEY (id_boleto) REFERENCES Boleto(id)
);

-- esta tabla va a representar los boletos que se encuentran a la venta
-- de esta tabla se van a comprar los boletos
CREATE TABLE IF NOT EXISTS Venta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_persona INT NOT NULL, -- id de la persona que esta vendiendo el boleto
    id_boleto INT NOT NULL, -- id del boleto que esta siendo vendido
    precio_venta DECIMAL(10, 2) NOT NULL, -- Precio fijado por el vendedor.
    fecha_limite_venta DATE NOT NULL, -- Fecha límite para la venta.
    estado VARCHAR(10) DEFAULT "DISPONIBLE" CHECK(estado IN("APARTADO","DISPONIBLE")),
    FOREIGN KEY (id_persona) REFERENCES Persona(id),
    FOREIGN KEY (id_boleto) REFERENCES Boleto(id)
);

CREATE TABLE IF NOT EXISTS VentaApartada(
	id INT AUTO_INCREMENT PRIMARY KEY,
    id_comprador INT NOT NULL,
    id_venta INT NOT NULL,
    fecha_apartado DATETIME NOT NULL,
    UNIQUE (id_comprador, id_venta), -- Llave única compuesta para evitar duplicados.
    FOREIGN KEY (id_venta) REFERENCES Venta(id),
    FOREIGN KEY (id_comprador) REFERENCES Persona(id)
);

-- Alter tables para mover las llaves foráneas al final

ALTER TABLE Persona
ADD CONSTRAINT fk_persona_domicilio FOREIGN KEY (id_domicilio) REFERENCES Direccion(id);

ALTER TABLE Evento
ADD CONSTRAINT fk_evento_venue FOREIGN KEY (id_venue) REFERENCES Venue(id);

ALTER TABLE Boleto
ADD CONSTRAINT fk_boleto_evento FOREIGN KEY (id_evento) REFERENCES Evento(id);



INSERT INTO Venue (nombre, ciudad, estado) VALUES 
('Auditorio Nacional', 'Ciudad de México', 'CDMX'),
('Arena Monterrey', 'Monterrey', 'Nuevo León'),
('Auditorio Telmex', 'Guadalajara', 'Jalisco'),
('Palacio de los Deportes', 'Cancún', 'Quintana Roo'),
('Estadio Caliente', 'Tijuana', 'Baja California'),
('Teatro Metropolitano', 'Querétaro', 'Querétaro'),
('Centro de Congresos', 'Querétaro', 'Querétaro'),
('Auditorio Gota de Plata', 'Puebla', 'Puebla');


INSERT INTO Evento (nombre, fecha, id_venue, descripcion, image_url) VALUES 
('BADBUNNY', '2024-12-01', 1, 'Concierto en vivo de Bad Bunny', 'BadBunny.jpeg'),
('VIERNESDLOKERA', '2024-12-15', 2, 'Festival de música urbana', 'ViernesDLokera.jpeg'),
('JACOB', '2024-12-22', 3, 'Concierto en vivo de Jacob', 'Jacob.jpeg'),
('STEVEAOKI', '2024-12-31', 4, 'Festival de música electrónica con Steve Aoki', 'SteveAoki.jpeg'),
('SNOOPDOG', '2025-01-10', 5, 'Concierto de Snoop Dogg', 'SnoopDog.jpeg'),
('ONEOAK', '2025-01-20', 6, 'Festival exclusivo de música One Oak', 'OneOak.jpeg'),
('MCC4', '2025-01-25', 7, 'Concierto de McC4', 'McC4.jpeg'),
('MEGASERTANEJO', '2025-02-05', 8, 'Mega festival de Sertanejo', 'MegaSertanejo.jpeg');

select * from boleto;

-- insertamos dos direcciones, con propositos de prueba
-- Inserciones para direcciones
INSERT INTO Direccion (ciudad, colonia, calle, num_exterior, num_interior, codigo_postal)VALUES 
('Ciudad de México', 'Centro', 'Calle Falsa', 123, 412, 12345),
('Guadalajara', 'Zapopan', 'Avenida Siempre Viva', 456, 12, 54321);


-- insertamos dos personas, con propositos de prueba
-- Inserciones para personas
INSERT INTO Persona (nombre, contraseña, fecha_nacimiento, correo, saldo, id_domicilio, generated_key) VALUES 
('Juan Pérez', 'password123', '1990-05-12', 'juan.perez@mail.com', 900.00, 1, 'key123456'),
('María García', 'password456', '1985-08-20', 'maria.garcia@mail.com', 900.00, 2, 'key789101');


-- representa los boletos comprados por el cliente
-- tmbn representaria el historial de los boletos comprados 
INSERT INTO Persona_Boleto (id_persona, id_boleto, fecha_adquisicion, hora_adquisicion, tipo_adquisicion) VALUES 
(1, 1, CURDATE(), CURTIME(), 'BOLETERA'),
(1, 2, CURDATE(), CURTIME(), 'BOLETERA'),
(1, 3, CURDATE(), CURTIME(), 'BOLETERA'),
(1, 4, CURDATE(), CURTIME(), 'BOLETERA'),
(1, 5, CURDATE(), CURTIME(), 'BOLETERA'),
(1, 6, CURDATE(), CURTIME(), 'BOLETERA'),
(1, 7, CURDATE(), CURTIME(), 'BOLETERA'),
(1, 8, CURDATE(), CURTIME(), 'BOLETERA'),
(1, 9, CURDATE(), CURTIME(), 'BOLETERA'),
(1, 10, CURDATE(), CURTIME(), 'BOLETERA'),

-- boletos que le pertenecen a el usuario con id = 2
(2, 11, CURDATE(), CURTIME(), 'BOLETERA'),
(2, 12, CURDATE(), CURTIME(), 'BOLETERA'),
(2, 13, CURDATE(), CURTIME(), 'BOLETERA'),
(2, 14, CURDATE(), CURTIME(), 'BOLETERA'),
(2, 15, CURDATE(), CURTIME(), 'BOLETERA'),
(2, 16, CURDATE(), CURTIME(), 'BOLETERA'),
(2, 17, CURDATE(), CURTIME(), 'BOLETERA'),
(2, 18, CURDATE(), CURTIME(), 'BOLETERA'),
(2, 19, CURDATE(), CURTIME(), 'BOLETERA'),
(2, 20, CURDATE(), CURTIME(), 'BOLETERA');

-- Inserciones de prueba para la tabla Venta, simulando que la persona 1 vende sus primeros 3 boletos
INSERT INTO Venta (id_persona, id_boleto, precio_venta, fecha_limite_venta) VALUES 
(1, 1, 300.00, DATE_ADD(CURDATE(), INTERVAL 7 DAY)), -- Primer boleto a la venta
(1, 2, 803.00, DATE_ADD(CURDATE(), INTERVAL 7 DAY)), -- Segundo boleto a la venta
(1, 3, 500.00, DATE_ADD(CURDATE(), INTERVAL 7 DAY)); -- Tercer boleto a la venta

INSERT INTO Venta (id_persona, id_boleto, precio_venta, fecha_limite_venta) VALUES 
(2, 11, 300.00, DATE_ADD(CURDATE(), INTERVAL 7 DAY)), -- Primer boleto a la venta
(2, 12, 803.00, DATE_ADD(CURDATE(), INTERVAL 7 DAY)), -- Segundo boleto a la venta
(2, 13, 500.00, DATE_ADD(CURDATE(), INTERVAL 7 DAY)); -- Tercer boleto a la venta

-- prueba para comprobar si el sp funciona, manden fuerzas
-- CREATE PROCEDURE RealizarVenta(
    -- IN p_id_persona_vendedor INT,
    -- IN p_id_persona_comprador INT,
    -- IN p_id_boleto INT,
    -- IN p_precio_venta DECIMAL(10, 2),
    -- IN p_numero_serie VARCHAR(8)
-- )
-- Simulación de que el cliente 2 compra el boleto 1 que estaba en venta
CALL RealizarVenta(
    1,           -- id del vendedor (cliente 1)
    2,           -- id del comprador (cliente 2)
    1,           -- id del boleto que se está comprando
    800.00,
    'A1BCD2EF'   -- nuevo número de serie para el boleto (8 caracteres)
);

-- realizar venta de un boleto apartado

call RealizarVentaApartada(1, 2, 1, 800.00, 'A1BCD2EF' );

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
SELECT * FROM information_schema.EVENTS WHERE EVENT_NAME = 'actualizar_ventas_apartadas';

call ApartarVenta(2,1);

select * from Venta;

select * from VentaApartada;

select * from Persona where id = 1;

select * from evento;

SELECT v.* FROM Venta v 
INNER JOIN Boleto b ON v.id_boleto = b.id 
WHERE v.id_persona != 1 AND b.id_evento = 2 
LIMIT 4 OFFSET 0;

SELECT v.* FROM Venta v 
INNER JOIN Boleto b ON v.id_boleto = b.id 
WHERE v.id_persona != 1 AND b.id_evento = 2 
AND v.precio_venta BETWEEN 300.00 AND 600.00 
LIMIT 4 OFFSET 0;

-- procedimiento almacenado que nos ayudara a registrar el apartado de una venta 
DELIMITER //

CREATE PROCEDURE ApartarVenta(
    IN p_id_comprador INT,
    IN p_id_venta INT
)
BEGIN
    -- 1. Insertar un nuevo registro en la tabla VentaApartada
    INSERT INTO VentaApartada (id_comprador, id_venta, fecha_apartado)
    VALUES (p_id_comprador, p_id_venta, CURRENT_TIMESTAMP());

    -- 2. Actualizar el estado de la venta a "APARTADO" en la tabla Venta
    UPDATE Venta
    SET estado = 'APARTADO'
    WHERE id = p_id_venta;

END //

DELIMITER ;


-- realizar la venta de un boleto que se encontraba apartado
DELIMITER //

CREATE PROCEDURE RealizarVentaApartada(
    IN p_id_persona_vendedor INT,
    IN p_id_persona_comprador INT,
    IN p_id_boleto INT,
    IN p_precio_venta DECIMAL(10, 2),
    IN p_numero_serie VARCHAR(8)
)
BEGIN
    DECLARE v_id_venta INT;

    -- Obtenemos el id de la venta asociada al boleto apartado
    SELECT id INTO v_id_venta 
    FROM Venta 
    WHERE id_boleto = p_id_boleto 
    LIMIT 1;

    -- Eliminamos el registro de la tabla VentaApartada antes de realizar la venta
    DELETE FROM VentaApartada 
    WHERE id_venta = v_id_venta;

    -- Llamamos al procedimiento RealizarVenta para completar la transacción
    CALL RealizarVenta(p_id_persona_vendedor, p_id_persona_comprador, p_id_boleto, p_precio_venta, p_numero_serie);

END //

DELIMITER ;




-- trigger para generar boletos cada vez que se inserten eventos
-- generara 10 boletos con sus respectivos campos 
DELIMITER //

CREATE TRIGGER GenerarBoletosTrasInsercionEvento
AFTER INSERT ON Evento
FOR EACH ROW
BEGIN
    DECLARE i INT;

    -- Generar 10 boletos para el nuevo evento
    SET i = 1;
    WHILE i <= 10 DO
        INSERT INTO Boleto (precio, numero_serie, numero_control, fila, asiento, tipo_boleto, precio_original, id_evento)
        VALUES (
            800.00, -- Precio de cada boleto
            CONCAT(SUBSTRING(MD5(RAND()), 1, 4), SUBSTRING(MD5(RAND()), 1, 4)), -- Número de serie único
            CONCAT(SUBSTRING(MD5(RAND()), 1, 4), SUBSTRING(MD5(RAND()), 1, 4)), -- Número de control único
            'A', -- Fila fija
            i, -- Asiento que va de 1 a 10
            'Boletera', -- Tipo de boleto inicial
            800.00, -- Precio original
            NEW.id -- Relación con el evento recién insertado
        );
        SET i = i + 1; -- Incrementar el contador de asientos
    END WHILE;
END //

DELIMITER;




-- procedimniento almacenado para realizar una venta de un boleto
DELIMITER //

CREATE PROCEDURE RealizarVenta(
    IN p_id_persona_vendedor INT,
    IN p_id_persona_comprador INT,
    IN p_id_boleto INT,
    IN p_precio_venta DECIMAL(10, 2),
    IN p_numero_serie VARCHAR(8)
)
BEGIN
    DECLARE v_precio_original DECIMAL(10, 2);
    DECLARE v_comision DECIMAL(10, 2);
    DECLARE v_precio_final DECIMAL(10, 2);
    
    -- Obtener el precio original del boleto
    SELECT precio_original INTO v_precio_original
    FROM Boleto
    WHERE id = p_id_boleto;
    
    -- Calcular la comisión (3%)
    SET v_comision = p_precio_venta * 0.03;
    
    -- Calcular el precio final para el vendedor
    SET v_precio_final = p_precio_venta - v_comision;

    -- 1. Eliminar la venta de la tabla Venta
    DELETE FROM Venta 
    WHERE id_boleto = p_id_boleto;

    -- 2. Actualizar el registro de Persona_Boleto para el nuevo dueño
    UPDATE Persona_Boleto 
    SET id_persona = p_id_persona_comprador, 
        fecha_adquisicion = CURDATE(), -- Fecha actual
        hora_adquisicion = CURTIME(),  -- Hora actual
        tipo_adquisicion = 'REVENTA'   -- Actualizamos a 'REVENTA'
    WHERE id_boleto = p_id_boleto;

    -- 3. Insertar en HistorialVenta (Registro de la transacción)
    INSERT INTO HistorialVenta (id_vendedor, id_comprador, id_boleto, precio_venta, fecha_venta, hora_venta)
    VALUES (p_id_persona_vendedor, p_id_persona_comprador, p_id_boleto, v_precio_final, CURDATE(), CURTIME());

    -- 4. Insertar en HistorialCompra (Registro de la compra)
    INSERT INTO HistorialCompra (id_persona, id_boleto, fecha_compra, hora_compra, tipo_compra)
    VALUES (p_id_persona_comprador, p_id_boleto, CURDATE(), CURTIME(), 'REVENTA');

    -- 5. Actualizar los saldos
    UPDATE Persona 
    SET saldo = saldo - p_precio_venta 
    WHERE id = p_id_persona_comprador;

    UPDATE Persona 
    SET saldo = saldo + v_precio_final 
    WHERE id = p_id_persona_vendedor;

    -- 6. Actualizar el boleto con el nuevo número de serie, precio y tipo
    UPDATE Boleto 
    SET numero_serie = p_numero_serie,
        precio = p_precio_venta,
        tipo_boleto = 'REVENTA'
    WHERE id = p_id_boleto;
END //

DELIMITER ;


DELIMITER //

CREATE EVENT actualizar_ventas_apartadas
ON SCHEDULE EVERY 1 MINUTE
DO
BEGIN
    -- Actualizar el estado de la venta a 'DISPONIBLE' si han pasado más de 10 minutos
    UPDATE Venta v
    INNER JOIN VentaApartada va ON v.id = va.id_venta
    SET v.estado = 'DISPONIBLE'
    WHERE va.fecha_apartado <= (NOW() - INTERVAL 10 MINUTE);

    -- Eliminar el registro de la tabla VentaApartada después de actualizar
    DELETE FROM VentaApartada 
    WHERE fecha_apartado <= (NOW() - INTERVAL 10 MINUTE);
END //

DELIMITER ;