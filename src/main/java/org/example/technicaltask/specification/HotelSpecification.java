package org.example.technicaltask.specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.example.technicaltask.entity.Hotel;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class HotelSpecification {

    public static Specification<Hotel> filter(
            String name,
            String brand,
            String city,
            String country,
            String amenities
    ) {
        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (name != null)
                predicates.add(cb.like(cb.lower(root.get("name")),
                        "%" + name.toLowerCase() + "%"));

            if (brand != null)
                predicates.add(cb.equal(cb.lower(root.get("brand")),
                        brand.toLowerCase()));

            if (city != null)
                predicates.add(cb.equal(cb.lower(root.get("address").get("city")),
                        city.toLowerCase()));

            if (country != null)
                predicates.add(cb.equal(cb.lower(root.get("address").get("country")),
                        country.toLowerCase()));

            if (amenities != null) {
                Join<Hotel, String> join = root.joinSet("amenities");
                predicates.add(cb.equal(join, amenities));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
