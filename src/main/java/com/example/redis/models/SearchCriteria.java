package com.example.redis.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Mainuddin on 20-Feb-19.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria implements Serializable{
    private String nid;
    private String firstName;
    private String lastName;
}
