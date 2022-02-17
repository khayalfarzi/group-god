package az.iktlab.group.god.BPT.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private Integer personId;
    private String personName;
    private String personSurname;
    private List<Book> bookList;
}
