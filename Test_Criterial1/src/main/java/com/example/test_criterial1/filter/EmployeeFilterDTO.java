package com.example.test_criterial1.filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Accessors(chain = true)
public class EmployeeFilterDTO {
    private Long idOff;
    private Date timeOnboard;

    private String role;

    public String getRole() {
        return role;
    }

    public Long getIdOff() {
        return idOff;
    }

    public Date getTimeOnboard() {
        return timeOnboard;
    }
}
