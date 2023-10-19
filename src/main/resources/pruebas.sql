-- Inserción de alergias
INSERT INTO alergia (id_alergia, nombre) VALUES ('1', 'Alergia a paracetamol');
INSERT INTO alergia (id_alergia, nombre) VALUES ('2', 'Alergia al polen');
-- Datos de ejemplo para la entidad Cita
-- Datos de ejemplo para la entidad Cita
INSERT INTO cita (id_cita, fecha_creacion, hora, fecha, motivo)
VALUES
    (1, '2023-10-10', '08:00:00', '2023-10-15', 'Consulta de rutina'),
    (2, '2023-10-11', '09:30:00', '2023-10-16', 'Seguimiento de tratamiento'),
    (3, '2023-10-12', '15:15:00', '2023-10-17', 'Examen de laboratorio');
-- Datos de ejemplo para la entidad Ciudad
INSERT INTO ciudad (id_ciudad, nombre)
VALUES
    ('1', 'Bogotá'),
    ('2', 'Medellín'),
    ('3', 'Cali'),
    ('4', 'Barranquilla'),
    ('5', 'Cartagena');
-- Datos de ejemplo para la entidad Consulta
INSERT INTO consulta (id_consulta, fecha, notas_medico, diagnostico)
VALUES
    (1, '2023-10-10', 'Notas del médico 1', 'Diagnóstico 1'),
    (2, '2023-10-11', 'Notas del médico 2', 'Diagnóstico 2'),
    (3, '2023-10-12', 'Notas del médico 3', 'Diagnóstico 3'),
    (4, '2023-10-13', 'Notas del médico 4', 'Diagnóstico 4'),
    (5, '2023-10-14', 'Notas del médico 5', 'Diagnóstico 5');
-- Datos de ejemplo para la entidad EPS
INSERT INTO eps (id_eps, nombre)
VALUES
    ('EPS001', 'EPS Aseguradora de Salud'),
    ('EPS002', 'EPS Salud Total'),
    ('EPS003', 'EPS Familiar'),
    ('EPS004', 'EPS Bienestar Salud'),
    ('EPS005', 'EPS VitalCare');
-- Datos de ejemplo para la entidad Especializacion
INSERT INTO especializacion (id_especializacion, nombre, descripcion)
VALUES
    (1, 'Dermatología', 'Especialización en diagnóstico y tratamiento de enfermedades de la piel'),
    (2, 'Cardiología', 'Especialización en diagnóstico y tratamiento de enfermedades del corazón'),
    (3, 'Gastroenterología', 'Especialización en diagnóstico y tratamiento de enfermedades del sistema digestivo'),
    (4, 'Neurología', 'Especialización en diagnóstico y tratamiento de enfermedades del sistema nervioso'),
    (5, 'Pediatría', 'Especialización en atención médica de niños y adolescentes');
INSERT INTO Usuario (id_usuario, email, nombre, password, tipo)
VALUES ('usuario1', 'usuario1@example.com', 'Usuario 1', 'contraseña123', 'MEDICO'),
       ('usuario2', 'usuario2@example.com', 'Usuario 2', 'contraseña123', 'MEDICO'),
       ('usuario3', 'usuario3@example.com', 'Usuario 3', 'contraseña123', 'MEDICO');
INSERT INTO Medico (id_usuario)
VALUES ('usuario1'),
       ('usuario2');
-- Insertar datos en la tabla HorarioMedico

-- Primer horario de un médico
INSERT INTO horario_medico (id_horario,hora_inicio, hora_final, fecha_libre, medico_id_usuario)
VALUES ('123','10:00:00', '14:00:00', '2023-10-20', 'usuario1');

-- Segundo horario de un médico
INSERT INTO horario_medico (id_horario,hora_inicio, hora_final, fecha_libre, medico_id_usuario)
VALUES ('25','14:00:00', '18:00:00', '2023-10-21', 'usuario2');


INSERT INTO medicamento (id_medicamento, nombre, descripcion)
VALUES ('1', 'Paracetamol', 'Medicamento para el dolor'),
       ('2', 'Ibuprofeno', 'Medicamento para el dolor'),
       ('3', 'Amoxicilina', 'Medicamento para infecciones'),
       ('4', 'Omeprazol', 'Medicamento para el dolor'),
       ('5', 'Loratadina', 'Medicamento para alergias');



INSERT INTO Paciente (id_usuario,fecha_nacimiento)
VALUES ('usuario3', '1990-01-15');

INSERT INTO pqrs (num_radicado, fecha_creacion, detalle)
VALUES (1, '2023-10-10', 'PQRS 1'),
       (2, '2023-10-11', 'PQRS 2'),
       (3, '2023-10-12', 'PQRS 3'),
       (4, '2023-10-13', 'PQRS 4'),
       (5, '2023-10-14', 'PQRS 5');

INSERT INTO respuestapqrs (id_repuesta,detalle,fecha_creacion,hora_creacion)
VALUES (1,'Respuesta 1','2023-10-10','08:00:00'),
       (2,'Respuesta 2','2023-10-11','09:30:00'),
       (3,'Respuesta 3','2023-10-12','15:15:00'),
       (4,'Respuesta 4','2023-10-13','08:00:00'),
       (5,'Respuesta 5','2023-10-14','09:30:00');

INSERT INTO usuario (id_usuario, email, nombre, password)
VALUES ('1', 'emai@email.com', 'Paciente 1', 'contraseña'),
       ('2', 'emai1@email.com', 'Paciente 2', 'contraseña'),
       ('3', 'emai2@email.com', 'Paciente 3', 'contraseña');