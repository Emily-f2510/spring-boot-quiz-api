package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Intrebare;
import java.util.List;

@Repository
public interface CerinteRepository extends JpaRepository<Intrebare, Integer> {
    //  3.a: Raspunsurile pentru id_i între 1 și 3 la testul id_t = 4
    @Query(value = "SELECT r.id_i, r.id_r, r.raspuns, r.corect " +
            "FROM raspuns r " +
            "JOIN test t ON r.id_i = t.id_i " +
            "WHERE t.id_t = 4 AND r.id_i BETWEEN 1 AND 3 " +
            "ORDER BY r.id_i, r.id_r", nativeQuery = true)
    List<Object[]> cerinta_3a();

    // 3.b: id_t si data pentru testele din semestrul 1 anul 2025
    @Query(value = "SELECT id_t, data_test FROM test " +
            "WHERE data_test BETWEEN '2025-09-01' AND '2025-12-30' " +
            "ORDER BY data_test ASC", nativeQuery = true)
    List<Object[]> cerinta_3b();

// 4a. Răspunsuri model vs Răspunsuri date pentru întrebările cu punctaj 0
    @Query(value =
            "SELECT t.id_t AS Test, t.id_i AS Intrebare, " +
                    "(SELECT r.raspuns FROM raspuns r WHERE r.id_i = t.id_i AND r.corect = 'D' LIMIT 1) AS Raspuns_model, " +
                    "IFNULL((SELECT r.raspuns FROM raspuns_test rt " +
                    "        JOIN raspuns r ON rt.id_i = r.id_i AND rt.id_r = r.id_r " +
                    "        WHERE rt.id_t = t.id_t AND rt.id_i = t.id_i LIMIT 1), 'nu s-a răspuns') AS Raspuns_dat " +
                    "FROM test t " +
                    "WHERE t.punctaj_obtinut = 0 " +
                    "ORDER BY t.id_t, t.id_i",
            nativeQuery = true)
    List<Object[]> cerinta_4a();

    // 4.b: Perechi de teste care au același punctaj la aceeași întrebare
    @Query(value =
            "SELECT DISTINCT t1.id_t AS id_t1, t2.id_t AS id_t2 " +
                    "FROM test t1 " +
                    "JOIN test t2 ON t1.id_i = t2.id_i " +
                    "AND t1.punctaj_obtinut = t2.punctaj_obtinut " +
                    "AND t1.id_t < t2.id_t " +
                    "ORDER BY id_t1, id_t2",
            nativeQuery = true)
    List<Object[]> cerinta_4b();

// 5a. Răspunsurile valide (corecte) pentru întrebările din testul cu ID 1
@Query(value =
        "SELECT r.raspuns " +
                "FROM raspuns r " +
                "JOIN test t ON r.id_i = t.id_i " +
                "WHERE r.corect = 'D' AND t.id_t = 1",
        nativeQuery = true)
List<Object[]> cerinta_5a();

// 5b. Să se găsească testele pentru care s-au dat toate răspunsurile la toate întrebările
    @Query(value =
            "SELECT t.id_t " +
                    "FROM test t " +
                    "GROUP BY t.id_t " +
                    "HAVING COUNT(DISTINCT t.id_i) = (" +
                    "    SELECT COUNT(DISTINCT rt.id_i) " +
                    "    FROM raspuns_test rt " +
                    "    WHERE rt.id_t = t.id_t" +
                    ")",
            nativeQuery = true)
    List<Object[]> cerinta_5b();


    // 6a. Pentru fiecare test: numărul de întrebări și punctajul total
    @Query(value =
            "SELECT id_t AS Test, " +
                    "COUNT(*) AS Numar_Intrebari, " +
                    "SUM(punctaj_obtinut) AS Punctaj_Total " +
                    "FROM test " +
                    "GROUP BY id_t " +
                    "ORDER BY id_t",
            nativeQuery = true)
    List<Object[]> cerinta_6a();

    // 6b. Întrebările cu raportul maxim între suma punctajelor și numărul de teste (punctaj mediu maxim)
    @Query(value =
            "SELECT id_i, AVG(punctaj_obtinut) AS medie " +
                    "FROM test " +
                    "GROUP BY id_i " +
                    "HAVING medie = (" +
                    "    SELECT MAX(media_per_intrebare) " +
                    "    FROM (" +
                    "        SELECT AVG(punctaj_obtinut) AS media_per_intrebare " +
                    "        FROM test " +
                    "        GROUP BY id_i" +
                    "    ) AS subquery" +
                    ")",
            nativeQuery = true)
    List<Object[]> cerinta_6b();
}