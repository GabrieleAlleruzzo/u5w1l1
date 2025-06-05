package it_gabriele.u5w1l1.repository;

import it_gabriele.u5w1l1.bean.Prodotto;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottoRepository extends JpaRepository<Prodotto,Integer> {
}
