//pakages :
package game.arenas.air;

//imports:
import utilities.EnumContainer;


public class AerialArena extends Arena {
    private final double DEFAULT_FRICTION=0.4;
    private final int DEFAULT_MAX_RACERS=6;
    private final static int DEFAULT_LENGTH =1500;

    private EnumContainer.Vision vision = EnumContainer.Vision.SUNNY;
    private EnumContainer.Weather weather=EnumContainer.Weather.DRY;
    private EnumContainer.Height height=EnumContainer.Height.HIGH;
    private EnumContainer.Wind wind =EnumContainer.Wind.HIGH;

    public AerialArena(){
        super();

    };

    public AerialArena(double length,int maxRacer)
    {
        super(length,maxRacer,this.DEFAULT_FRICTION);

    }

    public EnumContainer.Weather getWeather() {
        return weather;
    }

    public EnumContainer.Height getHeight() {
        return height;
    }

    public EnumContainer.Wind getWind() {
        return wind;
    }

    public EnumContainer.Vision getVision() {
        return vision;
    }



    public boolean setWind(EnumContainer.Wind wind)
    {
        if(wind != null) {
            this.wind = wind;
            return true;
        }
        return false;
    }
    public boolean setHeight(EnumContainer.Height height)
    {
        if(height != null) {
            this.height = height;
            return true;
        }
        return false;
    }

    public boolean setVision(EnumContainer.Vision vision)
    {
        if(vision != null) {
            this.vision = vision;
            return true;
        }
        return false;
    }

    public boolean setWeather(EnumContainer.Weather weather)
    {
        if(weather != null) {
            this.weather = weather;
            return true;
        }
        return false;

    }
}
