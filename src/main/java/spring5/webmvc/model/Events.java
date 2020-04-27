package spring5.webmvc.model;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Events {

    @NotBlank
    private String name;

    @Min(0)
    private int limit;
}
