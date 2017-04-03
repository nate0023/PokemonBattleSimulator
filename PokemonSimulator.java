import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javax.swing.JTextField;
import javafx.scene.control.Button;
import java.util.*;
import javafx.geometry.Bounds;
import javafx.scene.image.*;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class PokemonSimulator extends Application {
	final Group group = new Group();
	final Scene scene = new Scene(group, 500, 500);
	public Circle[] dots = new Circle[100];
	public Random r = new Random();
	public Pokemon[] party;
	public Pokemon[] enemy;
	public Label enemyName;
	public Label partyName;
	public TextArea textField;
	public int partyFullHealth;
	public int enemyFullHealth;
	public Label partyHealthIndicator;
	public Label enemyHealthIndicator;
	public Rectangle enemyHealthFill;
	public Rectangle partyHealthFill;
	public Button attButton;
	public ToggleGroup moves;
	public RadioButton move1;
	public RadioButton move2;
	public RadioButton move3;
	public RadioButton move4;
	public int compRand;
	public boolean chosen = false;
	public int i = 0;
	public int j = 0;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		Label inst = new Label("Choose 5 Pokemon and then hit Enter...");
		inst.setLayoutX(10);
		inst.setLayoutY(5);
		group.getChildren().add(inst);

		ComboBox poke1 = new ComboBox();
		poke1.setLayoutX(0);
		poke1.setLayoutY(30);
		poke1.setMinWidth(100.0);
		poke1.setPrefWidth(poke1.getMinWidth());
		poke1.getItems().addAll("Charizard", "Blastoise", "Venusaur", "Arcanine", "Dragonite", "Gengar", "Gyarados",
				"Hitmonchan", "Machamp", "Mew", "Pidgeot", "Pikachu", "Rhydon", "Snorlax", "Zubat");

		poke1.setEditable(true);
		poke1.setValue("Charizard");
		group.getChildren().add(poke1);

		ComboBox poke2 = new ComboBox();
		poke2.setMinWidth(100.0);
		poke2.setPrefWidth(poke2.getMinWidth());
		poke2.setLayoutX(100);
		poke2.setLayoutY(30);
		poke2.getItems().addAll("Charizard", "Blastoise", "Venusaur", "Arcanine", "Dragonite", "Gengar", "Gyarados",
				"Hitmonchan", "Machamp", "Mew", "Pidgeot", "Pikachu", "Rhydon", "Snorlax", "Zubat");

		poke2.setEditable(true);
		poke2.setValue("Charizard");
		group.getChildren().add(poke2);

		ComboBox poke3 = new ComboBox();
		poke3.setMinWidth(100.0);
		poke3.setPrefWidth(poke3.getMinWidth());
		poke3.setLayoutY(30);
		poke3.setLayoutX(200);
		poke3.getItems().addAll("Charizard", "Blastoise", "Venusaur", "Arcanine", "Dragonite", "Gengar", "Gyarados",
				"Hitmonchan", "Machamp", "Mew", "Pidgeot", "Pikachu", "Rhydon", "Snorlax", "Zubat");

		poke3.setEditable(true);
		poke3.setValue("Charizard");
		group.getChildren().add(poke3);

		ComboBox poke4 = new ComboBox();
		poke4.setLayoutX(300);
		poke4.setLayoutY(30);
		poke4.setMinWidth(100.0);
		poke4.setPrefWidth(poke4.getMinWidth());
		poke4.getItems().addAll("Charizard", "Blastoise", "Venusaur", "Arcanine", "Dragonite", "Gengar", "Gyarados",
				"Hitmonchan", "Machamp", "Mew", "Pidgeot", "Pikachu", "Rhydon", "Snorlax", "Zubat");

		poke4.setEditable(true);
		poke4.setValue("Charizard");
		group.getChildren().add(poke4);

		ComboBox poke5 = new ComboBox();
		poke5.setLayoutX(400);
		poke5.setLayoutY(30);
		poke5.setMinWidth(100.0);
		poke5.setPrefWidth(poke5.getMinWidth());
		poke5.getItems().addAll("Charizard", "Blastoise", "Venusaur", "Arcanine", "Dragonite", "Gengar", "Gyarados",
				"Hitmonchan", "Machamp", "Mew", "Pidgeot", "Pikachu", "Rhydon", "Snorlax", "Zubat");

		poke5.setEditable(true);
		poke5.setValue("Charizard");
		group.getChildren().add(poke5);

		Button bt = new Button("Enter");
		bt.setLayoutX(0);
		bt.setLayoutY(65);
		group.getChildren().add(bt);

		bt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String choice1 = poke1.getValue().toString();
				String choice2 = poke2.getValue().toString();
				String choice3 = poke3.getValue().toString();
				String choice4 = poke4.getValue().toString();
				String choice5 = poke5.getValue().toString();

				group.getChildren().remove(poke1);
				group.getChildren().remove(poke2);
				group.getChildren().remove(poke3);
				group.getChildren().remove(poke4);
				group.getChildren().remove(poke5);
				group.getChildren().remove(inst);
				group.getChildren().remove(bt);

				party = new Pokemon[5];
				party[0] = new Pokemon(choice1);
				party[1] = new Pokemon(choice2);
				party[2] = new Pokemon(choice3);
				party[3] = new Pokemon(choice4);
				party[4] = new Pokemon(choice5);

				enemy = new Pokemon[5];
				enemy[0] = new Pokemon(r.nextInt(15) + "");
				enemy[1] = new Pokemon(r.nextInt(15) + "");
				enemy[2] = new Pokemon(r.nextInt(15) + "");
				enemy[3] = new Pokemon(r.nextInt(15) + "");
				enemy[4] = new Pokemon(r.nextInt(15) + "");

				battle();

			}
		});
		stage.setScene(scene);
		stage.show();
	}

	public class Pokemon {
		private int health;
		private int strength;
		private int speed;
		private String type;
		private String name;
		private String move1;
		private String move2;
		private String move3;
		private String move4;
		private int move1DMG;
		private int move2DMG;
		private int move3DMG;
		private int move4DMG;
		ImageView image;

		public Pokemon(String name) {
			this.name = name;
			setStats();
		}

		public void setStats() {
			if (name.contains("Charizard") || name.contains("0")) {
				image = new ImageView();
				Image image1;
				if (name.contains("Charizard")) {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/charizard-back.png"));
				} else {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/charizard-front.png"));

				}
				image.setImage(image1);
				if (name.contains("Charizard")) {
					image.setLayoutX(0);
					image.setLayoutY(250);
				} else {
					image.setLayoutX(325);
					image.setLayoutY(25);
					name = "Charizard";
				}
				health = 297;
				strength = 50;
				speed = 30;
				type = "Fire";
				move1 = "Flamethrower";
				move1DMG = 95;
				move2 = "Fire Blast";
				move2DMG = 120;
				move3 = "Slash";
				move3DMG = 70;
				move4 = "Hyper Beam";
				move4DMG = 150;
			}
			if (name.contains("Blastoise") || name.contains("1")) {
				image = new ImageView();
				Image image1;
				if (name.contains("Blastoise")) {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/blastoise-back.png"));
				} else {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/blastoise-front.png"));

				}
				image.setImage(image1);
				if (name.contains("Blastoise")) {
					image.setLayoutX(0);
					image.setLayoutY(250);
				} else {
					image.setLayoutX(325);
					image.setLayoutY(25);
					name = "Blastoise";
				}
				health = 299;
				strength = 45;
				speed = 35;
				type = "Water";
				move1 = "Surf";
				move1DMG = 95;
				move2 = "Hydro Pump";
				move2DMG = 120;
				move3 = "Crunch";
				move3DMG = 60;
				move4 = "Skull Bash";
				move4DMG = 100;

			}
			if (name.contains("Venusaur") || name.contains("2")) {
				image = new ImageView();
				Image image1;
				if (name.contains("Venusaur")) {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/venusaur-back.png"));
				} else {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/venusaur-front.png"));

				}
				image.setImage(image1);
				if (name.contains("Venusaur")) {
					image.setLayoutX(0);
					image.setLayoutY(250);
				} else {
					image.setLayoutX(325);
					image.setLayoutY(25);
					name = "Venusaur";
				}
				health = 301;
				strength = 40;
				speed = 35;
				type = "Grass";
				move1 = "Vine Whip";
				move1DMG = 35;
				move2 = "Razor Leaf";
				move2DMG = 55;
				move3 = "Solar Beam";
				move3DMG = 120;
				move4 = "Hyper Beam";
				move4DMG = 150;
			}
			if (name.contains("Dragonite") || name.contains("3")) {
				image = new ImageView();
				Image image1;
				if (name.contains("Dragonite")) {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/dragonite-back.png"));
				} else {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/dragonite-front.png"));

				}
				image.setImage(image1);
				if (name.contains("Dragonite")) {
					image.setLayoutX(0);
					image.setLayoutY(250);
				} else {
					image.setLayoutX(325);
					image.setLayoutY(25);
					name = "Dragonite";
				}
				health = 323;
				strength = 40;
				speed = 35;
				type = "flying";
				move1 = "Slam";
				move1DMG = 65;
				move2 = "Wing Attack";
				move2DMG = 65;
				move3 = "Dragon Rage";
				move3DMG = 95;
				move4 = "Hyper Beam";
				move4DMG = 150;
			}
			if (name.contains("Mew") || name.contains("4")) {
				image = new ImageView();
				Image image1;
				if (name.contains("Mew")) {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/mew-back.png"));
				} else {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/mew-front.png"));

				}
				image.setImage(image1);
				if (name.contains("Mew")) {
					image.setLayoutX(0);
					image.setLayoutY(250);
				} else {
					image.setLayoutX(325);
					image.setLayoutY(25);
					name = "Mew";
				}
				health = 341;
				strength = 40;
				speed = 35;
				type = "Psychic";
				move1 = "Mega Punch";
				move1DMG = 100;
				move2 = "Psychic";
				move2DMG = 140;
				move3 = "Blizzard";
				move3DMG = 95;
				move4 = "Tri Attack";
				move4DMG = 110;
			}
			if (name.contains("Snorlax") || name.contains("5")) {
				image = new ImageView();
				Image image1;
				if (name.contains("Snorlax")) {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/snorlax-back.png"));
				} else {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/snorlax-front.png"));

				}
				image.setImage(image1);
				if (name.contains("Snorlax")) {
					image.setLayoutX(0);
					image.setLayoutY(250);
				} else {
					image.setLayoutX(325);
					image.setLayoutY(25);
					name = "Snorlax";
				}
				health = 461;
				strength = 40;
				speed = 35;
				type = "Normal";
				move1 = "Body Slam";
				move1DMG = 120;
				move2 = "Double Edge";
				move2DMG = 110;
				move3 = "Take Down";
				move3DMG = 95;
				move4 = "Skull Bash";
				move4DMG = 115;
			}
			if (name.contains("Pikachu") || name.contains("6")) {
				image = new ImageView();
				Image image1;
				if (name.contains("Pikachu")) {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/pikachu-back.png"));
				} else {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/pikachu-front.png"));

				}
				image.setImage(image1);
				if (name.contains("Pikachu")) {
					image.setLayoutX(0);
					image.setLayoutY(250);
				} else {
					image.setLayoutX(325);
					image.setLayoutY(25);
					name = "Pikachu";
				}
				health = 299;
				strength = 40;
				speed = 35;
				type = "Electric";
				move1 = "Thunder";
				move1DMG = 135;
				move2 = "Thunder Bolt";
				move2DMG = 120;
				move3 = "Body Slam";
				move3DMG = 110;
				move4 = "Swift";
				move4DMG = 90;
			}
			if (name.contains("Gengar") || name.contains("7")) {
				image = new ImageView();
				Image image1;
				if (name.contains("Gengar")) {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/gengar-back.png"));
				} else {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/gengar-front.png"));

				}
				image.setImage(image1);
				if (name.contains("Gengar")) {
					image.setLayoutX(0);
					image.setLayoutY(250);
				} else {
					image.setLayoutX(325);
					image.setLayoutY(25);
					name = "Gengar";
				}
				health = 261;
				strength = 40;
				speed = 35;
				type = "Psychic";
				move1 = "Lick";
				move1DMG = 90;
				move2 = "Psychic";
				move2DMG = 140;
				move3 = "Dream Eater";
				move3DMG = 110;
				move4 = "PsyBeam";
				move4DMG = 120;
			}
			if (name.contains("Arcanine") || name.contains("8")) {
				image = new ImageView();
				Image image1;
				if (name.contains("Arcanine")) {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/arcanine-back.png"));
				} else {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/arcanine-front.png"));

				}
				image.setImage(image1);
				if (name.contains("Arcanine")) {
					image.setLayoutX(0);
					image.setLayoutY(250);
				} else {
					image.setLayoutX(325);
					image.setLayoutY(25);
					name = "Arcanine";
				}
				health = 321;
				strength = 40;
				speed = 35;
				type = "Fire";
				move1 = "Flamethrower";
				move1DMG = 100;
				move2 = "Fire Blast";
				move2DMG = 140;
				move3 = "Take Down";
				move3DMG = 105;
				move4 = "Body Slam";
				move4DMG = 110;
			}
			if (name.contains("Gyarados") || name.contains("9")) {
				image = new ImageView();
				Image image1;
				if (name.contains("Gyarados")) {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/gyarados-back.png"));
				} else {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/gyarados-front.png"));

				}
				image.setImage(image1);
				if (name.contains("Gyarados")) {
					image.setLayoutX(0);
					image.setLayoutY(250);
				} else {
					image.setLayoutX(325);
					image.setLayoutY(25);
					name = "Gyarados";
				}
				health = 331;
				strength = 40;
				speed = 35;
				type = "Water";
				move1 = "Surf";
				move1DMG = 100;
				move2 = "Hydro Pump";
				move2DMG = 140;
				move3 = "Dragon Rage";
				move3DMG = 110;
				move4 = "Hyper Beam";
				move4DMG = 145;
			}
			if (name.contains("Hitmonchan") || name.contains("10")) {
				image = new ImageView();
				Image image1;
				if (name.contains("Hitmonchan")) {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/hitmonchan-back.png"));
				} else {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/hitmonchan-front.png"));

				}
				image.setImage(image1);
				if (name.contains("Hitmonchan")) {
					image.setLayoutX(0);
					image.setLayoutY(250);
				} else {
					image.setLayoutX(325);
					image.setLayoutY(25);
					name = "Hitmonchan";
				}
				health = 241;
				strength = 40;
				speed = 35;
				type = "fighting";
				move1 = "Mega Punch";
				move1DMG = 140;
				move2 = "Ice Punch";
				move2DMG = 130;
				move3 = "Fire Punch";
				move3DMG = 125;
				move4 = "Thunder Punch";
				move4DMG = 135;
			}
			if (name.contains("Machamp") || name.contains("11")) {
				image = new ImageView();
				Image image1;
				if (name.contains("Machamp")) {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/machamp-back.png"));
				} else {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/machamp-front.png"));

				}
				image.setImage(image1);
				if (name.contains("Machamp")) {
					image.setLayoutX(0);
					image.setLayoutY(250);
				} else {
					image.setLayoutX(325);
					image.setLayoutY(25);
					name = "Machamp";
				}
				health = 321;
				strength = 40;
				speed = 35;
				type = "Fighting";
				move1 = "Seismic Toss";
				move1DMG = 130;
				move2 = "Mega Punch";
				move2DMG = 135;
				move3 = "Body Slam";
				move3DMG = 120;
				move4 = "Submission";
				move4DMG = 145;
			}
			if (name.contains("Pidgeot") || name.contains("12")) {
				image = new ImageView();
				Image image1;
				if (name.contains("Pidgeot")) {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/pidgeot-back.png"));
				} else {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/pidgeot-front.png"));

				}
				image.setImage(image1);
				if (name.contains("Pidgeot")) {
					image.setLayoutX(0);
					image.setLayoutY(250);
				} else {
					image.setLayoutX(325);
					image.setLayoutY(25);
					name = "Pidgeot";
				}
				health = 307;
				strength = 40;
				speed = 35;
				type = "Flying";
				move1 = "Gust";
				move1DMG = 90;
				move2 = "Fly";
				move2DMG = 130;
				move3 = "Wing Attack";
				move3DMG = 120;
				move4 = "Air Slash";
				move4DMG = 135;
			}
			if (name.contains("Rhydon") || name.contains("13")) {
				image = new ImageView();
				Image image1;
				if (name.contains("Rhydon")) {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/rhydon-back.png"));
				} else {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/rhydon-front.png"));

				}
				image.setImage(image1);
				if (name.contains("Rhydon")) {
					image.setLayoutX(0);
					image.setLayoutY(250);
				} else {
					image.setLayoutX(325);
					image.setLayoutY(25);
					name = "Rhydon";
				}
				health = 351;
				strength = 40;
				speed = 35;
				type = "Normal";
				move1 = "Horn Drill";
				move1DMG = 150;
				move2 = "Take Down";
				move2DMG = 110;
				move3 = "Stomp";
				move3DMG = 105;
				move4 = "Body Slam";
				move4DMG = 120;
			}
			if (name.contains("Zubat") || name.contains("14")) {
				image = new ImageView();
				Image image1;
				if (name.contains("Zubat")) {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/zubat-back.png"));
				} else {
					image1 = new Image(PokemonSimulator.class.getResourceAsStream("images/zubat-front.png"));

				}
				image.setImage(image1);
				if (name.contains("Zubat")) {
					image.setLayoutX(0);
					image.setLayoutY(250);
				} else {
					image.setLayoutX(325);
					image.setLayoutY(25);
					name = "Zubat";
				}
				health = 550;
				strength = 40;
				speed = 35;
				type = "Insane";
				move1 = "Hyper Beam";
				move1DMG = 130;
				move2 = "Hyper Beam";
				move2DMG = 130;
				move3 = "Hyper Beam";
				move3DMG = 130;
				move4 = "Hyper Beam";
				move4DMG = 130;
			}

		}
	}

	public void battle() {

		int partyHealth = party[i].health;
		int enemyHealth = enemy[j].health;
		partyFullHealth = party[i].health;
		enemyFullHealth = enemy[j].health;

		Rectangle partyHealthOutline = new Rectangle();
		partyHealthOutline.setX(350);
		partyHealthOutline.setY(350);
		partyHealthOutline.setWidth(125);
		partyHealthOutline.setHeight(20);
		partyHealthOutline.setStroke(Color.BLACK);
		partyHealthOutline.setFill(Color.TRANSPARENT);
		group.getChildren().add(partyHealthOutline);

		partyHealthFill = new Rectangle();
		partyHealthFill.setX(351);
		partyHealthFill.setY(351);
		partyHealthFill.setWidth(123);
		partyHealthFill.setHeight(18);
		partyHealthFill.setFill(Color.BLACK);
		group.getChildren().add(partyHealthFill);

		Rectangle enemyHealthOutline = new Rectangle();
		enemyHealthOutline.setX(25);
		enemyHealthOutline.setY(25);
		enemyHealthOutline.setWidth(125);
		enemyHealthOutline.setHeight(20);
		enemyHealthOutline.setStroke(Color.BLACK);
		enemyHealthOutline.setFill(Color.TRANSPARENT);
		group.getChildren().add(enemyHealthOutline);

		enemyHealthFill = new Rectangle();
		enemyHealthFill.setX(26);
		enemyHealthFill.setY(26);
		enemyHealthFill.setWidth(123);
		enemyHealthFill.setHeight(18);
		enemyHealthFill.setFill(Color.BLACK);
		group.getChildren().add(enemyHealthFill);

		partyName = new Label(party[i].name);
		partyName.setLayoutX(350);
		partyName.setLayoutY(330);
		group.getChildren().add(partyName);

		enemyName = new Label(enemy[j].name);
		enemyName.setLayoutX(25);
		enemyName.setLayoutY(5);
		group.getChildren().add(enemyName);

		partyHealthIndicator = new Label(partyHealth + " / " + partyFullHealth);
		partyHealthIndicator.setLayoutX(350);
		partyHealthIndicator.setLayoutY(375);
		group.getChildren().add(partyHealthIndicator);

		enemyHealthIndicator = new Label(enemyHealth + " / " + enemyFullHealth);
		enemyHealthIndicator.setLayoutX(25);
		enemyHealthIndicator.setLayoutY(50);
		group.getChildren().add(enemyHealthIndicator);

		textField = new TextArea();
		textField.setPrefWidth(350);
		textField.setPrefHeight(100);
		textField.setLayoutX(0);
		textField.setLayoutY(400);
		group.getChildren().add(textField);

		attButton = new Button("Attack");
		attButton.setLayoutX(400);
		attButton.setLayoutY(475);
		group.getChildren().add(attButton);
		attButton.setDisable(true);

		ToggleGroup moves = new ToggleGroup();
		move1 = new RadioButton("");
		move1.setToggleGroup(moves);
		move1.setSelected(true);
		move1.setLayoutX(360);
		move1.setLayoutY(400);
		move2 = new RadioButton("");
		move2.setToggleGroup(moves);
		move2.setLayoutX(360);
		move2.setLayoutY(418);
		move3 = new RadioButton("");
		move3.setToggleGroup(moves);
		move3.setLayoutX(360);
		move3.setLayoutY(436);
		move4 = new RadioButton("");
		move4.setToggleGroup(moves);
		move4.setLayoutX(360);
		move4.setLayoutY(454);
		group.getChildren().add(move1);
		group.getChildren().add(move2);
		group.getChildren().add(move3);
		group.getChildren().add(move4);

		group.getChildren().add(party[i].image);
		group.getChildren().add(enemy[j].image);
		move1.setText(party[i].move1);
		move2.setText(party[i].move2);
		move3.setText(party[i].move3);
		move4.setText(party[i].move4);

		textField.appendText("\nYou sent out " + party[i].name);
		textField.appendText("\nThe computer sent out " + enemy[j].name);
		textField.appendText("\nYou have started a battle against the Computer...");
		attButton.setDisable(false);

		textField.appendText("\nPlease choose an attack to the right and then hit enter");
		attButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				textField.appendText("\nYou attacked");

				if (move1.isSelected()) {
					double temp = (enemy[j].health - party[i].move1DMG);
					temp = temp / enemy[j].health * 123;
					enemy[j].health = enemy[j].health - party[i].move1DMG;
					enemyHealthFill.setWidth(temp);
				} else if (move2.isSelected()) {
					double temp = (enemy[j].health - party[i].move2DMG);
					temp = temp / enemy[j].health * 123;
					enemy[j].health = enemy[j].health - party[i].move2DMG;
					enemyHealthFill.setWidth(temp);
				} else if (move3.isSelected()) {
					double temp = (enemy[j].health - party[i].move3DMG);
					temp = temp / enemy[j].health * 123;
					enemy[j].health = enemy[j].health - party[i].move3DMG;
					enemyHealthFill.setWidth(temp);
				} else {
					double temp = (enemy[j].health - party[i].move4DMG);
					temp = temp / enemy[j].health * 123;
					enemy[j].health = enemy[j].health - party[i].move4DMG;
					enemyHealthFill.setWidth(temp);
				}

				enemyHealthIndicator.setText(enemy[j].health + " / " + enemyFullHealth);

				if (enemy[j].health <= 0) {
					enemy[j].health = 0;
					textField.setText(enemy[j].name + " has fainted.");
					nextPoke("enemy");
					enemyHealthIndicator.setText(enemy[j].health + " / " + enemyFullHealth);
				}

				if (enemy[j].health > 0) {
					int p = r.nextInt(4);
					attButton.setDisable(true);
					if (p == 0) {
						textField.appendText("\n" + enemy[j].name + " used " + enemy[j].move1);

						double temp = (party[i].health - enemy[j].move1DMG);
						temp = temp / party[i].health * 123;
						party[i].health = party[i].health - enemy[j].move1DMG;
						partyHealthFill.setWidth(temp);
					} else if (p == 1) {
						textField.appendText("\n" + enemy[j].name + " used " + enemy[j].move2);

						double temp = (party[i].health - enemy[j].move2DMG);
						temp = temp / party[i].health * 123;
						party[i].health = party[i].health - enemy[j].move2DMG;
						partyHealthFill.setWidth(temp);
					} else if (p == 2) {
						textField.appendText("\n" + enemy[j].name + " used " + enemy[j].move3);

						double temp = (party[i].health - enemy[j].move3DMG);
						temp = temp / party[i].health * 123;
						party[i].health = party[i].health - enemy[j].move3DMG;
						partyHealthFill.setWidth(temp);

					} else {
						textField.appendText("\n" + enemy[j].name + " used " + enemy[j].move4);

						double temp = (party[i].health - enemy[j].move4DMG);
						temp = temp / party[i].health * 123;
						party[i].health = party[i].health - enemy[j].move4DMG;
						partyHealthFill.setWidth(temp);

					}
					partyHealthIndicator.setText(party[i].health + " / " + partyFullHealth);

					if (party[i].health <= 0) {
						party[i].health = 0;
						textField.setText(party[i].name + " has fainted.");
						attButton.setDisable(true);
						nextPoke("party");
						partyHealthIndicator.setText(party[i].health + " / " + partyFullHealth);
					}
				}

				if (enemy[j].health > 0 && party[i].health > 0) {
					textField.appendText("\nPlease choose an attack to the right and then hit enter");
					attButton.setDisable(false);
				}
			}
		});
	}

	public void nextPoke(String id) {
		if (id.contains("party")) {
			i++;
			if (i < 5) {
				group.getChildren().add(party[i].image);
				partyName.setText(party[i].name);
				partyFullHealth = party[i].health;
				textField.appendText("\nYou sent out " + party[i].name);
				partyHealthFill.setWidth(123);
				move1.setText(party[i].move1);
				move2.setText(party[i].move2);
				move3.setText(party[i].move3);
				move4.setText(party[i].move4);
			} else {
				textField.setText("You are out of usable pokemon. You lost...");
				partyHealthIndicator.setText(0 + " / " + partyFullHealth);
				attButton.setDisable(true);
			}

		} else {
			j++;
			if (j < 5) {
				group.getChildren().add(enemy[j].image);
				enemyName.setText(enemy[j].name);
				enemyFullHealth = enemy[j].health;
				enemyHealthFill.setWidth(123);
				textField.appendText("\nEnemy sent out " + enemy[j].name);
			} else {

				textField.setText("Enemy is out of pokemon. You Win!");
				enemyHealthIndicator.setText(0 + " / " + enemyFullHealth);
				attButton.setDisable(true);

			}
		}
	}
}