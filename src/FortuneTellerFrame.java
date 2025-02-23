import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JLabel titleLabel;
    private JTextArea fortuneArea;
    private JButton readFortuneButton;
    private JButton quitButton;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon("fortune2.png");
        titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        topPanel.add(titleLabel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        fortuneArea = new JTextArea();
        fortuneArea.setFont(new Font("Serif", Font.PLAIN, 24));
        fortuneArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.setFont(new Font("Serif", Font.PLAIN, 24));
        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Serif", Font.PLAIN, 24));
        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        readFortuneButton.addActionListener(this::readFortune);
        quitButton.addActionListener(e -> System.exit(0));

        initializeFortunes();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
        setLocationRelativeTo(null);
    }

    private void initializeFortunes() {
        fortunes = new ArrayList<>();
        fortunes.add("You will have a great day!");
        fortunes.add("A surprise is waiting for you.");
        fortunes.add("You will meet someone special.");
        fortunes.add("Good fortune is coming your way.");
        fortunes.add("You will achieve your goals.");
        fortunes.add("Happiness is in your future.");
        fortunes.add("Expect the unexpected.");
        fortunes.add("You will find what you seek.");
        fortunes.add("A new opportunity will arise.");
        fortunes.add("You will make a new friend.");
        fortunes.add("Success is in your future.");
        fortunes.add("You will have a pleasant surprise.");
    }

    private void readFortune(ActionEvent e) {
        Random random = new Random();
        int index;
        do {
            index = random.nextInt(fortunes.size());
        } while (index == lastFortuneIndex);
        lastFortuneIndex = index;
        fortuneArea.append(fortunes.get(index) + "\n");
    }
}
