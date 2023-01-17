package org.atomiv.template.lite.web.restapi.repositories;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

}

/*
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class ArrivalRepositoryTest {

   @Autowired
   private TestEntityManager entityManager;

   @Autowired
   private ArrivalRepository arrivalRepository;

   @Test
   public void whenFindAll() {
       //given
       Arrival firstArrival = new Arrival();
       firstArrival.setCity("Yerevan");
       entityManager.persist(firstArrival);
       entityManager.flush();

       Arrival secondArrival = new Arrival();
       secondArrival.setCity("Israel");
       entityManager.persist(secondArrival);
       entityManager.flush();

       //when
       List<Arrival> arrivals = arrivalRepository.findAll();

       //then
       assertThat(arrivals.size()).isEqualTo(9);
       assertThat(arrivals.get(7)).isEqualTo(firstArrival);
       assertThat(arrivals.get(8)).isEqualTo(secondArrival);
   }

   @Test
   public void whenFindAllById() {
       //given
       Arrival arrival = new Arrival();
       arrival.setCity("Yerevan");
       entityManager.persist(arrival);
       entityManager.flush();

       //when
       Arrival testArrival = arrivalRepository.findAllById(arrival.getId());

       //then
       assertThat(testArrival.getCity()).isEqualTo(arrival.getCity());
   }
}
 */