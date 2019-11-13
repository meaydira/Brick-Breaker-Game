package gui;

import game_engine.Game;
import game_engine.GameConstants;
import game_engine.GameStatus;
import game_engine.MapGenerator;
import model.bricks.Brick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements GameConstants, KeyListener, ActionListener {


    private static GamePanel game_instance = null;
    private Game currentGame;
    private Timer timer;
    private int delay = 2;
    private JButton pauseButton;

    public static GamePanel getInstance(Game game) {
        if (game_instance == null) {
            game_instance = new GamePanel();
            game_instance.currentGame = game;
            game_instance.setLayout(new GridLayout());
            game_instance.addKeyListener(game_instance);
            game_instance.setFocusable(true);
            game_instance.setFocusTraversalKeysEnabled(false);
            game_instance.timer = new Timer(game_instance.delay, game_instance);
            game_instance.timer.start();
            return game_instance;
        } else {
            return game_instance;
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
//        Image img = Toolkit.getDefaultToolkit().getImage("background.jpg");
//        super.paintComponent(g);
//        g.drawImage(img, 0, 0, null);
    }

    public void paint(Graphics g) {
//      paintComponent(g);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.getHeight();
        screenSize.getWidth();

        fillGameBackground(g);
        fillGamePanelBackground(g);

        // drawing map

        for (Brick b : currentGame.getMap().getBricks()) {

            if (!b.isDestroyed()) {
                g.setColor(b.getColor());
                g.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());
            }
            // this is just to show separate brick, game can still run without it

//               g.setStroke(new BasicStroke(3));
               g.setColor(Color.black);
               g.drawRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());


        }

        g.setColor(Color.white);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

        // the scores
        drawScores(g, 25, "Score : ", 700, 30, Color.BLACK);

        //help sign
        String action = (currentGame.isRunning()) ? "Pause" : "Continue";
        drawText(g, 14, "Press Enter to " + action, 700, PADDLE_Y_START, Color.BLACK);

        // the paddle
        drawPaddle(g);

        // the ball
        drawBall(g);

        // when you won the game
        if (currentGame.getStatus() == GameStatus.Won) {
            drawText(g, 30, "You Won", 260, 300, Color.white);
            drawText(g, 20, "Press (Enter) to Restart", 230, 380, Color.white);
        }

        // when you lose the game
        if (currentGame.getStatus() == GameStatus.Lost) {
            showGameOverSign(g);
            drawText(g, 20, "Press (Enter) to Restart", 230, 380, Color.white);
        }

        g.dispose();

    }

    private void drawText(Graphics g, int fontSize, String s, int x, int y, Color color) {
        g.setColor(color);
        g.setFont(new Font("serif", Font.BOLD, fontSize));
        g.drawString(s, x, y);
    }

    private void fillGameBackground(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);
    }

    private void fillGamePanelBackground(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(693, 1, 899, 592);
    }

    private void drawScores(Graphics g, int fontsize, String text, int x, int y, Color color) {
        drawText(g, fontsize, text + currentGame.getScore(), x, y, color);
    }

    private void showGameOverSign(Graphics g) {
        drawText(g, 25, "Game Over", 290, 350, Color.white);
    }

    private void drawPaddle(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(currentGame.getPaddle().getXpos(), PADDLE_Y_START, currentGame.getPaddle().getWidth(), PADDLE_HEIGHT);
    }

    private void drawBall(Graphics g) {
        g.setColor(currentGame.getBall().getColor());
        g.fillOval(currentGame.getBall().getX(), currentGame.getBall().getY(), BALL_WIDTH, BALL_HEIGHT);
    }

    private void drawBrickBackground(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            currentGame.moveRight();
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            currentGame.moveLeft();
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!currentGame.isRunning()) {
                currentGame.reinitialize();
                repaint();
            } else {
                currentGame.switchMode();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            //change paddle angle negatively
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            //change paddle angle positively
        }

    }


    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void actionPerformed(ActionEvent e) {

        timer.start();
        boolean directionLock =false;
        if (currentGame.isRunning()) {
            // check map collision with the ball
            currentGame.runPhysics();
        }
        repaint();
    }

}
