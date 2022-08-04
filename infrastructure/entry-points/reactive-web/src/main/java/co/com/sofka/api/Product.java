package co.com.sofka.api;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Product {
    private Integer id;
    private String name;
}
