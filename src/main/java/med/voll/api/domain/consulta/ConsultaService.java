package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.infra.excepciones.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private ConsultaRepository repository;

    public void agendarConsulta(DatosAgendarConsulta datos) {

        if (pacienteRepository.findById(datos.idPaciente()).isPresent()) {
            throw new ValidacionDeIntegridad("El paciente no existe");
        }

        if (datos.idMedico() != null && medicoRepository.existsById(datos.idMedico())) {
            throw new ValidacionDeIntegridad("El médico no existe");
        }

        var paciente = pacienteRepository.findById(datos.idPaciente()).get();

        var medico = seleccionarMedico(datos);

        var consulta = new Consulta(null, paciente, medico, datos.fecha());

        repository.save(consulta);
    }

    private Medico seleccionarMedico(DatosAgendarConsulta datos) {
        if (datos.idMedico() != null) {
            medicoRepository.existsById(datos.idMedico());
        }

        if (datos.especialidad() == null) {
            throw new ValidacionDeIntegridad("No se puede seleccionar un médico sin especificar la especialidad");
        }

        return medicoRepository.seleccionarMedicoPorEspecialidadEnFecha(datos.especialidad(), datos.fecha());
    }
}