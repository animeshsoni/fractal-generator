package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.image.IndexColorModel;

import javax.swing.*;

import code.*;
import edu.buffalo.fractal.FractalPanel;

public class UI {
	JFrame _window;
	JPanel _mainPanel;
	JMenuBar _menuBar;
	JMenu _menu1, _menu2, _menu3;
	JMenuItem _menuItem, _menuItem2;
	JRadioButtonMenuItem _manBrot, _julia, _burnShip, _mulBrot, _color1, _color2, _color3, _color4;
	JPanel _buttonGrid;
	ButtonGroup _group1, _group2;
	JPopupMenu escDist;
	FractalPanel _fracPan;
	FractalBase _fractal;
	IndexColorModel _color;

	public UI() {
	}

	public void initialize() {

		_window = new JFrame();
		_window.setPreferredSize(new Dimension(512, 584));
		_window.setLayout(new GridLayout(2, 1));
		_mainPanel = new JPanel();

		_fracPan = new FractalPanel();
		_fractal = new MandelBrot();

		_menuBar = new JMenuBar();
		_menu1 = new JMenu("File");

		_menu1.getAccessibleContext().setAccessibleDescription("The File Menu that has an exit option");

		_menuItem = new JMenuItem("Exit");

		_menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		_menuItem2 = new JMenuItem("Set Escape Distance");
		_menuItem2.addActionListener(new ActionListener() {
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

					} catch (NumberFormatException exception) {

						esc = JOptionPane.showInputDialog(_fracPan,
								"Enter Escape Distance\n" + "(an integer greater than 0)");
						if (esc == null) {
							return;
						}

					}
					if (escapeDist == 0) {
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

		_menu1.add(_menuItem2);
		_menu1.add(_menuItem);

		_menu2 = new JMenu("Fractal");
		_menu2.getAccessibleContext()
				.setAccessibleDescription("The File Menu that has 4 fractal options to choose from.");

		_group1 = new ButtonGroup();
		_group2 = new ButtonGroup();
		_manBrot = new JRadioButtonMenuItem("MandelBrot");

		_manBrot.setSelected(true);
		_manBrot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_fractal = new MandelBrot();
				update();
			}
		});
		_group1.add(_manBrot);
		_menu2.add(_manBrot);

		_julia = new JRadioButtonMenuItem("Julia");
		_julia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_fractal = new JuliaSet();
				update();
			}
		});
		_group1.add(_julia);
		_menu2.add(_julia);

		_burnShip = new JRadioButtonMenuItem("BurningShip");
		_burnShip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_fractal = new BurningShip();
				update();
			}
		});
		_group1.add(_burnShip);
		_menu2.add(_burnShip);

		_mulBrot = new JRadioButtonMenuItem("MultiBrot");
		_mulBrot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_fractal = new MultiBrot();
				update();
			}
		});
		_group1.add(_mulBrot);
		_menu2.add(_mulBrot);

		_menu3 = new JMenu("Color");
		_menu3.getAccessibleContext()
				.setAccessibleDescription("The File Menu that has 4 color options to choose from.");

		_color1 = new JRadioButtonMenuItem("Rainbow");
		_color1.setSelected(true);
		_color1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_color = ColorModelFactory.createRainbowColorModel(24);
				update();
			}
		});

		_group2.add(_color1);
		_menu3.add(_color1);

		_color2 = new JRadioButtonMenuItem("Blue");
		_color2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_color = ColorModelFactory.createBluesColorModel(24);
				update();
			}
		});
		_group2.add(_color2);
		_menu3.add(_color2);

		_color3 = new JRadioButtonMenuItem("Gray");
		_color3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_color = ColorModelFactory.createGrayColorModel(24);
				update();
			}
		});
		_group2.add(_color3);
		_menu3.add(_color3);

		_color4 = new JRadioButtonMenuItem("Purple");
		_color4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_color = ColorModelFactory.createPurpleColorModel(24);
				update();
			}
		});
		_group2.add(_color4);
		_menu3.add(_color4);

		_menuBar.add(_menu1);
		_menuBar.add(_menu2);
		_menuBar.add(_menu3);
		_mainPanel.add(_menuBar);
		_color = ColorModelFactory.createRainbowColorModel(24);
		_fracPan.setIndexColorModel(_color);
		_fracPan.updateImage(_fractal.escapeTimes());

		_window.setContentPane(_mainPanel);
		_window.add(_fracPan);
		_window.pack();
		_window.setVisible(true);

	}

	public void update() {
		_fracPan.setIndexColorModel(_color);
		_fracPan.updateImage(_fractal.escapeTimes());

	}

}
