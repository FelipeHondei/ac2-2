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
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false, unique = true)
    private String cpf;
    
    @Column(nullable = false)
    private String rg;
    
    @Column(nullable = false)
    private String endereco;
    
    @Column(nullable = false)
    private String celular;
    
    @OneToMany(mappedBy = "professor")
    private Set<Especializacao> especializacoes = new HashSet<>();
    
    @OneToMany(mappedBy = "professor")
    private Set<Agendamento> agendamentos = new HashSet<>();
    
    @OneToOne(mappedBy = "professor")
    private Usuario usuario;
}