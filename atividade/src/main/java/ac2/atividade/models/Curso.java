package ac2.atividade.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String descricao;
    
    @Column(nullable = false)
    private Integer cargaHoraria;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String objetivos;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String ementa;
    
    @OneToMany(mappedBy = "curso")
    private Set<Especializacao> especializacoes = new HashSet<>();
    
    @OneToMany(mappedBy = "curso")
    private Set<Agendamento> agendamentos = new HashSet<>();
}