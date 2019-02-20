package com.example.redis.models;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Mainuddin on 20-Feb-19.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private String nid;

    @Getter @Setter
    private String contactNumber;

    @Getter @Setter
    private LocalDate dateOfBirth;
}
