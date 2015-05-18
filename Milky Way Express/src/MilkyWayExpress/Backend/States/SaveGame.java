/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MilkyWayExpress.Backend.States;

import MilkyWayExpress.Backend.Game;
import MilkyWayExpress.Frontend.Console;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author woozlinux
 */
public class SaveGame implements IState {
    private final String stateName = "SaveGame";
    
    Game game;
    
    public SaveGame(Game g)
    {
        game = g;
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Console.saveMenu()));
            oos.writeObject(game);
            oos.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public IState mainMenu()
    {
        return new MainMenu(game);
    }
    
    @Override
    public IState newGame()
    {
        return new NewGame(game);
    }
    
    @Override
    public IState loadGame()
    {
        return new LoadGame(game);
    }
    
    @Override
    public IState saveGame()
    {
        return this;
    }
    
    @Override
    public IState move()
    {
        return new Move(game);
    }
    
    @Override
    public IState options()
    {
        return new Options(game);
    }
    
    @Override
    public IState movement()
    {
        return new Movement(game);
    }
    
    @Override
    public String getName()
    {
        return stateName;
    }
}