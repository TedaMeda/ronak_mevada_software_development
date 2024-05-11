package com.shipment.ronak_mevada_software_development.load;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author TedaMeda
 * @since 5/9/2024
 */
@Getter
public enum ProductType {
    Chemicals("chemicals"),
    Electronics("electronics"),
    Apparel("apparel"),
    Books("books"),
    HomeAndKitchen("home & kitchen"),
    HealthAndPersonalCare("health & personal care"),
    Beauty("beauty"),
    Automotive("automotive"),
    ToysAndGames("toys & games"),
    SportsAndOutdoors("sports & outdoors"),
    ToolsAndHomeImprovement("tools & home improvement"),
    GroceryAndGourmetFood("grocery & gourmet food"),
    PetSupplies("pet supplies"),
    Baby("baby"),
    OfficeProducts("office products"),
    MoviesAndTV("movies & TV"),
    Music("music"),
    IndustrialAndScientific("industrial & scientific"),
    ArtsCraftsAndSewing("arts crafts & sewing"),
    GardenAndOutdoor("garden & outdoor"),
    Software("software");

    private String label;

    ProductType(String label) {
        this.label = label;
    }
}
