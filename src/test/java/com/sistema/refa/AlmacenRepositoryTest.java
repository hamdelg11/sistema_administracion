package com.sistema.refa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sistema.refa.almacen.Almacen;
import com.sistema.refa.almacen.AlmacenRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class AlmacenRepositoryTest {
	
	@Autowired
	private AlmacenRepository repositorio;
	
	@Test
	public void testCrearAlmacen() {
		Almacen almacenGuardada=repositorio.save(new Almacen("Matriz"));
		assertThat(almacenGuardada.getId()).isGreaterThan(0);
	}

}
