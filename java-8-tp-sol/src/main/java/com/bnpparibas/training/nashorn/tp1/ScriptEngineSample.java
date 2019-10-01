package com.bnpparibas.training.nashorn.tp1;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptEngineSample {
	public static void main(String[] args) {
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("nashorn");
		// evaluate JavaScript file
		try {
			engine.eval(new FileReader("src/main/resources/jjstest/test1.js"));
			engine.eval(new FileReader("src/main/resources/jjstest/test2.js"));
			engine.eval(new FileReader("src/main/resources/jjstest/stats.js"));
		} catch (FileNotFoundException | ScriptException e) {
			e.printStackTrace();
		}
	}
}
