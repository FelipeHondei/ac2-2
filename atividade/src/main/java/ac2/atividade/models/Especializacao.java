package ac2.atividade.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Especializacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;
    
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
}