import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    HashMap<String, Player> players = new HashMap<>();

    /**
     * Метод регистрации игрока, если игрок не зарегистрирован,
     * то он не сможет играть в турнире.
     * Вам нужно хранить всех зарегистрированных игроков в поле
     * класса Game в виде списка.
     */

    public void register(Player player) {
        if (players.get(player.getName()) != null) {
            throw new AlreadyRegisteredException("Player with name: " + player.getName() + " is already registered");
        }
        players.put(player.getName(), player);
    }

    public Player findByName(String name) {
        Player player = players.get(name);
        if (player == null) {
            throw new NotRegisteredException("Player with name: " + name + " is not registered");
        }
        return player;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return -1;
        } else {
            return 0;
        }
    }

    public HashMap<String, Player> findAllPlayers() {
        return players;
    }
}



