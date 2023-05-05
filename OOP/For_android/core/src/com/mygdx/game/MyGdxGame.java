package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.example.Main;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon, crossBowMan, mage, monk, peasant, rouge, sniper, spearMan;
	Music music;
	Main main;
	
	@Override
	public void create () {
		main = new Main();
		Main.team_1();
		Main.team_2();

		batch = new SpriteBatch();

		fon = new Texture("фоны/" + Fons.values()[new Random().nextInt(Fons.values().length)] + ".png");

		music = Gdx.audio.newMusic(Gdx.files.internal("Музыка/" + Mus.values()[new Random().nextInt(Mus.values().length)] + ".mp3"));
		music.setLooping(true);
		music.setVolume(0.25f);
		music.play();

		crossBowMan = new Texture("персонажи/CrossBowMan.png");
		mage = new Texture("персонажи/Mage.png");
		monk = new Texture("персонажи/Monk.png");
		peasant = new Texture("персонажи/Peasant.png");
		rouge = new Texture("персонажи/Rouge.png");
		sniper = new Texture("персонажи/Sniper.png");
		spearMan = new Texture("персонажи/SpearMan.png");

	}

	@Override
	public void render () {
		//Main.team_1();
		//Main.team_2();
		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) || Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
			Main.motion();
		}



		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		for (int i = Main.UNITS - 1; i >= 0 ; i--){

			batch.setColor(1, 1, 1, 1);
			if (Main.hero_light.get(i).getHp() <= 0) batch.setColor(Color.RED);
			if (Main.hero_darkness.get(i).getHp() <= 0) batch.setColor(Color.RED);
			int x1 = (Main.hero_light.get(i).getCoords()[0]) * Gdx.graphics.getWidth() / 11;
			int y1 = (Main.hero_light.get(i).getCoords()[1]-1) * Gdx.graphics.getHeight() / 11;
			int x2 = (Main.hero_darkness.get(i).getCoords()[0]) * Gdx.graphics.getWidth() / 11;
			int y2 = (Main.hero_darkness.get(i).getCoords()[1]-1) * Gdx.graphics.getHeight() / 11;

			switch (Main.hero_light.get(i).getInfo()){
				case "Маг - ":
					batch.draw(mage, x1, y1);
					break;
				case "Копейщик - ":
					batch.draw(spearMan, x1, y1);
					break;
				case "Арбалетчик - ":
					batch.draw(crossBowMan, x1, y1);
					break;
				case "Фермер - ":
					batch.draw(peasant, x1, y1);
					break;
			}
			switch (Main.hero_darkness.get(i).getInfo()){
				case "Волшебник - ":
					batch.draw(monk, x2, y2);
					break;
				case "Разбойник - ":
					batch.draw(rouge, x2, y2);
					break;
				case "Снайпер - ":
					batch.draw(sniper, x2, y2);
					break;
				case "Фермер - ":				// схема как развернуть персонаж
					Sprite sprite = new Sprite(peasant);
					sprite.setPosition(x2, y2);
					sprite.flip(true, false);
					sprite.draw(batch);
					break;
			}
		}
		batch.setColor(1, 1, 1, 1);
		batch.end();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		fon.dispose();
	}
}
