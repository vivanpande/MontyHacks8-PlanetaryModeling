package planet.model;

import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;

// 3D Textures (assuming usage of JavaFX 3D features)
public class Textures {

    // Materials for 3D planets
    public static final PhongMaterial MERCURY_MATERIAL = createMaterial(
            "demo\\src\\main\\resources\\texture\\2k_mercury.jpg");
    public static final PhongMaterial VENUS_MATERIAL = createMaterial(
            "demo\\src\\main\\resources\\texture\\2k_venus_atmosphere.jpg");
    public static final PhongMaterial EARTH_MATERIAL = createMaterial(
            "demo\\src\\main\\resources\\texture\\2k_earth_normal_map.tif");
    public static final PhongMaterial MARS_MATERIAL = createMaterial(
            "demo\\src\\main\\resources\\texture\\2k_mars.jpg");
    public static final PhongMaterial JUPITER_MATERIAL = createMaterial(
            "demo\\src\\main\\resources\\texture\\2k_jupiter.jpg");
    public static final PhongMaterial SATURN_MATERIAL = createMaterial(
            "demo\\src\\main\\resources\\texture\\2k_saturn.jpg");
    public static final PhongMaterial URANUS_MATERIAL = createMaterial(
            "demo\\src\\main\\resources\\texture\\2k_uranus.jpg");
    public static final PhongMaterial NEPTUNE_MATERIAL = createMaterial("/textures/neptune.png");

    // Materials for 3D dwarf planets
    public static final PhongMaterial PLUTO_MATERIAL = createMaterial("/textures/pluto.png");
    public static final PhongMaterial CERES_MATERIAL = createMaterial("/textures/ceres.png");
    public static final PhongMaterial ERIS_MATERIAL = createMaterial("/textures/eris.png");
    public static final PhongMaterial MAKEMAKE_MATERIAL = createMaterial("/textures/makemake.png");
    public static final PhongMaterial HAUMEA_MATERIAL = createMaterial("/textures/haumea.png");

    private static PhongMaterial createMaterial(String texturePath) {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(texturePath));
        return material;
    }

    private Textures() {
        // Prevent instantiation
    }
}
