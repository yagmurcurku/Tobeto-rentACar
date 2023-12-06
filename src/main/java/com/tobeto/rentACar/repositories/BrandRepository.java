package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Brand;
import com.tobeto.rentACar.services.dtos.responses.brand.GetByBrandListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {



    //JPA Derived Query Method  -->[1]<--
    List<Brand> findAllByNameLike(String name);        //--> default olarak liste döndürüyor
    //List olmadan (Brand findByName..) yazılsaydı liste değil bulduğu ilk değeri döndürürdü

    List<Brand> findByNameLikeOrIdEquals(String name, int id);
    //Or yerine And olsaydı hem name benzemeliydi hem de id eşit olmalıydı
    //Şuan Or olduğu için ikisinden biri olsa da entity çekilebiliyor.


    boolean existsByName(String name);
    //varsa true, yoksa false döner

        // JPQL     -->[2]<--
        // JPQL = JPA + SQL
    //@Query("SELECT b FROM Brand b")   => SELECT * FROM Brands AS b
    //List<Brand> search();
        //Üzerine @Query anotasyonu eklenen metot çalıştırıldığı
        //zaman veritabanına bağlanılır ve "" içinde verilen sorgu
        //çalıştırılır. Db'den gelen sonuç ise bu metot ile geri döndürülür.

        //JPQL'de tablo ismi yerine entity ismi kullanılır.
        //b yerine herhangi bir ifade kullanılabilir, tercihe bağlı
            //genelde tablosunun baş harfinin küçük hali kullanılır.


    //@Query("SELECT b FROM Brand b WHERE b.name LIKE '%Tes%'")
    //List<Brand> search();

    //@Query("SELECT b FROM Brand b WHERE b.name=:name")
    @Query("SELECT b FROM Brand b WHERE b.name LIKE %:name%")
    List<Brand> search(String name);

    //Eğer JPQL değil de normal SQL sorgusu atılmak istenirse "" içine
    //sorgu yazılır ve default olarak false olan nativeQuery true yapılır
    @Query(value = "SELECT * FROM brands WHERE name LIKE %:name%", nativeQuery = true)
    List<Brand> search2(String name);


    @Query("SELECT new com.tobeto.rentACar.services.dtos.responses.brand.GetByBrandListResponse(b.name) " +
            "FROM Brand b WHERE b.name LIKE %:name%")
    List<GetByBrandListResponse> search3(String name);


    @Query(value = "SELECT b.name FROM brands b WHERE name LIKE %:name%", nativeQuery = true)
    List<GetByBrandListResponse> search4(String name);
    //nativeQuery kullanımı çok yaygın değil. Fakat sadece entity dönülecekse(örneğin: Brand) kullanılabilir.
    //DTO döndürüleceği zaman nativeQuery kullanımı tercih edilmez. Bir alternatiftir ama kullanımı karmaşık.


    //Katman oluşturma mantığı/sırası: (en ufak bağımlılıktan başlanmalı)
    //Entity -> dtos -> Repository -> Service -> Controller


    //JPQL'de inner join mantığı kurulabilir (-->CarRepository)


}
