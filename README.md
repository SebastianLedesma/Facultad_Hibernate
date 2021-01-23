# Facultad_Hibernate
Construido con:
.Eclipse
.Maven(gestor de proyectos)
.Hibernate
.MySql(base de datos)
.JSP
.CSS

Sistema CRUD que administra los profesores y alumnos de una facultad.

Estructura de las tablas:
profesor|columnas:id,nombre,apellido,curso
alumno|columnas:id,nombre,apellido,direccion,teléfono,profesor_id

Listado de métodos:
ProfesorRepository
.save(Profesor) --> Método que guarda un profesor de la BD.
.update(Profesor) --> Método que actualiza un profesor de la BD.
.delete(Profesor) --> Método que elimina un profesor de la BD. Al ser eliminación en cascada(Hibernate) también se eliminarán los alumnos asignados.
.getAll() --> Método que retorna todos los profesores almacenados en la BD.
.getLikeId(int id) --> Método que retorna un profesor según el parámetro id.
.getAlumnosLikeId(int idProfesor) --> Método que retorna los alumnos asignados al profesor.

AlumnoRepository
.save(Alumno) --> Método que guarda un alumno de la BD.
.update(Alumno) --> Método que actualiza un alumno de la BD.
.delete(Alumno) --> Método que elimina un alumno de la BD.
.getAll() --> Método que retorna todos los alumnos almacenados en la BD.
.getLikeId(int id) --> Método que retorna un alumno según el parámetro id.

Recorrido del sitio:
.index.jsp --> Página inicial de la aplicación.
.MenuPrincipal.jsp --> Página que permite acceder a los profesores y alumnos registrados.
.VistaProfesores.jsp --> Muesta los profesores registrados como también dar de alta,actualizar y eliminar un alumno.
.ActualizarProfesor.jsp --> Página central donde se puede actualizar los datos de un alumno.
.VistaAlumnos.jsp --> Muestra los alumnos registrados como también dar de alta, actualizar y eliminar un alumno.
.ActualizarAlumno.jsp --> Página central donde se puede actualizar los datos de un profesor.
.Resultado.jsp --> Muestra el resultado de la operación realizada,sea dar de alta,actualizar o borrar un registro.
 