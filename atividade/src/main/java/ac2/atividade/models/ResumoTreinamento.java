package ac2.atividade.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumoTreinamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "agendamento_id", nullable = false)
    private Agendamento agendamento;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;
    
    @Column(nullable = false)
    private LocalDateTime dataCadastro;
    
    @PrePersist
    protected void onCreate() {
        dataCadastro = LocalDateTime.now();
    }
}