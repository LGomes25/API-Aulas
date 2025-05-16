package org.serratec.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.entity.Aluno;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	private static List<Aluno> alunos = new ArrayList();

	static {
		alunos.add(new Aluno(123L, "Adriano", "adriano@gmail.com"));
		alunos.add(new Aluno(132L, "Jose", "jose@gmail.com"));
		alunos.add(new Aluno(456L, "Jaco", "jaco@gmail.com"));
		alunos.add(new Aluno(159L, "Romeu", "romeu@gmail.com"));
	}

	@GetMapping 		// teste: http://localhost:8080/alunos
	public List<Aluno> listar() {
		return alunos;
	}

	@GetMapping("/{matricula}") 		//teste: http://localhost:8080/alunos/132
	public Aluno buscar(@PathVariable Long matricula) {
		return alunos.stream()
				.filter(a->a.getMatricula().equals(matricula))
				.findFirst()
				.orElse(null);
		
//		for (Aluno aluno : alunos) {
//			if (aluno.getMatricula().equals(matricula)) {
//				return aluno;
//			}
//		}
//		return null;
	}
	
	@PostMapping	//insere um aluno por vez => teste: http://localhost:8080/alunos
	public Aluno inserir(@RequestBody Aluno aluno) {
		alunos.add(aluno);
		return aluno;
	}
	
	@PostMapping("/varios")		//insere vários alunos => teste: http://localhost:8080/alunos/varios
	public List<Aluno> inserir(@RequestBody List<Aluno> alunosNovos){
		alunos.addAll(alunosNovos);
		return alunos;
	}

	@DeleteMapping("/{matricula}") 		//apaga aluno  => teste: http://localhost:8080/alunos/159
	public void apagar(@PathVariable Long matricula) {
		for (Aluno aluno : alunos) {
			if (aluno.getMatricula().equals(matricula)) {
				alunos.remove(aluno);
				break;
			}
		}
		
//		for(int i=0;i<alunos.size();i++) {
//			if(alunos.get(i).getMatricula().equals(matricula)) {
//				alunos.remove(i);
//				break;
//			}
//		}
				
	}
	
	@PutMapping("/{matricula}") 	//altera aluno  => teste: http://localhost:8080/alunos/123
	public Aluno atualizar(@PathVariable Long matricula, @RequestBody Aluno aluno) {
		
		for (Aluno a : alunos) {
			if (a.getMatricula().equals(matricula)) {
				aluno.setMatricula(matricula);
				alunos.set(alunos.indexOf(a), aluno);
				return aluno;
			}
		}
		return null;
		
//		for(int i =0;i< alunos.size();i++) {
//			if(alunos.get(i).getMatricula().equals(matricula)) {
//				Aluno a = new Aluno(matricula, aluno.getNome(), aluno.getEmail());
//				alunos.set(i, a);
//				return a;
//			}
//		}
//		return null;

	}
	
}
