import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michael Farid on 2/10/2017.
 */
public class Calculator {

    private JPanel panel1;
    private JButton a7Button;
    private JButton a4Button;
    private JButton a1Button;
    private JButton percent;
    private JButton a9Button;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton a0Button;
    private JButton a3Button;
    private JButton a6Button;
    private JButton equal;
    private JButton divide;
    private JButton exponential;
    private JButton clearButton;
    private JButton multiply;
    private JButton subtract;
    private JButton addition;
    private JButton decimal;
    private JTextField textField1;
    private String screen = "";
    private String back = "";
    private String lastOperation = "";
    private String storedNumber = "";
    private boolean isResult = false;

    public Calculator() {
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeToScreen("0");
            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeToScreen("1");
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeToScreen("2");
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeToScreen("3");
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeToScreen("4");
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeToScreen("5");
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeToScreen("6");
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeToScreen("7");
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeToScreen("8");
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeToScreen("9");
            }
        });
        decimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!screen.contains(".")) {
                    screen = screen + ".";
                    textField1.setText(screen);
                    storedNumber = "";
                }
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screen = "";
                storedNumber = "";
                textField1.setText(screen);
            }
        });
        percent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double percent = Double.parseDouble(screen) / 100;
                screen = String.valueOf(percent);
                textField1.setText(screen);
            }
        });
        exponential.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputOperation("exp");
            }
        });

        subtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputOperation("sub");
            }
        });
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputOperation("mul");
            }
        });

        addition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputOperation("add");
            }
        });

        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputOperation("div");
            }
        });
        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lastOperation.equals("add")) {
                    double sum;
                    if (!storedNumber.equals("")) {
                        sum = Double.parseDouble(screen) + Double.parseDouble(storedNumber);
                    } else {
                        sum = Double.parseDouble(back) + Double.parseDouble(screen);
                        storedNumber = screen;
                    }
                    screen = String.valueOf(sum);
                    textField1.setText(screen);
                } else if (lastOperation.equals("sub")) {
                    double diff;
                    if (!storedNumber.equals("")) {
                        diff = Double.parseDouble(screen) - Double.parseDouble(storedNumber);
                    } else {
                        diff = Double.parseDouble(back) - Double.parseDouble(screen);
                        storedNumber = screen;
                    }
                    screen = String.valueOf(diff);
                    textField1.setText(screen);
                } else if (lastOperation.equals("div")) {
                    double quo;
                    if (!storedNumber.equals("")) {
                        quo = Double.parseDouble(screen) / Double.parseDouble(storedNumber);
                    } else {
                        quo = Double.parseDouble(back) / Double.parseDouble(screen);
                        storedNumber = screen;
                    }
                    screen = String.valueOf(quo);
                    textField1.setText(screen);
                } else if (lastOperation.equals("mul")) {
                    double pro;
                    if (!storedNumber.equals("")) {
                        pro = Double.parseDouble(screen) * Double.parseDouble(storedNumber);
                    } else {
                        pro = Double.parseDouble(back) * Double.parseDouble(screen);
                        storedNumber = screen;
                    }
                    screen = String.valueOf(pro);
                    textField1.setText(screen);
                } else if (lastOperation.equals("exp")) {
                    double pow;
                    if (!storedNumber.equals("")) {
                        pow = Math.pow(Double.parseDouble(screen), Double.parseDouble(storedNumber));
                    } else {
                        pow = Math.pow(Double.parseDouble(back), Double.parseDouble(screen));
                        storedNumber = screen;
                    }
                    screen = String.valueOf(pow);
                    textField1.setText(screen);
                }
                isResult = true;
            }

        });
    }

    void typeToScreen(String n) {
        if (screen.length() < 15 && !isResult) {
            screen = screen + n;
            textField1.setText(screen);
        } else {
            back = "";
            storedNumber = "";
            screen = n;
            textField1.setText(screen);
            isResult = false;
            lastOperation = "";
        }
    }

    void inputOperation(String n) {
        back = screen;
        screen = "";
        textField1.setText(back);
        lastOperation = n;

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
