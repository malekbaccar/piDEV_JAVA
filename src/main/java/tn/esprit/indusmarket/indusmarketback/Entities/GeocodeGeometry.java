package tn.esprit.indusmarket.indusmarketback.Entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeGeometry {
    @JsonProperty("location")
    Adress geocodeLocation;
    public GeocodeGeometry() {
    }
    public Adress getGeocodeLocation() {
        return geocodeLocation;
    }
    public void setGeocodeLocation(Adress geocodeLocation) {
        this.geocodeLocation = geocodeLocation;
    }
}