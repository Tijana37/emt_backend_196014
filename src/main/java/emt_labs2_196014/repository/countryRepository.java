package emt_labs2_196014.repository;

import emt_labs2_196014.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface countryRepository extends JpaRepository<Country, Long> {
}
