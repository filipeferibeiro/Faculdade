package labirintoaleatorio;

import com.sun.xml.internal.ws.util.StringUtils;

public class Player {
    private String playerName;
    private int keys, life = 3, pos = 20;

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
    
    public Player(String playerName) {
        this.playerName = StringUtils.capitalize(playerName);
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public int getKeys() {
        return keys;
    }

    public void setKeys(int keys) {
        this.keys = keys;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void addKeys() {
        this.keys += 1;
    }

    public int getLife() {
        return life;
    }

    public void removeLife() {
        this.life -= 1;
    }
     
}