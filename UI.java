package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.image.IndexColorModel;

import javax.swing.*;

import code.*;
import edu.buffalo.fractal.FractalPanel;

/**
 * This class contains all the components of the GUI: Menu Bar, Drop Downs and
 * the Fractel Panel.
 * 
 * @author Animesh
 *
 */
/**
 * This class contains all the components of the GUI: Menu Bar, Drop Downs and
 * the Fractel Panel.
 * 
 * @author Animesh
 *
 */
public class UI extends MouseAdapter {

	/**
	 * x Low Value 
	 */
	int xL;
	/**
	 * x High Value
	 */
	int xH;
	/**
	 * y Low Value
	 */
	int yL;
	/**
	 * y High Value
	 */
	int yH;
	/**
	 * An instance of FractalPanel class to display the fractals.
	 */
	FractalPanel _fracPan = new FractalPanel();
	
	/**
	 * Variable of abstract class FractalBase which is assigned to the required
	 * fractal class instances when appropriate option is selected.
	 */
	FractalBase _fractal = new MandelBrot();

	/**
	 * An instance of IndexColorModel to use as an argument for
	 * setIndexColorModel method of FractalPanel and change it when appropriate
	 * option is selected.
	 */
	IndexColorModel _color;

	/**
	 * An instance variable of type int for the number of colors passed as an
	 * argument to create color model methods from fractal panel class
	 */
	int _numColor;

	/**
	 * Stores the string associated with every color model. Used the strings
	 * mainly for the extra functionality
	 */
	String _colorUpdate;

	/**
	 * The Constructor of UI class.
	 */

	JFrame _window;

	/**
	 * Constructor for UI
	 */
	public UI() {
		
	}

	/**
	 * This is the method which initializes everything; it shows the JFrame
	 * along with the required Panels, Menus, and Fractal.
	 */
	public void initialize() {

		_numColor = 256;
		_colorUpdate = "Rainbow";
		_fracPan.setSize(2048, 2048);
		// m = new MyListener();

		/*
		 * (non-Javadoc) Frame, Panels, MenuBar and Menus are instantiated
		 * below.
		 */

		JFrame _window = new JFrame("CSE 116 Project Phase 2 : B8-BB8");
		_window.setPreferredSize(new Dimension(512, 584));
		_window.setLayout(new GridLayout(2, 1));

		JPanel _mainPanel = new JPanel();

		_fracPan = new FractalPanel();

		_fractal = new MandelBrot();

		JMenuBar _menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		fileMenu.getAccessibleContext().setAccessibleDescription("The File Menu that has an exit option");

		JMenu fractalMenu = new JMenu("Fractal");
		fractalMenu.getAccessibleContext()
				.setAccessibleDescription("The File Menu that has 4 fractal options to choose from.");

		JMenu colorMenu = new JMenu("Color");
		colorMenu.getAccessibleContext()
				.setAccessibleDescription("The File Menu that has 4 color options to choose from.");

		/*
		 * (non-Javadoc) The code for two options in the file menu starts here.
		 */

		JMenuItem escDistButton = new JMenuItem("Set Escape Distance");
		escDistButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String esc = JOptionPane.showInputDialog(_fracPan,
						"Enter Escape Distance\n" + "(an integer greater than 0)");
				if (esc == null) {
					return;
				}
				Integer escapeDist;
				escapeDist = 0;

				while (escapeDist < 1) {

					try {
						escapeDist = Integer.parseInt(esc);
						if (escapeDist < 1) {
							esc = JOptionPane.showInputDialog(_fracPan,
									"Enter Escape Distance\n" + "(an integer greater than 0)");
							if (esc == null) {
								return;
							}
						}

					} catch (NumberFormatException exception) {

						esc = JOptionPane.showInputDialog(_fracPan,
								"Enter Escape Distance\n" + "(an integer greater than 0)");
						if (esc == null) {
							return;
						}

					}
				}

				FractalBase.setEscDist(escapeDist);
				update();

			};
		});
		fileMenu.add(escDistButton);

		JMenuItem escTimeButton = new JMenuItem("Set Maximum Escape Time");
		escTimeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String esc = JOptionPane.showInputDialog(_fracPan,
						"Enter Maximum Escape Time\n" + "(an integer greater than 0 and less than 256)");
				if (esc == null) {
					return;
				}
				Integer escapeTime;
				escapeTime = 0;

				while (escapeTime < 1 || escapeTime > 255) {

					try {
						escapeTime = Integer.parseInt(esc);
						if (escapeTime < 1 || escapeTime > 255) {
							esc = JOptionPane.showInputDialog(_fracPan,
									"Enter Escape Distance\n" + "(an integer greater than 0 and less than 256)");
							if (esc == null) {
								return;
							}
						}

					} catch (NumberFormatException exception) {

						esc = JOptionPane.showInputDialog(_fracPan,
								"Enter Escape Distance\n" + "(an integer greater than 0 and less than 256)");
						if (esc == null) {
							return;
						}

					}
				}

				FractalBase.setEscTime(escapeTime);
				update();

			};
		});
		fileMenu.add(escTimeButton);

		/*
		 * (non-Javadoc) The following method is for the extra functionality
		 * which can be used to change the int passed as an argument to
		 * indexColorModels. Its really cool how different the fractals look.
		 * Try it!!
		 */
		JMenuItem numColorButton = new JMenuItem("Set Number of Colors");
		numColorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] possibilities = { "5", "13", "24", "256" };
				String s = (String) JOptionPane.showInputDialog(_fracPan, "Choose the Number of Colors", "Input",
						JOptionPane.PLAIN_MESSAGE, null, possibilities, _numColor + "");
				if (s == null) {
					return;
				}
				int temp = Integer.parseInt(s);
				_numColor = temp;

				update();
			}

		});

		fileMenu.add(numColorButton);

		JMenuItem resetButton = new JMenuItem("Reset Zoom");
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_fractal.resetRange();
				update();
			}
		});
		fileMenu.add(resetButton);

		JMenuItem exitButton = new JMenuItem("Exit");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fileMenu.add(exitButton);

		/*
		 * (non-Javadoc) The code for the button group and the four fractal
		 * options in the fractal menu starts here.
		 */

		ButtonGroup fractals = new ButtonGroup();

		JRadioButtonMenuItem manBrot = new JRadioButtonMenuItem("MandelBrot");

		manBrot.setSelected(true);
		manBrot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_fractal = new MandelBrot();
				update();
			}
		});
		fractals.add(manBrot);
		fractalMenu.add(manBrot);

		JRadioButtonMenuItem julia = new JRadioButtonMenuItem("Julia");
		julia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_fractal = new JuliaSet();
				update();
			}
		});
		fractals.add(julia);
		fractalMenu.add(julia);

		JRadioButtonMenuItem burnShip = new JRadioButtonMenuItem("BurningShip");
		burnShip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_fractal = new BurningShip();
				update();
			}
		});
		fractals.add(burnShip);
		fractalMenu.add(burnShip);

		JRadioButtonMenuItem mulBrot = new JRadioButtonMenuItem("MultiBrot");
		mulBrot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_fractal = new MultiBrot();
				update();
			}
		});
		fractals.add(mulBrot);
		fractalMenu.add(mulBrot);

		/*
		 * (non-Javadoc) The code for the button group and the four color
		 * options in the fractal menu starts here.
		 */
		ButtonGroup colors = new ButtonGroup();

		JRadioButtonMenuItem rainbow = new JRadioButtonMenuItem("Rainbow");
		rainbow.setSelected(true);
		rainbow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_colorUpdate = "Rainbow";
				update();
			}
		});

		colors.add(rainbow);
		colorMenu.add(rainbow);

		JRadioButtonMenuItem blue = new JRadioButtonMenuItem("Blue");
		blue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_colorUpdate = "Blue";
				update();
			}
		});
		colors.add(blue);
		colorMenu.add(blue);
		JRadioButtonMenuItem gray = new JRadioButtonMenuItem("Gray");
		gray.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_colorUpdate = "Gray";
				update();
			}
		});
		colors.add(gray);
		colorMenu.add(gray);

		JRadioButtonMenuItem purple = new JRadioButtonMenuItem("Purple");
		purple.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_colorUpdate = "Purple";
				update();
			}
		});
		colors.add(purple);
		colorMenu.add(purple);

		/*
		 * (non-Javadoc) Adding everything to the required objects and packing
		 * the frame. See code below.
		 */
		_menuBar.add(fileMenu);
		_menuBar.add(fractalMenu);
		_menuBar.add(colorMenu);
		_mainPanel.add(_menuBar);
		_color = ColorModelFactory.createRainbowColorModel(_numColor);
		_fracPan.setIndexColorModel(_color);
		_fracPan.updateImage(_fractal.escapeTimes());
		_fracPan.addMouseListener(this);

		_window.setContentPane(_mainPanel);
		_window.add(_fracPan);
		_window.pack();
		_window.setVisible(true);

	}

	/**
	 * This method updates the fractal panel according to the fractal and color
	 * options selected by the user.
	 */
	public void update() {

		if (_colorUpdate.equals("Rainbow")) {
			_color = ColorModelFactory.createRainbowColorModel(_numColor);
		} else if (_colorUpdate.equals("Blue")) {
			_color = ColorModelFactory.createBluesColorModel(_numColor);
		} else if (_colorUpdate.equals("Gray")) {
			_color = ColorModelFactory.createGrayColorModel(_numColor);
		} else if (_colorUpdate.equals("Purple")) {
			_color = ColorModelFactory.createPurpleColorModel(_numColor);
		}

		_fracPan.setIndexColorModel(_color);
		_fracPan.updateImage(_fractal.escapeTimes());

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		xL = arg0.getX();
		yL = arg0.getY();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		xH = arg0.getX();
		yH = arg0.getY();
		if (xH > xL) {
			_fractal.updateXLow(_fractal.xCalc(xL));
			_fractal.updateXHigh(_fractal.xCalc(xH));
		} else {
			_fractal.updateXLow(_fractal.xCalc(xH));
			_fractal.updateXHigh(_fractal.xCalc(xL));
		}

		if (yH > yL) {
			_fractal.updateYLow(_fractal.yCalc(yL));
			_fractal.updateYHigh(_fractal.yCalc(yH));
		} else {
			_fractal.updateYLow(_fractal.yCalc(yH));
			_fractal.updateYHigh(_fractal.yCalc(yL));
		}

		update();

	}

}
