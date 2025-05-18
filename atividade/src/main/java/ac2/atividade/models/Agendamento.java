package ac2.atividade.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
    
    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;
    
    @Column(nullable = false)
    private LocalDate dataInicio;
    
    @Column(nullable = false)
    private LocalDate dataFim;
    
    @Column(nullable = false)
    private LocalTime horarioInicio;
    
    @Column(nullable = false)
    private LocalTime horarioFim;
    
    @Column(nullable = false)
    private String cidade;
    
    @Column(nullable = false)
    private String estado;
    
    @Column(nullable = false)
    private String cep;
    
    @OneToMany(mappedBy = "agendamento")
    private Set<ResumoTreinamento> resumos = new HashSet<>();
}