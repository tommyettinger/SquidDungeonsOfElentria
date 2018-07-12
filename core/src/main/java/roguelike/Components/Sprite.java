package roguelike.Components;

import com.badlogic.gdx.graphics.Color;
import org.json.simple.JSONObject;
import roguelike.utilities.Colors;
import squidpony.squidgrid.gui.gdx.SparseLayers;
import squidpony.squidgrid.gui.gdx.TextCellFactory;

public class Sprite implements Component {
    public char character;
    public Color foregroundColor;
    public TextCellFactory.Glyph glyph =null;
    public Sprite(JSONObject object){
        this.character = getChar((String)object.get("glyph"));
        this.foregroundColor = Colors.getColor((String)object.get("color"));
    }
    
    public TextCellFactory.Glyph makeGlyph(SparseLayers display, int gridX, int gridY)
    {
        if(glyph == null) 
            glyph = display.glyph(character, foregroundColor, gridX, gridY);
        else
            glyph.setPosition(display.worldX(gridX), display.worldY(gridY));
        return glyph;

    }

    private char getChar(String string){
        return string.charAt(0);
    }
}
