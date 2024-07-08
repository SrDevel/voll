package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findByActivoTrue(Pageable paginacion);

    @Query("""
            SELECT m FROM Medico m
            WHERE m.activo= TRUE AND
            m.especialidad = :especialidad AND
            m.id NOT IN (
                SELECT c FROM Consulta c
                WHERE c.data = :fecha
            )
            ORDER BY rand()
            LIMIT 1
            """)
    Medico seleccionarMedicoPorEspecialidadEnFecha(String especialidad, LocalDateTime fecha);
}
