package com.an.labweek4_software_architecture.Repository;

import com.an.labweek4_software_architecture.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
