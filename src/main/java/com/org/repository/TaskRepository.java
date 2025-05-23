package com.org.repository;

import com.org.model.Developer;
import com.org.model.Task;
import com.org.model.enums.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.time.LocalDate;

public interface TaskRepository extends JpaRepository<Task, Long> {

    //Verifica sino existe una tarea con el mismo nombre
    boolean existsByTitle(String title);

    // Cuenta cuántas tareas activas tiene un developer (por estados)
    @Query("SELECT COUNT(t) FROM Task t WHERE t.developer.id = :developerId AND t.status IN :statuses")
    int countActiveTasksByDeveloperId(Long developerId, List<TaskStatus> statuses);

    // Lista todas las tareas con paginación
    Page<Task> findAll(Pageable pageable);

    // Lista tareas dentro de un rango de fechas con paginación
    @Query("SELECT t FROM Task t WHERE t.StartDateTime >= :start AND t.EndDateTime <= :end")
    Page<Task> findTasksByDateRange(LocalDate start, LocalDate end, Pageable pageable);

    // Lista tareas de un developer según una lista de estados
    @Query("SELECT t FROM Task t WHERE t.developer.id = :developerId AND t.status IN :statuses")
    List<Task> findTasksByDeveloperIdAndStatusIn(Long developerId, List<TaskStatus> statuses);


    //

}
