package com.company.gamestore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "Handler"})
@Table(name = "game")
public class Game implements Serializable {
    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "You must provide a title")
    @Size(max = 50, message = "Maximum of 50 characters")
    private String title;

    @NotEmpty(message = "You must provide an ESRB rating")
    @Size(max = 50, message = "Maximum of 50 characters")
    @Column(name = "esrb_rating")
    private String esrbRating;

    @NotEmpty(message = "You must provide a description")
    @Size(max = 255, message = "Maximum of 255 characters")
    private String description;

    @NotNull(message = "You must provide a price")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Digits(integer = 5, fraction = 2, message = "You must provide a max of 5 integer digits and 2 fractional digits")
    private BigDecimal price;

    @NotEmpty(message = "You must provide a studio")
    @Size(max = 20, message = "Maximum of 20 characters")
    private String studio;

    @NotNull(message = "You must provide a quantity")
    @Min(value = 1, message = "Quantity must be greater than 0")
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id && quantity == game.quantity && Objects.equals(title, game.title) && Objects.equals(esrbRating, game.esrbRating) && Objects.equals(description, game.description) && Objects.equals(price, game.price) && Objects.equals(studio, game.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, esrbRating, description, price, studio, quantity);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", esrbRating='" + esrbRating + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", studio='" + studio + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
