package database;

import entities.EmpleadosEntity;
import jakarta.persistence.EntityManager;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public class ConsultarEmpleados {

    public static void leerEmpleados(EntityManager em) {

        // Recuperar un objeto de la clase EmpleadosEntity por su primary key
        EmpleadosEntity e = em.find(EmpleadosEntity.class, 7499);
        System.out.println("Nombre empleado: " + e.getApellido() + "  ||  Departamento: " + e.getDepartamentosByDeptNo().getDnombre());

        String jpql = "from EmpleadosEntity where deptNo = 20";

        // Acceder al nombre del departamento en el que está el empleado:
        List<EmpleadosEntity> es = em.createQuery(jpql, EmpleadosEntity.class).getResultList();

        // CONSULTA DE SELECCIÓN
        EmpleadosEntity e2 = em.createQuery("from EmpleadosEntity where empNo = 7369", EmpleadosEntity.class).getSingleResult();

    }
}
