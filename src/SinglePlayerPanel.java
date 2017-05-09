/**
 * Created by Shao yu on 2017/5/4.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SinglePlayerPanel extends JPanel
{
    //-----------------------------------------------------------------
    //  Sets up this panel with two labels.
    //-----------------------------------------------------------------

    private JButton start,reset,clear,end;
    private JLabel tries, totalTries, games;
    private int avg = 0;
    private JTextField name;
    private GameTilePanel gamePanel;
    private JPanel buttonPanel;

    public SinglePlayerPanel()
    {
        start = new JButton("Start the Game");
        reset = new JButton("Reset the Game");
        clear = new JButton("Clear the Game");
        end = new JButton("End the System");
        name = new JTextField("Enter your name");

        setLayout(new BorderLayout());
        start.addActionListener(new ButtonListener());
        reset.addActionListener(new ButtonListener());
        clear.addActionListener(new ButtonListener());
        end.addActionListener(new ButtonListener());

        buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(130, 210, 225));
        buttonPanel.setLayout(new GridLayout(8, 1,5,5));
        buttonPanel.add(start);
        buttonPanel.add(reset);
        buttonPanel.add(clear);
        buttonPanel.add(end);

        tries = new JLabel("Tries:");
        totalTries = new JLabel("Total tries:");
        games = new JLabel("Games played:");
        buttonPanel.add(name);
        buttonPanel.add(totalTries);
        buttonPanel.add(tries);
        buttonPanel.add(games);

        add(buttonPanel, BorderLayout.LINE_END);
        gamePanel = new GameTilePanel();
        add(gamePanel, BorderLayout.CENTER);
    }
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == start)
            {
                if (name.getText().equals("Enter your name"))
                {
                    JOptionPane.showMessageDialog(new JDialog(),"Please enter your name!",
                            "Reminding", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    gamePanel.initGame();
                }
            }
            else if (event.getSource() == reset)
            {
                removeAll();
                add(new SinglePlayerPanel());
            }
            else if (event.getSource() == clear)
            {

            }
            else if (event.getSource() == end)
            {
                Window w = SwingUtilities.getWindowAncestor(SinglePlayerPanel.this);
                w.setVisible(false);
            }
        }
    }
}

