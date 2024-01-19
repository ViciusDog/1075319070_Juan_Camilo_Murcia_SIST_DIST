-- Creación de la base de datos

-- Primero, definamos las entidades y relaciones del modelo relacional:
-- Usuario (UserID, Nombre, Tipo [Admin/Visitante])
-- Libro (LibroID, Titulo, Categoria, SalaID)
-- Sala (SalaID, Nombre)
-- Préstamo (PrestamoID, LibroID, UsuarioID, FechaPrestamo, FechaDevolucion)


CREATE DATABASE Biblioteca;

-- Uso de la base de datos
USE Biblioteca;

-- Creación de la tabla Usuario
CREATE TABLE Usuario (
    UserID INT PRIMARY KEY,
    Nombre VARCHAR(50),
    Tipo ENUM('Admin', 'Visitante')
);

-- Creación de la tabla Sala
CREATE TABLE Sala (
    SalaID INT PRIMARY KEY,
    Nombre VARCHAR(50)
);

-- Creación de la tabla Libro
CREATE TABLE Libro (
    LibroID INT PRIMARY KEY,
    Titulo VARCHAR(100),
    Categoria VARCHAR(50),
    SalaID INT,
    FOREIGN KEY (SalaID) REFERENCES Sala(SalaID)
);

-- Creación de la tabla Prestamo
CREATE TABLE Prestamo (
    PrestamoID INT PRIMARY KEY,
    LibroID INT,
    UsuarioID INT,
    FechaPrestamo DATE,
    FechaDevolucion DATE,
    FOREIGN KEY (LibroID) REFERENCES Libro(LibroID),
    FOREIGN KEY (UsuarioID) REFERENCES Usuario(UserID)
);

-- Inserciones de usuario, sala, libro y prestamo 
INSERT INTO Usuario (UserID, Nombre, Tipo) VALUES
(1, 'Admin1', 'Admin'),
(2, 'Visitante1', 'Visitante'),
(3, 'Visitante2', 'Visitante');

INSERT INTO Sala (SalaID, Nombre) VALUES
(1, 'Sala A'),
(2, 'Sala B');

INSERT INTO Libro (LibroID, Titulo, Categoria, SalaID) VALUES
(101, 'Libro1', 'Ficción', 1),
(102, 'Libro2', 'No Ficción', 2),
(103, 'Libro3', 'Misterio', 1);

INSERT INTO Prestamo (PrestamoID, LibroID, UsuarioID, FechaPrestamo, FechaDevolucion) VALUES
(1001, 101, 2, '2024-01-18', '2024-01-25'),
(1002, 102, 3, '2024-01-20', '2024-01-27'),
(1003, 103, 2, '2024-01-22', '2024-01-29');





